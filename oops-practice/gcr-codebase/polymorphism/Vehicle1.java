class Vehicle {
    String name;

    Vehicle(String name) {
        this.name = name;
    }

    double fuelCost(int km) {
        return 0;
    }
}

class Car extends Vehicle {
    Car(String name) {
        super(name);
    }

    double fuelCost(int km) {
        return km * 8;
    }
}

class Bus extends Vehicle {
    Bus(String name) {
        super(name);
    }

    double fuelCost(int km) {
        return km * 15;
    }
}

class Bike extends Vehicle {
    Bike(String name) {
        super(name);
    }

    double fuelCost(int km) {
        return km * 3;
    }
}

class ElectricCar extends Vehicle {
    ElectricCar(String name) {
        super(name);
    }

    double fuelCost(int km) {
        return km * 2;
    }
}

public class Vehicle1 {
    public static void main(String[] args) {

        Vehicle[] vehicles = {
                new Car("Honda"),
                new Bus("Volvo"),
                new Bike("Yamaha"),
                new ElectricCar("Tesla")
        };

        for (Vehicle v : vehicles) {
            System.out.println(v.name + " Fuel Cost: " + v.fuelCost(50));

            if (v instanceof Car)
                System.out.println("Car Object");
            else if (v instanceof Bus)
                System.out.println("Bus Object");
            else if (v instanceof Bike)
                System.out.println("Bike Object");
            else if (v instanceof ElectricCar)
                System.out.println("Electric Car Object");

            System.out.println();
        }
    }
}