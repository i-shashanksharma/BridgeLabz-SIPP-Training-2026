import java.util.*;

public class RiverStationAnalysis {

    static int longestStablePeriod(int[] levels, int range) {
        int left = 0;
        int maxLength = 0;

        TreeMap<Integer, Integer> window = new TreeMap<>();

        for (int right = 0; right < levels.length; right++) {
            window.put(levels[right], window.getOrDefault(levels[right], 0) + 1);

            while (window.lastKey() - window.firstKey() > range) {
                window.put(levels[left], window.get(levels[left]) - 1);

                if (window.get(levels[left]) == 0)
                    window.remove(levels[left]);

                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }


    static List<List<Integer>> pollutionTriplets(int[] index) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(index);

        for (int i = 0; i < index.length - 2; i++) {

            if (i > 0 && index[i] == index[i - 1])
                continue;

            int left = i + 1;
            int right = index.length - 1;

            while (left < right) {

                int sum = index[i] + index[left] + index[right];

                if (sum == 0) {
                    result.add(Arrays.asList(
                            index[i], index[left], index[right]));

                    while (left < right && index[left] == index[left + 1])
                        left++;

                    while (left < right && index[right] == index[right - 1])
                        right--;

                    left++;
                    right--;

                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }


    static double maxAverageSubarray(int[] levels, int k) {
        int sum = 0;

        for (int i = 0; i < k; i++)
            sum += levels[i];

        int maxSum = sum;

        for (int i = k; i < levels.length; i++) {
            sum += levels[i] - levels[i - k];
            maxSum = Math.max(maxSum, sum);
        }

        return (double) maxSum / k;
    }


    public static void main(String[] args) {

        int[] waterLevels = {5, 6, 7, 8, 15, 16, 17, 9};

        int range = 3;

        System.out.println("Longest Stable Period: "
                + longestStablePeriod(waterLevels, range));


        int[] pollution = {-1, 0, 1, 2, -1, -4};

        System.out.println("Pollution Triplets:");
        System.out.println(pollutionTriplets(pollution));


        int[] hourlyLevels = {2, 1, 5, 1, 3, 2};

        int k = 3;

        System.out.println("Maximum Average Subarray: "
                + maxAverageSubarray(hourlyLevels, k));
    }
}