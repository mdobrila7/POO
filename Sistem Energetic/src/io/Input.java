package io;

import game.entity.Consumer;
import game.entity.Distributor;

public final class Input {
    public static final class InitialData {
        private Consumer[] consumers;
        private Distributor[] distributors;

        public Consumer[] getConsumers() {
            return consumers;
        }

        public void setConsumers(final Consumer[] consumers) {
            this.consumers = consumers;
        }

        public Distributor[] getDistributors() {
            return distributors;
        }

        public void setDistributors(final Distributor[] distributors) {
            this.distributors = distributors;
        }
    }
    public static final class MonthlyUpdate {
        public static final class CostsChange {
            private int id;
            private int infrastructureCost;
            private int productionCost;

            public int getId() {
                return id;
            }

            public void setId(final int id) {
                this.id = id;
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
        }
        private Consumer[] newConsumers;
        private CostsChange[] costsChanges;

        public Consumer[] getNewConsumers() {
            return newConsumers;
        }

        public void setNewConsumers(final Consumer[] newConsumers) {
            this.newConsumers = newConsumers;
        }

        public CostsChange[] getCostsChanges() {
            return costsChanges;
        }

        public void setCostsChanges(final CostsChange[] costsChanges) {
            this.costsChanges = costsChanges;
        }
    }

    private int numberOfTurns;
    private InitialData initialData;
    private MonthlyUpdate[] monthlyUpdates;

    public int getNumberOfTurns() {
        return numberOfTurns;
    }

    public void setNumberOfTurns(final int numberOfTurns) {
        this.numberOfTurns = numberOfTurns;
    }

    public InitialData getInitialData() {
        return initialData;
    }

    public void setInitialData(final InitialData initialData) {
        this.initialData = initialData;
    }

    public MonthlyUpdate[] getMonthlyUpdates() {
        return monthlyUpdates;
    }

    public void setMonthlyUpdates(final MonthlyUpdate[] monthlyUpdates) {
        this.monthlyUpdates = monthlyUpdates;
    }
}
