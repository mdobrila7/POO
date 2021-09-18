package io;

import com.fasterxml.jackson.databind.ObjectMapper;
import game.entity.Consumer;
import game.entity.Distributor;

import java.io.File;
import java.io.IOException;

public final class IOReader {
    private Input input;
    private ObjectMapper objectMapper;

    public IOReader() {
        objectMapper = new ObjectMapper();
    }
    public void read(final String filename) {
        try {
            input = objectMapper.readValue(new File(filename), Input.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public IGameFactory getFactory() {
        if (input == null) {
            return null;
        }

        return new IGameFactory() {
            private int turn = 0;
            private final Input input = IOReader.this.input;
            @Override
            public Consumer[] getConsumers() {
                return input.getInitialData().getConsumers();
            }

            @Override
            public Distributor[] getDistributors() {
                return input.getInitialData().getDistributors();
            }

            @Override
            public boolean hasNextTurn() {
                return turn < input.getNumberOfTurns();
            }

            @Override
            public Input.MonthlyUpdate getNextTurn() {
                return input.getMonthlyUpdates()[turn++];
            }
        };
    }
}
