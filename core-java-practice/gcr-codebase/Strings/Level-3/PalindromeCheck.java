import java.util.Scanner;

public class PalindromeCheck {

    static boolean method1(String text) {

        int start = 0;
        int end = text.length() - 1;

        while (start < end) {

            if (text.charAt(start) != text.charAt(end))
                return false;

            start++;
            end--;
        }

        return true;
    }

    static boolean method2(String text, int start, int end) {

        if (start >= end)
            return true;

        if (text.charAt(start) != text.charAt(end))
            return false;

        return method2(text, start + 1, end - 1);
    }

    static char[] reverse(String text) {

        char[] rev = new char[text.length()];
        int index = 0;

        for (int i = text.length() - 1; i >= 0; i--) {
            rev[index++] = text.charAt(i);
        }

        return rev;
    }

    static boolean method3(String text) {

        char[] original = text.toCharArray();
        char[] reverse = reverse(text);

        for (int i = 0; i < original.length; i++) {

            if (original[i] != reverse[i])
                return false;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();

        System.out.println("Method 1 : " + method1(text));
        System.out.println("Method 2 : " +
                method2(text, 0, text.length() - 1));
        System.out.println("Method 3 : " + method3(text));
    }
}