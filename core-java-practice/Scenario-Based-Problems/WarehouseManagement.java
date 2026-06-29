import java.util.*;
public class WarehouseManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] stock = {50, 20, 75, 20, 90, 50, 30};

        int max = stock[0];
        int min = stock[0];
        int total = 0;

        for (int qty : stock) {
            if (qty > max) max = qty;
            if (qty < min) min = qty;
            total += qty;
        }

        System.out.println("Maximum Stock = " + max);
        System.out.println("Minimum Stock = " + min);
        System.out.println("Total Stock = " + total);

        System.out.println("\nDuplicate Quantities:");
        boolean found = false;

        for (int i = 0; i < stock.length; i++) {
            for (int j = i + 1; j < stock.length; j++) {
                if (stock[i] == stock[j]) {
                    System.out.println(stock[i]);
                    found = true;
                    break;
                }
            }
        }

        if (!found) {
            System.out.println("No duplicates found.");
        }

        System.out.print("\nEnter k for rotation: ");
        int k = sc.nextInt();

        k = k % stock.length;
        int[] rotated = new int[stock.length];

        for (int i = 0; i < stock.length; i++) {
            rotated[(i + k) % stock.length] = stock[i];
        }

        System.out.println("Rotated Stock Array:");
        for (int num : rotated) {
            System.out.print(num + " ");
        }

        int[][] shelf = {
            {1, 2, 3},
            {4, 5, 6}
        };

        System.out.println("\n\nOriginal Shelf Grid:");
        for (int[] row : shelf) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

        int rows = shelf.length;
        int cols = shelf[0].length;

        int[][] transpose = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transpose[j][i] = shelf[i][j];
            }
        }

        System.out.println("\nTransposed Shelf Grid:");
        for (int[] row : transpose) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}