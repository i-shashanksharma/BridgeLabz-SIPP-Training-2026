
public class BinarySearchProblems {

    // 1. Binary Search
    static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    // 2. Search in Rotated Sorted Array
    static int searchRotated(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target)
                return mid;

            // Left half is sorted
            if (arr[left] <= arr[mid]) {
                if (target >= arr[left] && target < arr[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            // Right half is sorted
            else {
                if (target > arr[mid] && target <= arr[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return -1;
    }

    // 3. Find First Occurrence
    static int firstOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                ans = mid;
                right = mid - 1;
            } else if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return ans;
    }

    // 4. Find Last Occurrence
    static int lastOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                ans = mid;
                left = mid + 1;
            } else if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return ans;
    }

    // 5. Find Minimum Element / Rotation Point
    static int findMin(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[right])
                left = mid + 1;
            else
                right = mid;
        }

        return arr[left];
    }

    // 6. Find Rotation Point Index
    static int rotationPoint(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[right])
                left = mid + 1;
            else
                right = mid;
        }

        return left;
    }

    // 7. Find Peak Element
    static int findPeak(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < arr[mid + 1])
                left = mid + 1;
            else
                right = mid;
        }

        return left;
    }

    // 8. Search in 2D Sorted Matrix
    static boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int r = mid / cols;
            int c = mid % cols;

            if (matrix[r][c] == target)
                return true;
            else if (matrix[r][c] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return false;
    }

    public static void main(String[] args) {

        // Binary Search
        int[] arr1 = {2, 4, 6, 8, 10, 12, 14};
        System.out.println("Binary Search: " + binarySearch(arr1, 10));

        // Rotated Array
        int[] rotated = {15, 18, 2, 3, 6, 12};
        System.out.println("Search Rotated Array: " + searchRotated(rotated, 3));

        // First & Last Occurrence
        int[] arr2 = {1, 2, 2, 2, 3, 4, 5};
        System.out.println("First Occurrence: " + firstOccurrence(arr2, 2));
        System.out.println("Last Occurrence: " + lastOccurrence(arr2, 2));

        // Minimum Element
        int[] arr3 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Minimum Element: " + findMin(arr3));

        // Rotation Point
        System.out.println("Rotation Point Index: " + rotationPoint(rotated));

        // Peak Element
        int[] arr4 = {1, 3, 20, 4, 1, 0};
        int peak = findPeak(arr4);
        System.out.println("Peak Index: " + peak);
        System.out.println("Peak Element: " + arr4[peak]);

        // Search in Matrix
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        System.out.println("Search Matrix (16): " + searchMatrix(matrix, 16));
        System.out.println("Search Matrix (25): " + searchMatrix(matrix, 25));
    }
}