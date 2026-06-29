import java.util.Scanner;

public class BMICalculator {

    static double[][] getPersonData(Scanner sc, int n) {

        double[][] data = new double[n][2];

        for (int i = 0; i < n; i++) {

            System.out.print("Enter Weight (kg) of Person " + (i + 1) + ": ");
            data[i][0] = sc.nextDouble();

            System.out.print("Enter Height (cm) of Person " + (i + 1) + ": ");
            data[i][1] = sc.nextDouble();
        }

        return data;
    }

    static String getBMIStatus(double bmi) {

        if (bmi <= 18.4)
            return "Underweight";
        else if (bmi <= 24.9)
            return "Normal";
        else if (bmi <= 39.9)
            return "Overweight";
        else
            return "Obese";
    }

    static String[][] calculateBMI(double[][] data) {

        String[][] result = new String[data.length][4];

        for (int i = 0; i < data.length; i++) {

            double weight = data[i][0];
            double heightCm = data[i][1];

            double heightM = heightCm / 100.0;

            double bmi = weight / (heightM * heightM);

            bmi = Math.round(bmi * 100.0) / 100.0;

            result[i][0] = String.valueOf(heightCm);
            result[i][1] = String.valueOf(weight);
            result[i][2] = String.valueOf(bmi);
            result[i][3] = getBMIStatus(bmi);
        }

        return result;
    }

    static void display(String[][] result) {

        System.out.println("\nHeight(cm)\tWeight(kg)\tBMI\t\tStatus");

        for (int i = 0; i < result.length; i++) {

            System.out.println(
                    result[i][0] + "\t\t" +
                    result[i][1] + "\t\t" +
                    result[i][2] + "\t\t" +
                    result[i][3]
            );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = 10;

        double[][] data = getPersonData(sc, n);

        String[][] result = calculateBMI(data);

        display(result);
    }
}