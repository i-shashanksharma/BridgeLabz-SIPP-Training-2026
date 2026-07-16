import java.util.*;

class HospitalEmergency {
    static int partition(int[] a, int l, int r) {
        int p = a[r];
        int i = l;

        for (int j = l; j < r; j++) {
            if (a[j] >= p) {
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
                i++;
            }
        }

        int t = a[i];
        a[i] = a[r];
        a[r] = t;

        return i;
    }

    static int kth(int[] a, int l, int r, int k) {
        int p = partition(a, l, r);

        if (p == k - 1)
            return a[p];

        if (p > k - 1)
            return kth(a, l, p - 1, k);

        return kth(a, p + 1, r, k);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        int k = sc.nextInt();

        System.out.print(kth(a, 0, n - 1, k));
    }
}