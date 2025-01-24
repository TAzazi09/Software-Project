import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.FileNotFoundException;
import java.util.List;
public class Allocation

    //TODO decide a proper data-structure to store the allocation

{
    ArrayList<Cars> cars;
    ArrayList<Integer> carID;
    //For each Car
    public Allocation(String allocationFileName, WorldAndRides worldAndRides) throws FileFormatException {
        //TODO read an allocation from allocationFileName and stores the content in
        //an appropriate datastructure inside this class
        cars = new ArrayList<Cars>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(allocationFileName));
            String line;
            List<String> ls = new ArrayList<String>();
            int numOfRides = 0;
            while((line=reader.readLine())!=null){
                ls.add(line);
            }
            for(String word : ls) {
                //for each car
                ArrayList<Integer> car = new ArrayList<Integer>();
                String[] strArray = word.split(" ");
                int[] intArray = new int[strArray.length];
                for(int i = 0; i < strArray.length; i++){
                    intArray[i] = Integer.parseInt(strArray[i]);
                    car.add(intArray[i]);
                }
                //System.out.println(car);
                carID = new ArrayList<Integer>();
                for(int j = 0; j < car.size(); j++) {
                    if(j==0){
                        numOfRides = car.get(0);
                    } else {
                        carID.add(car.get(j));
                    }
                }
                //System.out.println(numOfRides);
                //System.out.println(carID);
                cars.add(new Cars(numOfRides, carID)); 
            }
            
            //System.out.println(car);
            //System.out.println(cars.toString());
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File not found");
        } catch(IOException e) {
            
        } 
    }
    //TODO define appropriate methods for this class (e.g. accessor methods)
    public int getCarRides(){
        int carRides = 0;
        for(Cars car : cars) {
            carRides = car.getNumOfRides();
        }
        return carRides;
    }
    
}
    
