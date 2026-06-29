import java.util.Scanner;

public class CalendarProgram {

    static String[] months = {
            "January","February","March","April","May","June",
            "July","August","September","October","November","December"
    };

    static int[] days = {
            31,28,31,30,31,30,
            31,31,30,31,30,31
    };

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0)
                || year % 400 == 0;
    }

    public static int getDays(int month, int year) {

        if (month == 2 && isLeapYear(year)) {
            return 29;
        }

        return days[month - 1];
    }

    public static int firstDay(int month, int year) {

        int m = month;
        int y = year;

        if (m < 3) {
            m += 12;
            y--;
        }

        int q = 1;
        int k = y % 100;
        int j = y / 100;

        int h = (q + (13 * (m + 1)) / 5 + k +
                (k / 4) + (j / 4) + (5 * j)) % 7;

        return (h + 6) % 7;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int month = sc.nextInt();
        int year = sc.nextInt();

        System.out.println(months[month - 1] + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        int start = firstDay(month, year);

        for (int i = 0; i < start; i++) {
            System.out.print("    ");
        }

        int totalDays = getDays(month, year);

        for (int day = 1; day <= totalDays; day++) {

            System.out.printf("%3d ", day);

            if ((start + day) % 7 == 0) {
                System.out.println();
            }
        }
    }
}