import java.util.Scanner;
import java.util.Arrays;
public class WordMatchSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String word1 = sc.nextLine();
        String word2 = sc.nextLine();

        String w1 = word1.toUpperCase();
        String w2 = word2.toUpperCase();

        char[] arr1 = w1.toCharArray();
        char[] arr2 = w2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        boolean isAnagram = Arrays.equals(arr1, arr2);

        System.out.println(w1);
        System.out.println(w2);
        System.out.println(w1.length());
        System.out.println(w2.length());
        System.out.println(isAnagram);

        if (isAnagram) {
            System.out.println("Valid Match");
        } else {
            System.out.println("Not a Match");
        }
    }
}