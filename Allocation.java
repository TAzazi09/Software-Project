import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Collections;
import java.util.Scanner;

public class Allocation {

    private ArrayList<Cars> carsList;

    //Constructor
    public Allocation(String worldAndRidesFileName) {
        //List of rides and cars
        carsList = new ArrayList<>();
        ArrayList<Rides> ridesList = new ArrayList<>();
        int numOfCars=0;

        //More variables needed
        

        //Read the file and allocate rides
        try {
            //Make file
            File worldAndRides = new File(worldAndRidesFileName);
            Scanner scan = new Scanner(worldAndRides);


            //Variables to read file
            String currentLine;
            String[] currentLineSplit;
            int lineIndex = 0;

            //Loop through the file
            while(scan.hasNextLine()){
                currentLine = scan.nextLine();
                currentLineSplit = currentLine.split(" ");

                if(lineIndex != 0){
                    Rides ride = new Rides(currentLineSplit, lineIndex);
                    ridesList.add(ride);
                    lineIndex++;
                }
                else if(lineIndex == 0) {
                    numOfCars = Integer.parseInt (currentLineSplit[2]);
                    lineIndex++;
                }
                else {
                    lineIndex++;
                }
                
            }
            //Close the file
            scan.close();

        } 
        catch (FileNotFoundException e) {
            System.err.println("Error: File not found: " + worldAndRidesFileName);
        }

        //Creating cars
        for(int i = 0; i < numOfCars; i++) {
            Cars car = new Cars(i);
            carsList.add(car);
        }

        //First allocate the rides to the car
        allocate(carsList, ridesList);
    }

    public void allocate(ArrayList<Cars> carsList, ArrayList<Rides> ridesList) {
        int count = 0;
        while (count < ridesList.size()) {
            for (Cars car : carsList) {
                if (count < ridesList.size()) {
                    int rideID = ridesList.get(count).getRideID(); 
                    car.giveRideToCar(rideID); 
                    count++;
                } else {
                    break;
                }
            }
        }
    }

    //Method that prints result
    public void printAllocation() {
        for (Cars car : carsList) {
            int totalRides = car.getRideIDsforCar().size();  // Store count in an int
            String rideIDsAsString = "";  // Initialize empty string for ride IDs

            for (int id : car.getRideIDsforCar()) {
                rideIDsAsString += id + " ";  // Append ride ID with a space
            }

            System.out.println(totalRides + " " + rideIDsAsString);  // Print count and list
        }
    }
 }

