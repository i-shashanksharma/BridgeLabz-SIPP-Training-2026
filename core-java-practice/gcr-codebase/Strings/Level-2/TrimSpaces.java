import java.util.Scanner;

public class TrimSpaces {

    static int[] trimIndexes(String text) {

        int start = 0;
        int end = text.length() - 1;

        while (text.charAt(start) == ' ')
            start++;

        while (text.charAt(end) == ' ')
            end--;

        return new int[]{start, end};
    }

    static String substring(String text, int start, int end) {

        String result = "";

        for (int i = start; i <= end; i++) {
            result += text.charAt(i);
        }

        return result;
    }

    static boolean compareStrings(String s1, String s2) {

        if (s1.length() != s2.length())
            return false;

        for (int i = 0; i < s1.length(); i++) {

            if (s1.charAt(i) != s2.charAt(i))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();

        int[] indexes = trimIndexes(text);

        String userTrim =
                substring(text, indexes[0], indexes[1]);

        String builtTrim = text.trim();

        System.out.println(userTrim);
        System.out.println(builtTrim);

        System.out.println(
                compareStrings(userTrim, builtTrim));
    }
}