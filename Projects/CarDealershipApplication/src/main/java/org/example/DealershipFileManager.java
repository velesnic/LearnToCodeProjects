package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DealershipFileManager {
    private Dealership dealership;

    //I think making this method static would be good, and also having a private constructor
    //for DealershipFileManager
    public Dealership getDealership() {
        ArrayList<Vehicle> inventory = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/inventory.csv");
            Scanner scanner = new Scanner(fileInputStream);
            scanner.nextLine();

            //The inventory is empty by the time we get to this line. You don't add any cars to it until later.
            dealership= new Dealership("Velesnic Auto Company", "123 Rainbow Rd","816-123-1234", inventory);
            String input;
            while(scanner.hasNextLine()){
                input = scanner.nextLine();
                String [] rowArray = input.split("\\|");

                int vin = Integer.parseInt(rowArray[0].trim());
                int year = Integer.parseInt(rowArray[1].trim());
                String make = rowArray[2];
                String model = rowArray[3];
                String vehicleType = rowArray[4];
                String color = rowArray[5];
                int odometer = Integer.parseInt(rowArray[6].trim());
                double price = Double.parseDouble(rowArray[7].trim());
                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                //How does this add the vehicle to the dealership?
                inventory.add(vehicle);
                //This would make more sense
                dealership.addVehicle(vehicle);
            }
            fileInputStream.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Could not locate file.");
            ex.printStackTrace();
        }
        catch(IOException ex){
            System.out.println("Could not locate file.");
            ex.printStackTrace();
        }
        return dealership;
    }

    public void saveDealership(Dealership dealership){
        try{
            FileWriter fileWriter = new FileWriter("src/main/resources/inventory.csv");
            ArrayList<Vehicle> inventory = dealership.getInventory();
                for(Vehicle vehicle : inventory){
                    fileWriter.write(vehicle.getVin() + " | " + vehicle.getYear() + " | " + vehicle.getMake() +
                            " | " + vehicle.getModel() + " | " + vehicle.getVehicleType() + " | " + vehicle.getColor() +
                            " | " + vehicle.getOdometer() + " | " + vehicle.getPrice() + "\n");
                }
                fileWriter.close();
        }
        catch(IOException ex){
            System.out.println("Couldn't locate file.");
            ex.printStackTrace();
        }
    }

}