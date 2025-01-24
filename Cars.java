import java.util.List;
import java.util.ArrayList;

public class Cars
{
    //For each car
    // number of rides done by a specific car
    int numOfRides;
    //data structure to store id to specify each ride
    ArrayList<Integer> id;
    /**
     * Constructor for objects of class Cars
     */
    public Cars(int numOfRides, ArrayList<Integer> id)
    {
        this.numOfRides = numOfRides;
        this.id = id;
    }
    
    public int getNumOfRides()
    {
        return numOfRides;
    }
    
    public int getId(int index)
    {
        return id.get(index);
    }
    
    @Override
    public String toString() {
        return(numOfRides + " " + id);
    }
}
