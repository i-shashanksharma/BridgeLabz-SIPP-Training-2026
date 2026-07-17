import java.util.*;

class FraudPairDetection {

    public int[] findFraudPair(int[] amounts, int target) {

        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < amounts.length; i++) {

            int complement = target - amounts[i];

            if (seen.containsKey(complement)) {
                return new int[]{seen.get(complement), i};
            }

            seen.put(amounts[i], i);
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {

        FraudPairDetection obj = new FraudPairDetection();

        int[] amounts = {12, 7, 11, 15};

        System.out.println(Arrays.toString(obj.findFraudPair(amounts, 18)));
    }
}