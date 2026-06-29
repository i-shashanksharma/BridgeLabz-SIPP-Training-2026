import java.util.Scanner;

public class DeliveryChargeSystem {

    static double calculateCharge(int distance) {
        return distance * 5;
    }

    static double calculateCharge(int distance, int weight) {
        return distance * 5 + weight * 2;
    }

    static double calculateCharge(int distance, int weight, boolean express) {
        double charge = distance * 5 + weight * 2;
        if (express) {
            charge += 50;
        }
        return charge;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int distance = sc.nextInt();
        int weight = sc.nextInt();
        boolean express = sc.nextBoolean();
        double result;
        if (weight == 0 && !express) {
            result = calculateCharge(distance);
        } else if (!express) {
            result = calculateCharge(distance, weight);
        } else {
            result = calculateCharge(distance, weight, express);
        }
        System.out.println(result);
    }
}