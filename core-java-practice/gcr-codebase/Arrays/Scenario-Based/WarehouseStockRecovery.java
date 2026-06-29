import java.util.Scanner;
public class WarehouseStockRecovery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] stock = new int[n];

        int zeroIndex = -1;
        int sum = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            stock[i] = sc.nextInt();
            if (stock[i] == 0) {
                zeroIndex = i;
            } else {
                sum += stock[i];
                count++;
            }
        }

        double avg = (double) sum / count;

        if (zeroIndex != -1) {
            stock[zeroIndex] = (int) avg;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(stock[i] + " ");
        }
    }
}