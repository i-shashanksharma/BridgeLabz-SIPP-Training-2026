import java.util.Scanner;
public class InterestExample {
    static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {
        if (amount < 0 || rate < 0) {
            throw new IllegalArgumentException();
        }
        return (amount * rate * years) / 100;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            double amount = sc.nextDouble();
            double rate = sc.nextDouble();
            int years = sc.nextInt();

            System.out.println(calculateInterest(amount, rate, years));
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: Amount and rate must be positive");
        }
    }
}