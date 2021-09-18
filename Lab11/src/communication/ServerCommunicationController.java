package communication;

import main.Utils;
import storage.SensorData;

import java.util.Observable;
import java.util.Observer;

/**
 * Mock class for server communication. It is notified about changes in the observed data.
 */
public class ServerCommunicationController implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof SensorData) {
            ServerMessage message = getMessage((SensorData) arg);
            sendMessage(message);
        }
    }

    /**
     * Mock method for sending a message to the server endpoint.
     * @param message the ServerMessage containing step data
     */
    private void sendMessage(ServerMessage message) {
        System.out.println(String.format("Sending message to server endpoint %s", message));
    }

    private ServerMessage getMessage(SensorData data) {
        return new ServerMessage(
                data.getStepsCount(),
                Utils.getClientId(),
                data.getTimestamp()
        );
    }
}
