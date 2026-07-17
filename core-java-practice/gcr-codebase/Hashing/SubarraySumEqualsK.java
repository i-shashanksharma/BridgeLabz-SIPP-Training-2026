import java.util.*;

class SubarraySumEqualsK {

    public int subarraySumEqualsK(int[] revenueChanges, int k) {

        Map<Integer, Integer> prefixCount = new HashMap<>();

        prefixCount.put(0, 1);

        int runningSum = 0;
        int answer = 0;

        for (int change : revenueChanges) {

            runningSum += change;

            answer += prefixCount.getOrDefault(runningSum - k, 0);

            prefixCount.merge(runningSum, 1, Integer::sum);
        }

        return answer;
    }

    public static void main(String[] args) {

        SubarraySumEqualsK obj = new SubarraySumEqualsK();

        int[] arr = {1, 2, 3, -2, 2};

        System.out.println(obj.subarraySumEqualsK(arr, 3));
    }
}