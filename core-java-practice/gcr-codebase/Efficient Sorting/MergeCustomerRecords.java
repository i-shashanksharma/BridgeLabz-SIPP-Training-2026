import java.util.*;

class MergeCustomerRecords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        int m = sc.nextInt();
        int[] b = new int[m];

        for (int i = 0; i < m; i++)
            b[i] = sc.nextInt();

        int i = 0, j = 0;

        while (i < n && j < m) {
            if (a[i] <= b[j])
                System.out.print(a[i++] + " ");
            else
                System.out.print(b[j++] + " ");
        }

        while (i < n)
            System.out.print(a[i++] + " ");

        while (j < m)
            System.out.print(b[j++] + " ");
    }
}