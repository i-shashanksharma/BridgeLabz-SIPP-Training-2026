public class UsernameValidator {
    static boolean isValid(String s, int i) {
        if (i == s.length())
            return true;

        if (s.charAt(i) < 'a' || s.charAt(i) > 'z')
            return false;

        return isValid(s, i + 1);
    }

    public static void main(String[] args) {
        System.out.println(isValid("abcdxyz", 0));
    }
}