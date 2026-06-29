import java.util.Scanner;
public class StudentMarksAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] marks = new int[n];

        for (int i = 0; i < n; i++) {
            marks[i] = sc.nextInt();
        }

        int max = marks[0];
        int min = marks[0];
        int sum = 0;
        int countAbove75 = 0;

        for (int i = 0; i < n; i++) {
            if (marks[i] > max) max = marks[i];
            if (marks[i] < min) min = marks[i];
            sum += marks[i];
            if (marks[i] > 75) countAbove75++;
        }

        double avg = (double) sum / n;

        System.out.println(max);
        System.out.println(min);
        System.out.println(countAbove75);
        System.out.println(avg);

        for (int i = 0; i < n; i++) {
            if (marks[i] > avg) {
                System.out.print(marks[i] + " ");
            }
        }
    }
}