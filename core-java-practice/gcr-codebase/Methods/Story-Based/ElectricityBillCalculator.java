import java.util.Scanner;
public class ElectricityBillCalculator {

    static double calculateBill(int units) {
        double bill;
        if (units <= 100) {
            bill = units * 2;
        } else if (units <= 200) {
            bill = 100 * 2 + (units - 100) * 3;
        } else {
            bill = 100 * 2 + 100 * 3 + (units - 200) * 5;
        }
        return bill;
    }

    static void displayBill(String name, int units, double bill) {
        System.out.println(name);
        System.out.println(units);
        System.out.println(bill);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();
        int units = sc.nextInt();
        double bill = calculateBill(units);
        displayBill(name, units, bill);
    }
}