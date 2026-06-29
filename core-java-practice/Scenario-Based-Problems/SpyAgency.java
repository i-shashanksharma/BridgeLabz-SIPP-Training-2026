import java.util.*;
public class SpyAgency {
    static String reverseMessage(String msg) {
        return new StringBuilder(msg).reverse().toString();
    }

    static boolean isPalindrome(String msg) {
        String cleaned = msg.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return cleaned.equals(new StringBuilder(cleaned).reverse().toString());
    }

    static void countVowelsConsonants(String msg) {
        int vowels = 0, consonants = 0;
        for (char ch : msg.toCharArray()) {
            if (Character.isLetter(ch)) {
                if ("aeiouAEIOU".indexOf(ch) != -1)
                    vowels++;
                else
                    consonants++;
            }
        }
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }

    static boolean areAnagrams(String s1, String s2) {
        char[] a = s1.replaceAll("\\s+", "").toLowerCase().toCharArray();
        char[] b = s2.replaceAll("\\s+", "").toLowerCase().toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a, b);
    }

    static Character firstNonRepeating(String str) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char ch : str.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);

        for (Map.Entry<Character, Integer> entry : map.entrySet())
            if (entry.getValue() == 1)
                return entry.getKey();

        return null;
    }

    public static void main(String[] args) {
        String secret = "Radar";
        String intercept1 = "listen";
        String intercept2 = "silent";
        String log = "surveillance";

        System.out.println(reverseMessage(secret));
        System.out.println(isPalindrome(secret));

        countVowelsConsonants(secret);

        System.out.println(areAnagrams(intercept1, intercept2));

        Character result = firstNonRepeating(log);
        System.out.println(result != null ? result : "No non-repeating character");
    }
}