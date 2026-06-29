import java.util.Scanner;

public class FirstNonRepeating {

    static char firstNonRepeating(String text) {

        int[] frequency = new int[256];

        for (int i = 0; i < text.length(); i++) {
            frequency[text.charAt(i)]++;
        }

        for (int i = 0; i < text.length(); i++) {
            if (frequency[text.charAt(i)] == 1) {
                return text.charAt(i);
            }
        }

        return '\0';
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        char result = firstNonRepeating(text);

        if (result == '\0')
            System.out.println("No Non-Repeating Character");
        else
            System.out.println(result);
    }
}