public class ReverseString {
    static void reverse(String str) {
        if (str.length() == 0)
            return;
        reverse(str.substring(1));
        System.out.print(str.charAt(0));
    }

    public static void main(String[] args) {
        reverse("hello");
    }
}