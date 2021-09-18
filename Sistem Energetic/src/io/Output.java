package io;

import game.entity.Consumer;
import game.entity.Distributor;

public final class Output {
    private Consumer[] consumers;
    private Distributor[] distributors;

    public Output(final Consumer[] consumers, final Distributor[] distributors) {
        this.consumers = consumers;
        this.distributors = distributors;
    }

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
