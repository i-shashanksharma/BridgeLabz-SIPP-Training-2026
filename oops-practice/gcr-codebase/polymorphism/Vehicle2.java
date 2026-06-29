class Vehicle {
    String vehicleNumber;
    String ownerName;

    Vehicle(String vehicleNumber, String ownerName) {
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
    }

    double calculateToll() {
        return 0;
    }
}

class Car extends Vehicle {
    Car(String vehicleNumber, String ownerName) {
        super(vehicleNumber, ownerName);
    }

    double calculateToll() {
        return 100;
    }
}

class Bus extends Vehicle {
    Bus(String vehicleNumber, String ownerName) {
        super(vehicleNumber, ownerName);
    }

    double calculateToll() {
        return 250;
    }
}

class Truck extends Vehicle {
    Truck(String vehicleNumber, String ownerName) {
        super(vehicleNumber, ownerName);
    }

    double calculateToll() {
        return 400;
    }
}

public class Vehicle2 {

    static double calculateTotalRevenue(Vehicle[] vehicles) {
        double total = 0;
        for (Vehicle v : vehicles)
            total += v.calculateToll();
        return total;
    }

    static void searchVehicle(Vehicle[] vehicles, String vehicleNumber) {
        for (Vehicle v : vehicles) {
            if (v.vehicleNumber.equals(vehicleNumber)) {
                System.out.println(v.vehicleNumber + " " + v.ownerName);
                return;
            }
        }
        System.out.println("Vehicle Not Found");
    }

    public static void main(String[] args) {

        Vehicle[] vehicles = {
                new Car("UP101", "Rahul"),
                new Bus("UP102", "Amit"),
                new Truck("UP103", "Priya"),
                new Car("UP104", "Riya"),
                new Truck("UP105", "Vikas")
        };

        int cars = 0, buses = 0, trucks = 0;
        Vehicle highest = vehicles[0];

        for (Vehicle v : vehicles) {
            System.out.println(v.vehicleNumber + " Toll = " + v.calculateToll());

            if (v.calculateToll() > highest.calculateToll())
                highest = v;

            if (v instanceof Car)
                cars++;
            else if (v instanceof Bus)
                buses++;
            else if (v instanceof Truck)
                trucks++;
        }

        System.out.println("Total Revenue = " + calculateTotalRevenue(vehicles));

        System.out.println("Highest Toll Vehicle = " + highest.vehicleNumber);

        System.out.println("Cars = " + cars);
        System.out.println("Buses = " + buses);
        System.out.println("Trucks = " + trucks);

        searchVehicle(vehicles, "UP103");
    }
}