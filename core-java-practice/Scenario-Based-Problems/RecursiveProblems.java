public class RecursiveProblems {
    static int moveCount = 0;
    static void towerOfHanoi(int n, char source, char auxiliary, char destination) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            moveCount++;
            return;
        }

        towerOfHanoi(n - 1, source, destination, auxiliary);
        System.out.println("Move disk " + n + " from " + source + " to " + destination);
        moveCount++;
        towerOfHanoi(n - 1, auxiliary, source, destination);
    }

    static int binarySearch(int[] arr, int low, int high, int key) {
        if (low > high)
            return -1;

        int mid = (low + high) / 2;

        if (arr[mid] == key)
            return mid;

        if (key < arr[mid])
            return binarySearch(arr, low, mid - 1, key);

        return binarySearch(arr, mid + 1, high, key);
    }

    static int sumOfDigits(int n) {
        if (n == 0)
            return 0;

        return n % 10 + sumOfDigits(n / 10);
    }

    static String reverseString(String str) {
        if (str.isEmpty())
            return str;

        return reverseString(str.substring(1)) + str.charAt(0);
    }

    static boolean isBalanced(String str) {
        return checkBalance(str, 0, 0);
    }

    static boolean checkBalance(String str, int index, int count) {
        if (count < 0)
            return false;

        if (index == str.length())
            return count == 0;

        char ch = str.charAt(index);

        if (ch == '(')
            return checkBalance(str, index + 1, count + 1);

        if (ch == ')')
            return checkBalance(str, index + 1, count - 1);

        return checkBalance(str, index + 1, count);
    }

    public static void main(String[] args) {
        int n = 3;

        System.out.println("Tower of Hanoi:");
        towerOfHanoi(n, 'A', 'B', 'C');
        System.out.println("Total Moves: " + moveCount);

        int[] prices = {100, 200, 300, 400, 500, 600};
        int key = 400;
        System.out.println("\nBinary Search Index: " +
                binarySearch(prices, 0, prices.length - 1, key));

        int num = 12345;
        System.out.println("Sum of Digits: " + sumOfDigits(num));

        String text = "Temple";
        System.out.println("Reversed String: " + reverseString(text));

        String expr = "((())())";
        System.out.println("Balanced Parentheses: " + isBalanced(expr));
    }
}