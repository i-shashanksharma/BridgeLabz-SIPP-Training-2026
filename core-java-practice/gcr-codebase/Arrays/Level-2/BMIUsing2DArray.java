import java.util.Scanner;

public class BMIUsing2DArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int number = sc.nextInt();

        double[][] personData = new double[number][3];
        String[] weightStatus = new String[number];

        for (int i = 0; i < number; i++) {
            do {
                System.out.print("Enter weight of person " + (i + 1) + " (kg): ");
                personData[i][0] = sc.nextDouble();

                if (personData[i][0] <= 0) {
                    System.out.println("Please enter a positive weight.");
                }
            } while (personData[i][0] <= 0);

            do {
                System.out.print("Enter height of person " + (i + 1) + " (m): ");
                personData[i][1] = sc.nextDouble();

                if (personData[i][1] <= 0) {
                    System.out.println("Please enter a positive height.");
                }
            } while (personData[i][1] <= 0);
        }

        for (int i = 0; i < number; i++) {
            personData[i][2] = personData[i][0] /
                    (personData[i][1] * personData[i][1]);

            if (personData[i][2] <= 18.4) {
                weightStatus[i] = "Underweight";
            } else if (personData[i][2] <= 24.9) {
                weightStatus[i] = "Normal";
            } else if (personData[i][2] <= 39.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        System.out.println("\nWeight\tHeight\tBMI\tStatus");

        for (int i = 0; i < number; i++) {
            System.out.printf("%.2f\t%.2f\t%.2f\t%s%n",
                    personData[i][0],
                    personData[i][1],
                    personData[i][2],
                    weightStatus[i]);
        }
    }
}