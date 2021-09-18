package game.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class Consumer {
    private int id;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int initialBudget;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int monthlyIncome;

    private boolean isBankrupt;

    private Distributor distributor;
    private Distributor newDistributor;

    private int budget;

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public int getInitialBudget() {
        return initialBudget;
    }

    public void setInitialBudget(final int initialBudget) {
        this.initialBudget = initialBudget;
    }

    public int getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(final int monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }






    ////////////////////////////////////////////////////////////////

    public boolean getIsBankrupt() {
        return isBankrupt;
    }

    public void setIsBankrupt(final boolean bankrupt) {
        isBankrupt = bankrupt;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(final int budget) {
        this.budget = budget;
    }

    ////////////////////////////////////////////////////////////////

    /**
     * Initialize with initial data
     */
    public void init() {
        budget = initialBudget;
        isBankrupt = false;
    }

    /**
     * Adds income
     */
    public void addMonthlyIncome() {
        if (!isBankrupt) {
            budget += monthlyIncome;
        }
    }

    /**
     * Compare if there is a better distributor
     * @param potentialDistributor
     */
    public void compareAndSet(final Distributor potentialDistributor) {
        if (isBankrupt) {
            return;
        }
        if (this.distributor != null) {
            return;
        }
        if (this.newDistributor == null) {
            this.newDistributor = potentialDistributor;
        } else {
            if (potentialDistributor.getMonthlyPayment()
                    < this.newDistributor.getMonthlyPayment()) {
                this.newDistributor = potentialDistributor;
            }
        }
    }

    /**
     * Remove Current Distributor
     */
    public void removeDistributor() {
        distributor = null;
    }

    /**
     * Accepts a new contract from current distributor if exists
     */
    public void acceptDistributor() {
        if (newDistributor == null) {
            if (distributor == null) {
                isBankrupt = true;
            }
            return;
        }
        distributor = newDistributor;
        distributor.addContract(this);
        newDistributor = null;
    }

    /**
     * Pay current distributor with specific amount
     * @param amount
     * @return
     */
    public boolean payDistributor(final int amount) {
        if (amount > budget) {
            return false;
        }
        budget -= amount;
        return true;
    }

//    @Override
//    public String toString() {
//        return "Consumer{" +
//                "id=" + id +
//                ", isBankrupt=" + isBankrupt +
//                ", distributor=" + (distributor == null ? "NULL" : distributor.getId()) +
//                ", budget=" + budget +
//                '}';
//    }
}
