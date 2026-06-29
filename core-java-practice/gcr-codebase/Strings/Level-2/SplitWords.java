import java.util.Scanner;

public class SplitWords {

    static int findLength(String text) {
        int count = 0;

        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (Exception e) {
        }

        return count;
    }

    static String[] splitText(String text) {

        int len = findLength(text);
        int words = 1;

        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                words++;
            }
        }

        String[] result = new String[words];

        String temp = "";
        int index = 0;

        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                result[index++] = temp;
                temp = "";
            } else {
                temp += text.charAt(i);
            }
        }

        result[index] = temp;

        return result;
    }

    static boolean compareArrays(String[] a, String[] b) {

        if (a.length != b.length)
            return false;

        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i]))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();

        String[] userWords = splitText(text);
        String[] builtWords = text.split(" ");

        System.out.println(compareArrays(userWords, builtWords));
    }
}