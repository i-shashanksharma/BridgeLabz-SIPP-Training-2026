class SpaceTourist {
    static int totalReservations = 0;
    static String missionName = "Mars Explorer";

    String touristName;
    int seatNumber;

    SpaceTourist(String touristName, int seatNumber) {
        this.touristName = touristName;
        this.seatNumber = seatNumber;
        totalReservations++;
    }

    SpaceTourist updateSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
        return this;
    }

    void displayDetails() {
        System.out.println("Mission Name: " + missionName);
        System.out.println("Tourist Name: " + touristName);
        System.out.println("Seat Number: " + seatNumber);
        System.out.println();
    }

    public static void main(String[] args) {
        SpaceTourist tourist1 = new SpaceTourist("Rahul", 5);
        SpaceTourist tourist2 = new SpaceTourist("Priya", 8);

        tourist1.updateSeatNumber(10).updateSeatNumber(15);

        tourist1.displayDetails();
        tourist2.displayDetails();

        System.out.println("Total Reservations: " + totalReservations);
    }
}