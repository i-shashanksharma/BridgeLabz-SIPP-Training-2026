import java.util.Scanner;

public class LeapYearSingleCondition {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int year = sc.nextInt();

        if (year >= 1582 &&
                ((year % 4 == 0 && year % 100 != 0) ||
                 (year % 400 == 0))) {

            System.out.println("Year is a Leap Year");

        } else {

            System.out.println("Year is not a Leap Year");
        }
    }
}