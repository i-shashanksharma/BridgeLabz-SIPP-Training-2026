import java.util.Scanner;
public class CinemaSeatAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] seats = new int[n];

        for (int i = 0; i < n; i++) {
            seats[i] = sc.nextInt();
        }

        int maxLen = 0, currLen = 0;
        int start = -1, bestStart = -1, bestEnd = -1;

        int booked = 0, empty = 0;

        for (int i = 0; i < n; i++) {
            if (seats[i] == 0) {
                empty++;
                if (currLen == 0) start = i;
                currLen++;
                if (currLen > maxLen) {
                    maxLen = currLen;
                    bestStart = start;
                    bestEnd = i;
                }
            } else {
                booked++;
                currLen = 0;
            }
        }

        System.out.println(bestStart);
        System.out.println(bestEnd);
        System.out.println(booked);
        System.out.println(empty);

        if (maxLen >= 5) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}