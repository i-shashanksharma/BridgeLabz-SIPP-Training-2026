import java.io.*;
import java.util.*;

public class StudentGradeManager {

    static final int MAX = 100;

    static String[] names = new String[MAX];
    static int[][] marks = new int[MAX][5];
    static int[] totals = new int[MAX];
    static double[] averages = new double[MAX];
    static String[] grades = new String[MAX];
    static int count = 0;

    public static void main(String[] args) {
        try {
            readFromFile("students.txt");
            calculateResults();

            System.out.println("----- Student Report -----");
            displayStudents();

            Scanner sc = new Scanner(System.in);
            System.out.print("\nEnter student name to search: ");
            String searchName = sc.nextLine();
            searchStudent(searchName);

            bubbleSort();

            System.out.println("\n----- Sorted by Total Marks -----");
            displayStudents();

            writeToFile("report.txt");

            System.out.println("\nReport successfully written to report.txt");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void readFromFile(String filename) throws IOException {
        File file = new File(filename);

        if (!file.exists())
            throw new FileNotFoundException("Input file not found.");

        Scanner input = new Scanner(file);

        while (input.hasNext()) {
            names[count] = input.next();

            for (int i = 0; i < 5; i++) {
                marks[count][i] = input.nextInt();
            }

            count++;
        }

        input.close();
    }

    static void calculateResults() {
        for (int i = 0; i < count; i++) {
            int total = 0;

            for (int j = 0; j < 5; j++) {
                total += marks[i][j];
            }

            totals[i] = total;
            averages[i] = total / 5.0;

            double avg = averages[i];

            if (avg >= 90) {
                grades[i] = "A+";
            } else {
                if (avg >= 80) {
                    grades[i] = "A";
                } else {
                    if (avg >= 70) {
                        grades[i] = "B";
                    } else {
                        if (avg >= 60) {
                            grades[i] = "C";
                        } else {
                            grades[i] = "F";
                        }
                    }
                }
            }
        }
    }

    static void displayStudents() {
        System.out.printf("%-10s %-8s %-8s %-6s%n",
                "Name", "Total", "Average", "Grade");

        for (int i = 0; i < count; i++) {
            System.out.printf("%-10s %-8d %-8.2f %-6s%n",
                    names[i], totals[i], averages[i], grades[i]);
        }
    }

    static void searchStudent(String name) {
        boolean found = false;

        for (int i = 0; i < count; i++) {
            if (names[i].equalsIgnoreCase(name)) {
                System.out.println("\nStudent Found:");
                System.out.println("Name : " + names[i]);
                System.out.println("Total : " + totals[i]);
                System.out.println("Average : " + averages[i]);
                System.out.println("Grade : " + grades[i]);

                found = true;
                break;
            }
        }

        if (!found)
            System.out.println("Student not found.");
    }

    static void bubbleSort() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (totals[j] < totals[j + 1]) {
                    swapString(names, j, j + 1);
                    swapInt(totals, j, j + 1);
                    swapDouble(averages, j, j + 1);
                    swapString(grades, j, j + 1);

                    int[] temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                }
            }
        }
    }

    static void swapString(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void swapInt(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void swapDouble(double[] arr, int i, int j) {
        double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void writeToFile(String filename) throws IOException {
        PrintWriter output = new PrintWriter(new FileWriter(filename));

        output.printf("%-10s %-8s %-8s %-6s%n",
                "Name", "Total", "Average", "Grade");

        for (int i = 0; i < count; i++) {
            output.printf("%-10s %-8d %-8.2f %-6s%n",
                    names[i], totals[i], averages[i], grades[i]);
        }

        output.close();
    }
}