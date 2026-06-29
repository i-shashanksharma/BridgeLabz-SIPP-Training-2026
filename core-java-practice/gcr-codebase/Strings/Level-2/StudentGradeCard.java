import java.util.Scanner;

public class StudentGradeCard {

    static int[][] generateMarks(int students) {

        int[][] marks = new int[students][3];

        for (int i = 0; i < students; i++) {
            for (int j = 0; j < 3; j++) {
                marks[i][j] = (int) (Math.random() * 90) + 10;
            }
        }

        return marks;
    }

    static double[][] calculateResults(int[][] marks) {

        double[][] result = new double[marks.length][3];

        for (int i = 0; i < marks.length; i++) {

            int total = marks[i][0] + marks[i][1] + marks[i][2];

            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;

            average = Math.round(average * 100.0) / 100.0;
            percentage = Math.round(percentage * 100.0) / 100.0;

            result[i][0] = total;
            result[i][1] = average;
            result[i][2] = percentage;
        }

        return result;
    }

    static String[] calculateGrades(double[][] result) {

        String[] grades = new String[result.length];

        for (int i = 0; i < result.length; i++) {

            double percentage = result[i][2];

            if (percentage >= 80)
                grades[i] = "A";
            else if (percentage >= 70)
                grades[i] = "B";
            else if (percentage >= 60)
                grades[i] = "C";
            else if (percentage >= 50)
                grades[i] = "D";
            else if (percentage >= 40)
                grades[i] = "E";
            else
                grades[i] = "R";
        }

        return grades;
    }

    static void displayScorecard(int[][] marks,
                                 double[][] result,
                                 String[] grades) {

        System.out.println("Student\tPhysics\tChemistry\tMaths\tTotal\tAverage\tPercentage\tGrade");

        for (int i = 0; i < marks.length; i++) {

            System.out.println(
                    (i + 1) + "\t" +
                    marks[i][0] + "\t" +
                    marks[i][1] + "\t\t" +
                    marks[i][2] + "\t" +
                    (int) result[i][0] + "\t" +
                    result[i][1] + "\t" +
                    result[i][2] + "%\t\t" +
                    grades[i]
            );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int students = sc.nextInt();

        int[][] marks = generateMarks(students);

        double[][] result = calculateResults(marks);

        String[] grades = calculateGrades(result);

        displayScorecard(marks, result, grades);
    }
}