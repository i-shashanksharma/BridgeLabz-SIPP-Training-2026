class MathWizard {
    int instanceVar = 100;

    boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    long factorial(int n) {
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    double factorial(double n) {
        int num = (int) n;
        double fact = 1;
        for (int i = 1; i <= num; i++) {
            fact *= i;
        }
        return fact;
    }

    int fibonacci(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    long power(int base, int exp) {
        long result = 1;
        for (int i = 0; i < exp; i++) {
            result *= base;
        }
        return result;
    }

    void showScope() {
        int instanceVar = 50;
        System.out.println("Local Variable: " + instanceVar);
        System.out.println("Instance Variable: " + this.instanceVar);
    }
}

public class MathWizards {
    public static void main(String[] args) {
        MathWizard mw = new MathWizard();
        System.out.println("Prime: " + mw.isPrime(17));
        System.out.println("Factorial(int): " + mw.factorial(5));
        System.out.println("Factorial(double): " + mw.factorial(5.0));
        System.out.println("Fibonacci: " + mw.fibonacci(10));
        System.out.println("GCD: " + mw.gcd(24, 36));
        System.out.println("LCM: " + mw.lcm(24, 36));
        System.out.println("Power: " + mw.power(2, 10));
        mw.showScope();
    }
}