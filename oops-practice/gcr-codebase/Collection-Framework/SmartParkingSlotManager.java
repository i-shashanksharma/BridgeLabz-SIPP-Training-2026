import java.util.*;
public class SmartParkingSlotManager {

    static ArrayList<String> vehicles = new ArrayList<>();

    static void addVehicle(String regNo) {
        vehicles.add(regNo);
        System.out.println(regNo + " Entered.");
    }

    static void removeVehicle(String regNo) {
        if (vehicles.remove(regNo))
            System.out.println(regNo + " Exited.");
        else
            System.out.println("Vehicle Not Found.");
    }

    static void searchVehicle(String regNo) {
        if (vehicles.contains(regNo))
            System.out.println("Vehicle is Parked.");
        else
            System.out.println("Vehicle Not Parked.");
    }

    static void displayVehicles() {
        System.out.println("Parked Vehicles");

        for (String v : vehicles)
            System.out.println(v);

        System.out.println("Occupied Slots = " + vehicles.size());
    }

    public static void main(String[] args) {
        addVehicle("UP32AB1234");
        addVehicle("DL01XY4567");
        addVehicle("MH12CD9999");

        searchVehicle("DL01XY4567");
        removeVehicle("UP32AB1234");
        displayVehicles();
    }
}