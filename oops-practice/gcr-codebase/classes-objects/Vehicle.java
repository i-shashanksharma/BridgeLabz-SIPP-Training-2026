class Vehicle {
    String vehicleNumber;
    String ownerName;
    String vehicleType;

    Vehicle(String vehicleNumber, String ownerName, String vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    static void displayCars(Vehicle[] vehicles) {
        System.out.println("Cars:");
        for (Vehicle v : vehicles) {
            if (v.vehicleType.equalsIgnoreCase("Car")) {
                System.out.println(v.vehicleNumber + " " + v.ownerName);
            }
        }
    }

    static void displayBikes(Vehicle[] vehicles) {
        System.out.println("Bikes:");
        for (Vehicle v : vehicles) {
            if (v.vehicleType.equalsIgnoreCase("Bike")) {
                System.out.println(v.vehicleNumber + " " + v.ownerName);
            }
        }
    }

    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new Vehicle("UP01A101", "Rahul", "Car"),
            new Vehicle("UP01A102", "Priya", "Bike"),
            new Vehicle("UP01A103", "Amit", "Car"),
            new Vehicle("UP01A104", "Neha", "Bike"),
            new Vehicle("UP01A105", "Rohan", "Car"),
            new Vehicle("UP01A106", "Kiran", "Bike"),
            new Vehicle("UP01A107", "Ankit", "Car"),
            new Vehicle("UP01A108", "Pooja", "Bike"),
            new Vehicle("UP01A109", "Vikas", "Car"),
            new Vehicle("UP01A110", "Simran", "Bike")
        };

        displayCars(vehicles);
        System.out.println();
        displayBikes(vehicles);
    }
}