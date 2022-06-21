package com.bheema.parkingdesign;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class App {
    static ParkingLot p1;
    public static void main(String[] args) throws Exception {
        p1=new ParkingLot();
        FileRead();
        /* 
        p1.createParkingLot(6);
        p1.park("KA-01-HH-1234" , 21);
        p1.park("PB-01-HH-1234" , 21);
        p1.getSlotNumbersFromDriverAge(21);
        p1.park("PB-01-TG-2341", 40);
        p1.getSlotNumberFromVehicleRegistrationPlate("PB-01-HH-1234");
        p1.leave(2);
        p1.park("HR-29-TG-3098", 39);
        p1.getSlotNumbersFromDriverAge(18);
        */
        

    }

    public static void FileRead() throws FileNotFoundException{
        //String filePath="input.txt";
        String filePath="test_file_2.txt";
        File inputFile = new File(filePath);
        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            String line;
            try {
                while ((line = br.readLine()) != null) {
                    parseCommands(line.trim());
                }
            } catch (IOException ex) {
                System.out.println("Error in reading the input file.");
                ex.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found in the path specified.");
            e.printStackTrace();
        }
    }

    public static void parseCommands(String line) {
        String[] input=line.split(" ");
        switch(input.length){
            case 0:
            case 1:
            case 3:System.out.println("invalid Command");
                    break;

            case 2  :if(input[0].equals("Create_parking_lot"))
                        p1.createParkingLot(Integer.parseInt(input[1]));
                    else if(input[0].equals("Leave"))
                        p1.leave(Integer.parseInt(input[1]));

                    else if (input[0].equals("Slot_numbers_for_driver_of_age")){
                        int age=Integer.parseInt(input[1]);
                        p1.getSlotNumbersFromDriverAge(age);
                    }
                    else if(input[0].equals("Slot_number_for_car_with_number")){
                        String reg_No=input[1];
                        p1.getSlotNumberFromVehicleRegistrationPlate(reg_No);
                    }
                    else if(input[0].equals("Vehicle_registration_number_for_driver_of_age")){
                        int age=Integer.parseInt(input[1]);
                        p1.getVehicleRegistrationNumbersFromAge(age);
                    }
                    else{
                        System.out.println("invalid Command");
                    }
                    break;

            case 4:if(input[0].equals("Park") && input[2].equals("driver_age")&&input[1].length()==13){
                    try{
                        int age=Integer.parseInt(input[3]);
                        String reg_No=input[1];
                        p1.park(reg_No, age);
                    }
                    catch(ArithmeticException e){
                        System.out.println("Invalid Command");
                        e.getStackTrace();
                    }
                    
                    }
                    else {
                        System.out.println("Invalid Command");
                    }
                    break;
            default:System.out.println("Invalid Command");

        }


    }
}
