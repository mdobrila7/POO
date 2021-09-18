package storage;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Persists sensor data. Observable, its observers are notified when data is added it to.
 */
public class DataRepository extends Observable {

    private ArrayList<SensorData> data = new ArrayList<>();

    public void addData(SensorData dataRecord){
        data.add(dataRecord);
        setChanged();
        notifyObservers(dataRecord);
        clearChanged();
    }

    public List<SensorData> getData() {
       return data;
    }
}


