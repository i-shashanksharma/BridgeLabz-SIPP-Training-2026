import java.util.Scanner;
public class SecretMessageValidator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String code = sc.nextLine();

        int vowels = 0, consonants = 0, digits = 0, special = 0;

        for (int i = 0; i < code.length(); i++) {
            char ch = code.charAt(i);

            if (Character.isDigit(ch)) {
                digits++;
            } else if (Character.isLetter(ch)) {
                ch = Character.toLowerCase(ch);
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            } else {
                special++;
            }
        }

        boolean isStrong = (digits >= 2 && special >= 1 && code.length() >= 8);

        System.out.println(vowels);
        System.out.println(consonants);
        System.out.println(digits);
        System.out.println(special);
        System.out.println(code.length());
        System.out.println(isStrong ? "Strong" : "Weak");
    }
}