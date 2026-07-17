import java.util.*;

class MostFrequentErrorCode {

    public int mostFrequentErrorCode(int[] codes) {

        Map<Integer, Integer> freq = new HashMap<>();

        int bestCode = codes[0];
        int bestCount = 0;

        for (int code : codes) {

            int count = freq.merge(code, 1, Integer::sum);

            if (count > bestCount) {
                bestCount = count;
                bestCode = code;
            }
        }

        return bestCode;
    }

    public static void main(String[] args) {

        MostFrequentErrorCode obj = new MostFrequentErrorCode();

        int[] codes = {500, 404, 500, 200, 404, 500};

        System.out.println(obj.mostFrequentErrorCode(codes));
    }
}