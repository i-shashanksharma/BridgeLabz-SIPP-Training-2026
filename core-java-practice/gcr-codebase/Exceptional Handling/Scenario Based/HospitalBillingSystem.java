class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

public class HospitalBillingSystem {
    public static void main(String[] args) {
        try {
            int totalBill = 5000;
            int items = 0;
            double costPerItem = totalBill / items;
            System.out.println(costPerItem);
        } catch (ArithmeticException e) {
            System.out.println("Error: Bill contains zero items.");
        }

        try {
            int[] patients = {101, 102, 103};
            System.out.println(patients[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Invalid patient index.");
        }

        try {
            String input = "ABC";
            int amount = Integer.parseInt(input);
            System.out.println(amount);
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid numeric input.");
        }

        try {
            processPayment(2000, 5000);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
    }

    static void processPayment(double availableFunds, double billAmount)
            throws InsufficientFundsException {
        if (availableFunds < billAmount) {
            throw new InsufficientFundsException(
                    "Payment failed: Insufficient funds. Available: ₹" +
                    availableFunds + ", Required: ₹" + billAmount);
        }
        System.out.println("Payment successful.");
    }
}