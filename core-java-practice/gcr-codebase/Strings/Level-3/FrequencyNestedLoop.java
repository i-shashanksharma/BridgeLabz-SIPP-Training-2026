import java.util.Scanner;

public class FrequencyNestedLoop {

    static String[] frequency(String text) {

        char[] chars = text.toCharArray();
        int[] freq = new int[chars.length];

        for (int i = 0; i < chars.length; i++) {

            freq[i] = 1;

            if (chars[i] == '0')
                continue;

            for (int j = i + 1; j < chars.length; j++) {

                if (chars[i] == chars[j]) {
                    freq[i]++;
                    chars[j] = '0';
                }
            }
        }

        int count = 0;

        for (char ch : chars) {
            if (ch != '0')
                count++;
        }

        String[] result = new String[count];

        int index = 0;

        for (int i = 0; i < chars.length; i++) {

            if (chars[i] != '0') {
                result[index++] =
                        chars[i] + " : " + freq[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        String[] result = frequency(text);

        for (String s : result) {
            System.out.println(s);
        }
    }
}