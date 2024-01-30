import java.util.ArrayList;
import java.util.Iterator;

// Radio Station class
class RadioStation {
    private String frequency;

    public RadioStation(String frequency) {
        this.frequency = frequency;
    }

    public String getFrequency() {
        return frequency;
    }
}

// Iterator interface
interface StationIterator {
    boolean hasNext();
    RadioStation next();
}

// Concrete Iterator
class StationListIterator implements StationIterator {
    private ArrayList<RadioStation> stations;
    private int position = 0;

    public StationListIterator(ArrayList<RadioStation> stations) {
        this.stations = stations;
    }

    public boolean hasNext() {
        return position < stations.size();
    }

    public RadioStation next() {
        if (hasNext()) {
            return stations.get(position++);
        } else {
            return null;
        }
    }
}

// Aggregate interface
interface StationList {
    StationIterator createIterator();
}

// Concrete Aggregate
class RadioStationList implements StationList {
    private ArrayList<RadioStation> stations;

    public RadioStationList() {
        stations = new ArrayList<>();
    }

    public void addStation(RadioStation station) {
        stations.add(station);
    }

    public StationIterator createIterator() {
        return new StationListIterator(stations);
    }
}

// Client code
public class RadioStationManager {
    public static void main(String[] args) {
        RadioStationList stationList = new RadioStationList();
        stationList.addStation(new RadioStation("95.5 FM"));
        stationList.addStation(new RadioStation("101.1 FM"));
        stationList.addStation(new RadioStation("104.3 FM"));

        StationIterator iterator = stationList.createIterator();
        System.out.println("Radio Stations:");
        while (iterator.hasNext()) {
            RadioStation station = iterator.next();
            System.out.println(station.getFrequency());
        }
    }
}