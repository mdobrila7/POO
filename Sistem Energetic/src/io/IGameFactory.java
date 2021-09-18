package io;

import game.entity.Consumer;
import game.entity.Distributor;

public interface IGameFactory {
    Consumer[] getConsumers();
    Distributor[] getDistributors();
    boolean hasNextTurn();
    Input.MonthlyUpdate getNextTurn();
}
