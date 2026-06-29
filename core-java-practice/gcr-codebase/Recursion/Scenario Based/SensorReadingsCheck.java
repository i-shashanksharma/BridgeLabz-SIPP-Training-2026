public class SensorReadingsCheck {
    static boolean isIncreasing(int[] arr, int i) {
        if (i == arr.length - 1)
            return true;
        if (arr[i] >= arr[i + 1])
            return false;
        return isIncreasing(arr, i + 1);
    }

    public static void main(String[] args) {
        int[] arr = {12, 15, 18, 22, 30};
        System.out.println(isIncreasing(arr, 0));
    }
}