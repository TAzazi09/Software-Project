import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;
public class Simulation
{
   String worldAndRidesFileName;
   String allocationFileName;
   public Simulation(String worldAndRidesFileName, String allocationFileName) {
       this.worldAndRidesFileName = worldAndRidesFileName;
       this.allocationFileName = allocationFileName;
   }
    
   public void run() {
       try {
           WorldAndRides worldAndRides = new WorldAndRides(worldAndRidesFileName);
           Allocation allocation = new Allocation(allocationFileName, worldAndRides);
           //score for simulation
           //world components 
           int worldRows = worldAndRides.getNumOfRows();
           int worldCols = worldAndRides.getNumOfCols();
           int worldCars = worldAndRides.getNumOfCars();
           int worldRides = worldAndRides.getNumOfRides();
           int worldBonusPoints = worldAndRides.getNumOfBonusPoints();
           int worldSteps = worldAndRides.getNumOfSteps();
           int drivetoStart = 0;
           int drivetoFinish = 0;
           //For rides
           int[][] world = new int[worldRows][worldCols];
           int []startPoint = new int[2];
           int []finishPoint = new int[2];
           //for every car that exists
           //need to get list of rides that the car needs to do
           //then simulate what every car needs to do
           int score = 0;
           //For each Car
           for(Cars car: allocation.cars){
               //For each Car initialise the components that the car uses
               int rideId = 0;
               int clock = 0;
               int []currentPos = {0,0};
               //For each Ride
               for(int x = 0; x < car.id.size(); x++){
                   int rideBonus = 0;   
                   rideId = car.id.get(x);
                   int startLength = 0;
                   int rideLength = 0;
                   Rides eachRide = worldAndRides.getRideIndex(rideId);
                   //System.out.println(eachRide.toString());
                   startPoint[0] = eachRide.getRowOfStartInt();
                   startPoint[1] = eachRide.getColOfStartInt();
                   finishPoint[0] = eachRide.getRowOfFinishInt();
                   finishPoint[1] = eachRide.getColOfFinishInt();
                   int i = Math.abs(startPoint[1] - currentPos[1]);
                   int j = Math.abs(startPoint[0] - currentPos[0]);
                   startLength = i + j;
                   //currentPos[0] = j;
                   //currentPos[1] = i;
                   if(eachRide.getEarliestStart() >= clock + startLength){
                       int waitTime = eachRide.getEarliestStart() - (clock + startLength);
                       rideBonus = eachRide.getEarliestStart() - startLength;
                       int f = Math.abs(finishPoint[1] - startPoint[1]);
                       int g = Math.abs(finishPoint[0] - startPoint[0]);
                       rideLength = f + g;
                       rideBonus = worldBonusPoints;
                       score = score + rideLength + rideBonus;
                       clock = clock + waitTime + startLength + rideLength;
                   } else {
                       int f = Math.abs(finishPoint[1] - startPoint[1]);
                       int g = Math.abs(finishPoint[0] - startPoint[0]);
                       rideLength = f + g;
                       if(eachRide.getLatestFinish() >= clock + startLength + rideLength) {
                           rideBonus = 0;
                           score = score + rideLength + rideBonus;
                           clock = clock + startLength + rideLength;
                       } else {
                           rideBonus = 0;
                           score = score;
                           clock = clock + startLength + rideLength;
                       }
                   }
                   currentPos[0] = finishPoint[0];
                   currentPos[1] = finishPoint[1];
                   //System.out.println("{" + currentPos[0] + ", " + currentPos[1] + "}");
                   //System.out.println(clock);
               }
           }
           System.out.println(score);
           //compute score of allocation
           //Each vehicle is allocated rides
       } catch (FileFormatException e) {
           System.out.println ("ERROR "+ e.description());
       }
   }
}
