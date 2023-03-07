package services.Impl;



import models.House;
import models.Room;
import models.Villa;
import services.FacilityService;
import utils.ReadAndWriteHouse;
import utils.ReadAndWriteRoom;
import utils.ReadAndWriteVilla;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FacilityServiceImpl implements FacilityService {
    private static Map<Villa,Integer> villaIntegerMap = new LinkedHashMap<>();
    private static Map<Room,Integer> roomIntegerMap = new LinkedHashMap<>();
    private static Map<House,Integer> houseIntegerMap = new LinkedHashMap<>();
    static {
        villaIntegerMap.put(new Villa("villa", 200, 3000000, 5, "ngay", "căn hộ cao cấp", 50, 2), 0 );
        houseIntegerMap.put(new House("house", 150, 2000000, 4, "ngay", "căn hộ trung cấp", 2), 0);
    }
    private static Scanner input = new Scanner(System.in);
    @Override
    public void display() {

        try {
            villaIntegerMap = (Map<Villa, Integer>) ReadAndWriteVilla.read("C:\\Users\\ADMIN\\Desktop\\Case-Study\\src\\data\\villa.csv");
            for (Map.Entry<Villa, Integer> villaIntegerEntry : villaIntegerMap.entrySet()) {
                System.out.println("Service : " + villaIntegerEntry.getKey() + "number of hires: " + villaIntegerEntry.getValue());
            }
            roomIntegerMap = (Map<Room, Integer>) ReadAndWriteRoom.read("C:\\Users\\ADMIN\\Desktop\\Case-Study\\src\\data\\room.csv");
            for (Map.Entry<Room, Integer> roomIntegerEntry : roomIntegerMap.entrySet()) {
                System.out.println("Service : " + roomIntegerEntry.getKey() + "number of hires: " + roomIntegerEntry.getValue());
            }
            houseIntegerMap = (Map<House, Integer>) ReadAndWriteHouse.read("C:\\Users\\ADMIN\\Desktop\\Case-Study\\src\\data\\house.csv");
            for (Map.Entry<House, Integer> houseIntegerEntry : houseIntegerMap.entrySet()) {
                System.out.println("Service : " + houseIntegerEntry.getKey() + "number of hires: " + houseIntegerEntry.getValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addNew() {
        int choice =0;
        System.out.println("1. Add new Villa");
        System.out.println("2. Add new House");
        System.out.println("3. Add new Room");
        System.out.println("4. Back Facility Management");
        try {
            choice = Integer.parseInt(input.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Import bad format, please enter back");
        }
        switch (choice) {
            case 1: {
                addNewVilla();
                break;
            }
            case 2: {
                addNewHouse();
                break;
            }
            case 3: {
                addNewRoom();
                break;
            }
            case 4: {
                break;
            }
        }
    }

    @Override
    public void edit() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void addNewVilla() {
        System.out.println("Enter serviceName :");
        String serviceName = input.nextLine();
        System.out.println("Enter usableArea :");
        float usableArea = 0;
        try {
            usableArea = Float.parseFloat(input.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Import bad format, please enter back");
        }
        System.out.println("Enter rentalCost :");
        float rentalCost = 0;
        try {
            rentalCost = Float.parseFloat(input.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Import bad format, please enter back");
        }
        System.out.println("Enter maximumNumberPeople :");
        int maximumNumberPeople = 0;
        try {
            maximumNumberPeople = Integer.parseInt(input.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Import bad format, please enter back");
        }
        System.out.println("Enter rentalType :");
        String rentalType = input.nextLine();
        System.out.println("Enter roomStandard :");
        String roomStandard = input.nextLine();
        System.out.println("Enter swimmingPoolArea :");
        float swimmingPoolArea = 0;
        try {
            swimmingPoolArea = Float.parseFloat(input.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Import bad format, please enter back");
        }
        System.out.println("Enter numberOfFloors :");
        int numberOfFloors = 0;
        try {
            numberOfFloors = Integer.parseInt(input.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Import bad format, please enter back");
        }
        Villa villa = new Villa(serviceName,usableArea,rentalCost,maximumNumberPeople,rentalType,roomStandard,swimmingPoolArea,numberOfFloors);
        villaIntegerMap.put(villa,0);
        System.out.println("Successfully added new villa");
        ReadAndWriteVilla.write(villaIntegerMap, "C:\\Users\\ADMIN\\Desktop\\Case-Study\\src\\data\\villa.csv");
    }

    @Override
    public void addNewHouse() {
        System.out.println("Enter serviceName :");
        String serviceName = input.nextLine();
        System.out.println("Enter usableArea :");
        float usableArea = 0;
        try {
            usableArea = Float.parseFloat(input.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Import bad format, please enter back");
        }
        System.out.println("Enter rentalCost :");
        float rentalCost = 0;
        try {
            rentalCost = Float.parseFloat(input.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Import bad format, please enter back");
        }
        System.out.println("Enter maximumNumberPeople :");
        int maximumNumberPeople = 0;
        try {
            maximumNumberPeople = Integer.parseInt(input.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Import bad format, please enter back");
        }
        System.out.println("Enter rentalType :");
        String rentalType = input.nextLine();
        System.out.println("Enter roomStandard :");
        String roomStandard = input.nextLine();
        System.out.println("Enter numberOfFloors :");
        int numberOfFloors = 0;
        try {
            numberOfFloors = Integer.parseInt(input.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Import bad format, please enter back");
        }
        House house = new House(serviceName,usableArea,rentalCost,maximumNumberPeople,rentalType,roomStandard,numberOfFloors);
        houseIntegerMap.put(house,0);
        System.out.println("Successfully added new house");
        ReadAndWriteHouse.write( houseIntegerMap, "C:\\Users\\ADMIN\\Desktop\\Case-Study\\src\\data\\house.csv");
    }

    @Override
    public void addNewRoom() {
        System.out.println("Enter serviceName :");
        String serviceName = input.nextLine();
        System.out.println("Enter usableArea :");
        float usableArea = 0;
        try {
            usableArea = Float.parseFloat(input.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Import bad format, please enter back");
        }
        System.out.println("Enter rentalCost :");
        float rentalCost = 0;
        try {
            rentalCost = Float.parseFloat(input.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Import bad format, please enter back");
        }
        System.out.println("Enter maximumNumberPeople :");
        int maximumNumberPeople = 0;
        try {
            maximumNumberPeople = Integer.parseInt(input.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Import bad format, please enter back");
        }
        System.out.println("Enter rentalType :");
        String rentalType = input.nextLine();
        System.out.println("Enter serviceFree :");
        String serviceFree = input.nextLine();
        Room room = new Room(serviceName,usableArea,rentalCost,maximumNumberPeople,rentalType,serviceFree);
        roomIntegerMap.put(room,0);
        System.out.println("Successfully added new room");
        ReadAndWriteRoom.write( roomIntegerMap, "C:\\Users\\ADMIN\\Desktop\\Case-Study\\src\\data\\room.csv");
    }

    @Override
    public void displayListFacilityMaintenance() {

    }
}
