import java.util.Scanner;

public class Friends {

    public static String findYoungest(int[] ages) {
        String[] names = {"Amar", "Akbar", "Anthony"};
        int index = 0;

        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < ages[index]) {
                index = i;
            }
        }

        return names[index];
    }

    public static String findTallest(double[] heights) {
        String[] names = {"Amar", "Akbar", "Anthony"};
        int index = 0;

        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[index]) {
                index = i;
            }
        }

        return names[index];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] ages = new int[3];
        double[] heights = new double[3];

        for (int i = 0; i < 3; i++) {
            ages[i] = sc.nextInt();
            heights[i] = sc.nextDouble();
        }

        System.out.println("Youngest: " + findYoungest(ages));
        System.out.println("Tallest: " + findTallest(heights));
    }
}