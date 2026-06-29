import java.util.Scanner;

public class VowelConsonantCount {

    static String checkCharacter(char ch) {

        if (ch >= 'A' && ch <= 'Z')
            ch = (char) (ch + 32);

        if (ch == 'a' || ch == 'e' || ch == 'i' ||
                ch == 'o' || ch == 'u')
            return "Vowel";

        if (ch >= 'a' && ch <= 'z')
            return "Consonant";

        return "Not a Letter";
    }

    static int[] countVC(String text) {

        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < text.length(); i++) {

            String result = checkCharacter(text.charAt(i));

            if (result.equals("Vowel"))
                vowels++;
            else if (result.equals("Consonant"))
                consonants++;
        }

        return new int[]{vowels, consonants};
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();

        int[] result = countVC(text);

        System.out.println("Vowels = " + result[0]);
        System.out.println("Consonants = " + result[1]);
    }
}