public class StringPermutations {
    static void permutations(char[] str, int index) {
        if (index == str.length) {
            System.out.println(new String(str));
            return;
        }

        for (int i = index; i < str.length; i++) {
            char temp = str[index];
            str[index] = str[i];
            str[i] = temp;

            permutations(str, index + 1);

            temp = str[index];
            str[index] = str[i];
            str[i] = temp;
        }
    }

    public static void main(String[] args) {
        permutations("ABC".toCharArray(), 0);
    }
}