class ChargingStation {
    static int totalStations = 0;
    static double electricityRate = 8.5;

    String stationId;
    double unitsConsumed;

    ChargingStation(String stationId, double unitsConsumed) {
        this.stationId = stationId;
        this.unitsConsumed = unitsConsumed;
        totalStations++;
    }

    double calculateBill() {
        return unitsConsumed * electricityRate;
    }

    void displayStationDetails() {
        System.out.println("Station ID: " + stationId);
        System.out.println("Units: " + unitsConsumed);
        System.out.println("Rate: " + electricityRate);
        System.out.println("Bill: " + calculateBill());
        System.out.println();
    }

    public static void main(String[] args) {
        ChargingStation[] stations = {
            new ChargingStation("S1", 120),
            new ChargingStation("S2", 150),
            new ChargingStation("S3", 180),
            new ChargingStation("S4", 200),
            new ChargingStation("S5", 250)
        };

        for (ChargingStation s : stations) {
            s.displayStationDetails();
        }

        electricityRate = 10;

        System.out.println("After Rate Change");

        for (ChargingStation s : stations) {
            s.displayStationDetails();
        }

        System.out.println("Total Stations: " + totalStations);
    }
}