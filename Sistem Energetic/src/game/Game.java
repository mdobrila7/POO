package game;

import game.entity.Consumer;
import game.entity.Contract;
import game.entity.Distributor;
import io.Input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Game {
    private static Game instance;
    private List<Consumer> consumers;
    private List<Distributor> distributors;
    private List<Contract> expiredContracts;
    private List<Contract> bankruptContracts;
    private Game() { }

    public List<Consumer> getConsumers() {
        return consumers;
    }

    public List<Distributor> getDistributors() {
        return distributors;
    }

    public void setInitialData(final Consumer[] newConsumers, final Distributor[] newDistributors) {
        this.consumers = new ArrayList<>(Arrays.asList(newConsumers));
        this.distributors = new ArrayList<>(Arrays.asList(newDistributors));
        this.expiredContracts = new ArrayList<>();
        this.bankruptContracts = new ArrayList<>();
        for (Consumer consumer : this.consumers) {
            consumer.init();
        }
        for (Distributor distributor : this.distributors) {
            distributor.init(this.consumers);
        }
    }

    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    public void makeTurn() {
        for (Contract contract : bankruptContracts) {
            consumers.get(contract.getConsumerId()).removeDistributor();
        }
        for (Distributor distributor : distributors) {
            distributor.monthlyContractValue();
        }
        // Get consumers income
        for (Consumer consumer : consumers) {
            consumer.addMonthlyIncome();
        }
        for (Contract contract : expiredContracts) {
            consumers.get(contract.getConsumerId()).removeDistributor();
        }
        // Find Distributor
        for (Consumer consumer : consumers) {
            for (Distributor distributor : distributors) {
                consumer.compareAndSet(distributor);
            }
        }
        // Notify the distributor
        for (Consumer consumer : consumers) {
            consumer.acceptDistributor();
        }
        for (Distributor distributor : distributors) {
            distributor.getContracts().removeAll(expiredContracts);
        }
        // Distributor payout
        expiredContracts = new ArrayList<>();
        bankruptContracts = new ArrayList<>();
        for (Distributor distributor : distributors) {
            if (distributor.getIsBankrupt()) {
                continue;
            }
            for (Contract contract : distributor.getContracts()) {
                Consumer consumer = consumers.get(contract.getConsumerId());
                if (consumer.payDistributor(contract.contractPayment())) {
                    distributor.getPayed(contract.contractPayment());
                    contract.payMonth();
                    if (contract.contractOver()) {
                        expiredContracts.add(contract);
                    }
                } else {
                    if (contract.canPostpone()) {
                        contract.postpone();
                    } else {
                        contract.setRemainedContractMonths(-111);
                        consumer.setIsBankrupt(true);
                    }
                }
            }
            boolean canPay = distributor.payExpenses();
            if (!canPay) {
                bankruptContracts.addAll(distributor.getContracts());
            }
            distributor.getContracts().removeIf(contract -> contract.getRemainedContractMonths() == -111);
        }
    }

    public void update(final Input.MonthlyUpdate update) {
        consumers.addAll(Arrays.asList(update.getNewConsumers()));
        for (Input.MonthlyUpdate.CostsChange costsChange : update.getCostsChanges()) {
            for (Distributor distributor : distributors) {
                if (costsChange.getId() == distributor.getId()) {
                    distributor.setInfrastructureCost(costsChange.getInfrastructureCost());
                    distributor.setProductionCost(costsChange.getProductionCost());
                }
            }
        }
    }
}
