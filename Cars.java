import java.util.List;
import java.util.ArrayList;
public class Cars
{
    //Variables
    private int carID;
    private ArrayList<Integer> rideIDsforCar;

    //Constructor
    public Cars(int carID)
    {
        this.carID = carID;
        rideIDsforCar = new ArrayList<>();
    }
   
   //Getter
   public ArrayList<Integer> getRideIDsforCar() {
       return rideIDsforCar;
   }


    public int getSize() {  // Corrected method name
        return rideIDsforCar.size();
    }

   //Setter
   public void giveRideToCar(int rideID) {
       rideIDsforCar.add(rideID);
   }
}
