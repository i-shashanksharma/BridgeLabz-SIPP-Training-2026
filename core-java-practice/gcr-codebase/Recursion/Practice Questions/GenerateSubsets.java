import java.util.*;
public class GenerateSubsets {
    static void generateSubsets(int[] arr, List<Integer> subset, int index) {
        if (index == arr.length) {
            System.out.println(subset);
            return;
        }

        generateSubsets(arr, subset, index + 1);

        subset.add(arr[index]);
        generateSubsets(arr, subset, index + 1);

        subset.remove(subset.size() - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2};
        generateSubsets(arr, new ArrayList<>(), 0);
    }
}