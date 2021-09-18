package io;

import com.fasterxml.jackson.databind.ObjectMapper;
import game.entity.Consumer;
import game.entity.Distributor;

import java.io.File;
import java.io.IOException;
import java.util.List;

public final class IOWriter {
    private ObjectMapper objectMapper;
    public IOWriter() {
        objectMapper = new ObjectMapper();
    }
    public void write(final String filename, final List<Consumer> consumers,
                      final List<Distributor> distributors) {
        Output output = new Output(consumers.toArray(new Consumer[0]),
                distributors.toArray(new Distributor[0]));
        try {
            objectMapper.writeValue(new File(filename), output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
