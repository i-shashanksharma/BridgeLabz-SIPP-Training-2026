import java.util.Scanner;
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

public class HospitalBillingSystem {

    static double calculateAverageBill(double totalAmount, int items) {
        return totalAmount / items;
    }

    static String getPatient(String[] patients, int index) {
        return patients[index];
    }

    static void processPayment(double billAmount, double paymentAmount) throws InsufficientFundsException {
        if (paymentAmount < billAmount) {
            throw new InsufficientFundsException(
                "Payment failed: insufficient funds. Required " + billAmount + ", provided " + paymentAmount
            );
        }
        System.out.println("Payment successful.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] patients = {"John", "Alice", "Robert"};

        try {
            System.out.print("Enter total bill amount: ");
            double totalAmount = Double.parseDouble(sc.nextLine());

            System.out.print("Enter number of items: ");
            int items = Integer.parseInt(sc.nextLine());

            try {
                double avg = calculateAverageBill(totalAmount, items);
                System.out.println("Average bill per item: " + avg);
            } catch (ArithmeticException e) {
                System.out.println("Billing error: division by zero. Number of items cannot be zero.");
            }

            System.out.print("Enter patient index: ");
            int index = Integer.parseInt(sc.nextLine());

            try {
                String patient = getPatient(patients, index);
                System.out.println("Patient: " + patient);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Patient lookup error: invalid patient index.");
            }

            System.out.print("Enter payment amount: ");
            double payment = Double.parseDouble(sc.nextLine());

            try {
                processPayment(totalAmount, payment);
            } catch (InsufficientFundsException e) {
                System.out.println(e.getMessage());
            }

        } catch (NumberFormatException e) {
            System.out.println("Input error: invalid number format.");
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }
}