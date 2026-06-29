import java.util.Scanner;

public class ShortestLongestWord {

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

        int words = 1;

        for (int i = 0; i < findLength(text); i++) {
            if (text.charAt(i) == ' ')
                words++;
        }

        String[] result = new String[words];

        String temp = "";
        int index = 0;

        for (int i = 0; i < findLength(text); i++) {

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

    static String[][] wordLength(String[] words) {

        String[][] data = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            data[i][0] = words[i];
            data[i][1] = String.valueOf(findLength(words[i]));
        }

        return data;
    }

    static int[] shortestLongest(String[][] data) {

        int min = Integer.parseInt(data[0][1]);
        int max = Integer.parseInt(data[0][1]);

        int minIndex = 0;
        int maxIndex = 0;

        for (int i = 1; i < data.length; i++) {

            int len = Integer.parseInt(data[i][1]);

            if (len < min) {
                min = len;
                minIndex = i;
            }

            if (len > max) {
                max = len;
                maxIndex = i;
            }
        }

        return new int[]{minIndex, maxIndex};
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();

        String[] words = splitText(text);
        String[][] data = wordLength(words);

        int[] result = shortestLongest(data);

        System.out.println("Shortest Word: " + data[result[0]][0]);
        System.out.println("Longest Word: " + data[result[1]][0]);
    }
}