import game.Game;
import io.IGameFactory;
import io.IOReader;
import io.IOWriter;

public final class Main {
    private Main() { }
    public static void main(final String[] args) throws Exception {
        IOReader reader = new IOReader();
        reader.read(args[0]);
        IGameFactory factory = reader.getFactory();
        Game game = Game.getInstance();
        game.setInitialData(factory.getConsumers(), factory.getDistributors());
        game.makeTurn();
        int count = -1;

        while (factory.hasNextTurn()) {
            game.update(factory.getNextTurn());
            game.makeTurn();
        }

        IOWriter writer = new IOWriter();
        writer.write(args[1], game.getConsumers(), game.getDistributors());
    }
}
