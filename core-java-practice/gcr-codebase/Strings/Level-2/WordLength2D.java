import java.util.Scanner;

public class WordLength2D {

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
            if (text.charAt(i) == ' ')
                words++;
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

    static String[][] wordAndLength(String[] words) {

        String[][] result = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findLength(words[i]));
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();

        String[] words = splitText(text);

        String[][] result = wordAndLength(words);

        System.out.println("Word\tLength");

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i][0] + "\t" +
                    Integer.parseInt(result[i][1]));
        }
    }
}