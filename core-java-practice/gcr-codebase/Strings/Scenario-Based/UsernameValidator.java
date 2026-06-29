import java.util.Scanner;
public class UsernameValidator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String username = sc.nextLine();

        boolean hasSpace = false;
        for (int i = 0; i < username.length(); i++) {
            if (username.charAt(i) == ' ') {
                hasSpace = true;
                break;
            }
        }

        int length = username.length();
        String upper = username.toUpperCase();

        boolean isPalindrome = true;
        int i = 0, j = username.length() - 1;

        while (i < j) {
            if (username.charAt(i) != username.charAt(j)) {
                isPalindrome = false;
                break;
            }
            i++;
            j--;
        }

        System.out.println(upper);
        System.out.println(length);
        System.out.println(hasSpace);
        System.out.println(isPalindrome);
    }
}