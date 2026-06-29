import java.util.Scanner;

public class TaxSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double income, tax, totalTax = 0;

        System.out.println("Tax Calculation for 10 Citizens\n");

        for (int i = 1; i <= 10; i++) {
            System.out.print("Enter income of citizen " + i + ": ");
            income = sc.nextDouble();

            if (income < 10000) {
                tax = income * 0.05;
                System.out.println("Bracket: 5% Tax");
            } else if (income <= 50000) {
                tax = income * 0.15;
                System.out.println("Bracket: 15% Tax");
            } else {
                tax = income * 0.30;
                System.out.println("Bracket: 30% Tax");
            }

            System.out.printf("Tax Amount: %.2f%n%n", tax);

            totalTax += tax;
        }

        System.out.printf("Total Tax Collected from 10 Citizens = %.2f%n", totalTax);

        sc.close();
    }
}