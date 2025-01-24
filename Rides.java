import java.util.Comparator;
import java.util.ArrayList;

public  class Rides {
    // variables of the ride
    private int rideID;
    private int rowOfStartInt;
    private int colOfStartInt;
    private int rowOfFinishInt;
    private int colOfFinishInt;
    private int earliestStart;
    private int latestFinish;

    // Constructor
    public Rides(String[] currentLineSplit, int lineIndex) {
        rideID = lineIndex;

        rowOfStartInt = Integer.parseInt(currentLineSplit[0]);
        colOfStartInt = Integer.parseInt(currentLineSplit[1]);
        rowOfFinishInt = Integer.parseInt(currentLineSplit[2]);
        colOfFinishInt = Integer.parseInt(currentLineSplit[3]);
        earliestStart = Integer.parseInt(currentLineSplit[4]);
        latestFinish = Integer.parseInt(currentLineSplit[5]);
    }

    // Getters
    public int getRideID() {
        return rideID;
    }

    public int getRowOfstartInt() {
        return rowOfStartInt;
    }

    public int getColOfStartInt() {
        return colOfStartInt;
    }

    public int getRowOfFinishInt() {
        return rowOfFinishInt;
    }

    public int getEarliestStart() {
        return earliestStart;
    }

    public int getLatestFinish() {
        return latestFinish;
    }
}
