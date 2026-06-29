abstract class Vehicle {
    abstract double fuelCost(double km);
}

class Car extends Vehicle {
    @Override
    double fuelCost(double km) {
        return km * 6;
    }
}

class Bus extends Vehicle {
    @Override
    double fuelCost(double km) {
        return km * 12;
    }
}

class Bike extends Vehicle {
    @Override
    double fuelCost(double km) {
        return km * 3;
    }
}

class ElectricCar extends Vehicle {
    @Override
    double fuelCost(double km) {
        return km * 1.5;
    }
}

public class TransportDemo {

    public static void main(String[] args) {

        Vehicle[] fleet = {
            new Car(),
            new Bus(),
            new Bike(),
            new ElectricCar()
        };

        double km = 10;

        for (Vehicle v : fleet) {

            if (v instanceof Car) {
                System.out.println("Car cost: " + v.fuelCost(km));
            } else if (v instanceof Bus) {
                System.out.println("Bus cost: " + v.fuelCost(km));
            } else if (v instanceof Bike) {
                System.out.println("Bike cost: " + v.fuelCost(km));
            } else if (v instanceof ElectricCar) {
                System.out.println("ElectricCar cost: " + v.fuelCost(km));
            }
        }
    }
}