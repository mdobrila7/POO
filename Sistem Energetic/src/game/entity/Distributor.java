package game.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public final class Distributor {
    private int id;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int contractLength;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int initialBudget;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int initialInfrastructureCost;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int initialProductionCost;


    private int budget;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int infrastructureCost;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int productionCost;
    private boolean isBankrupt;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int monthlyPayment;
    private List<Contract> contracts;

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public int getContractLength() {
        return contractLength;
    }

    public void setContractLength(final int contractLength) {
        this.contractLength = contractLength;
    }

    public int getInitialBudget() {
        return initialBudget;
    }

    public void setInitialBudget(final int initialBudget) {
        this.initialBudget = initialBudget;
    }

    public int getInitialInfrastructureCost() {
        return initialInfrastructureCost;
    }

    public void setInitialInfrastructureCost(final int initialInfrastructureCost) {
        this.initialInfrastructureCost = initialInfrastructureCost;
    }

    public int getInitialProductionCost() {
        return initialProductionCost;
    }

    public void setInitialProductionCost(final int initialProductionCost) {
        this.initialProductionCost = initialProductionCost;
    }


    ////////////////////////////////////////////////////////////////

    public int getBudget() {
        return budget;
    }

    public void setBudget(final int budget) {
        this.budget = budget;
    }

    public int getInfrastructureCost() {
        return infrastructureCost;
    }

    public void setInfrastructureCost(final int infrastructureCost) {
        this.infrastructureCost = infrastructureCost;
    }

    public int getProductionCost() {
        return productionCost;
    }

    public void setProductionCost(final int productionCost) {
        this.productionCost = productionCost;
    }

    public boolean getIsBankrupt() {
        return isBankrupt;
    }

    public void setIsBankrupt(final boolean bankrupt) {
        isBankrupt = bankrupt;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(final List<Contract> contracts) {
        this.contracts = contracts;
    }

    ////////////////////////////////////////////////////////////////

    /**
     * Init from initial data
     * @param consumers
     */
    public void init(final List<Consumer> consumers) {
        budget = initialBudget;
        infrastructureCost = initialInfrastructureCost;
        productionCost = initialProductionCost;
        isBankrupt = false;
        contracts = new ArrayList<>();
    }

    /**
     * Calculates current contract value per month
     * @return
     */
    public int monthlyContractValue() {
        int clients = Math.max(1, contracts.size());
        int profit = (int) Math.round(Math.floor(0.2 * productionCost));
        monthlyPayment = (int) Math.round(Math.floor(infrastructureCost / clients)
                + productionCost + profit);
        return monthlyPayment;
    }

    public int getMonthlyPayment() {
        return monthlyPayment;
    }

    /**
     * Adds a new contract
     * @param consumer
     */
    public void addContract(final Consumer consumer) {
        contracts.add(new Contract(consumer.getId(), monthlyPayment, contractLength));
    }

    /**
     * Pays Monthly expenses
     * @return
     */
    public boolean payExpenses() {
        budget -= infrastructureCost + productionCost * contracts.size();
        if (budget < 0) {
            isBankrupt = true;
            return false;
        }
        return true;
    }

    /**
     * Gets payed by a consumer
     * @param amount
     */
    public void getPayed(final int amount) {
        budget += amount;
    }

}
