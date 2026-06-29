public class SumNaturalNumbers {
    static int sumN(int n) {
        if (n == 0)
            return 0;
        return n + sumN(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(sumN(5));
    }
}