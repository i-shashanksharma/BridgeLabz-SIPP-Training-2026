class WaterBottle {
    String ownerName;
    int dailyTarget;

    WaterBottle(String ownerName, int dailyTarget) {
        this.ownerName = ownerName;
        this.dailyTarget = dailyTarget;
    }

    void displayBottleInfo() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Daily Target: " + dailyTarget + " ml");
        System.out.println();
    }

    public static void main(String[] args) {
        WaterBottle b1 = new WaterBottle("Rahul", 3000);
        WaterBottle b2 = new WaterBottle("Priya", 2500);

        b1.displayBottleInfo();
        b2.displayBottleInfo();
    }
}