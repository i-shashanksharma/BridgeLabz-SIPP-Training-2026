import java.util.Scanner;

public class UniqueCharacters {

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

    static char[] uniqueCharacters(String text) {

        int len = findLength(text);
        char[] temp = new char[len];
        int count = 0;

        for (int i = 0; i < len; i++) {

            boolean unique = true;

            for (int j = 0; j < i; j++) {
                if (text.charAt(i) == text.charAt(j)) {
                    unique = false;
                    break;
                }
            }

            if (unique) {
                temp[count++] = text.charAt(i);
            }
        }

        char[] result = new char[count];

        for (int i = 0; i < count; i++) {
            result[i] = temp[i];
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        char[] result = uniqueCharacters(text);

        for (char ch : result) {
            System.out.print(ch + " ");
        }
    }
}