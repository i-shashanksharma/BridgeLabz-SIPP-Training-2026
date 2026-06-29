import java.util.Scanner;

public class StudentGrade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        double[] physics = new double[n];
        double[] chemistry = new double[n];
        double[] maths = new double[n];
        double[] percentage = new double[n];
        char[] grade = new char[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter marks for Student " + (i + 1));

            System.out.print("Physics: ");
            physics[i] = sc.nextDouble();

            System.out.print("Chemistry: ");
            chemistry[i] = sc.nextDouble();

            System.out.print("Maths: ");
            maths[i] = sc.nextDouble();

            if (physics[i] < 0 || chemistry[i] < 0 || maths[i] < 0) {
                System.out.println("Invalid marks. Enter positive values.");
                i--;
            }
        }

        for (int i = 0; i < n; i++) {
            percentage[i] = (physics[i] + chemistry[i] + maths[i]) / 3.0;

            if (percentage[i] >= 80) {
                grade[i] = 'A';
            } else if (percentage[i] >= 70) {
                grade[i] = 'B';
            } else if (percentage[i] >= 60) {
                grade[i] = 'C';
            } else if (percentage[i] >= 50) {
                grade[i] = 'D';
            } else if (percentage[i] >= 40) {
                grade[i] = 'E';
            } else {
                grade[i] = 'R';
            }
        }

        System.out.println("\nPhysics\tChemistry\tMaths\tPercentage\tGrade");

        for (int i = 0; i < n; i++) {
            System.out.printf("%.2f\t%.2f\t\t%.2f\t%.2f\t\t%c%n",
                    physics[i],
                    chemistry[i],
                    maths[i],
                    percentage[i],
                    grade[i]);
        }
    }
}