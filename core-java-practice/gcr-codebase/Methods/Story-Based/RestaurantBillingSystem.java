import java.util.Scanner;

public class RestaurantBillingSystem {

    static double foodCost(int quantity, double price) {
        return quantity * price;
    }

    static double gst(double amount) {
        return amount * 0.18;
    }

    static double discount(double amount) {
        if (amount > 1000) return amount * 0.1;
        return 0;
    }

    static double finalBill(double amount, double gst, double discount) {
        return amount + gst - discount;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int qty = sc.nextInt();
        double price = sc.nextDouble();
        double food = foodCost(qty, price);
        double tax = gst(food);
        double disc = discount(food);
        double total = finalBill(food, tax, disc);
        System.out.println(food);
        System.out.println(tax);
        System.out.println(disc);
        System.out.println(total);
    }
}