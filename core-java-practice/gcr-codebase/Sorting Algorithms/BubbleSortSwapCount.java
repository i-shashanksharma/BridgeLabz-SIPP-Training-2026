import java.util.Arrays;

public class BubbleSortSwapCount {

    static int bubbleSort(int[] nums) {

        int swaps = 0;

        for (int i = 0; i < nums.length - 1; i++) {

            boolean swapped = false;

            for (int j = 0; j < nums.length - i - 1; j++) {

                if (nums[j] > nums[j + 1]) {

                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;

                    swaps++;
                    swapped = true;
                }
            }

            if (!swapped)
                break;
        }

        return swaps;
    }

    public static void main(String[] args) {

        int[] nums = {4,3,2,1};

        int swaps = bubbleSort(nums);

        System.out.println(Arrays.toString(nums));
        System.out.println("Total Swaps = " + swaps);
    }
}