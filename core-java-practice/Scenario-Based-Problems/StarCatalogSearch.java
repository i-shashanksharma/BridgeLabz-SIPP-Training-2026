import java.util.*;
public class StarCatalogSearch {
    static int binarySearch(int[] stars, int target) {
        int low = 0;
        int high = stars.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (stars[mid] == target)
                return mid;

            if (stars[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return -1;
    }


    static int rotatedBinarySearch(int[] stars, int target) {
        int low = 0;
        int high = stars.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (stars[mid] == target)
                return mid;

            if (stars[low] <= stars[mid]) {
                if (target >= stars[low] && target < stars[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            } else {
                if (target > stars[mid] && target <= stars[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return -1;
    }


    static int firstOccurrence(int[] stars, int target) {
        int low = 0;
        int high = stars.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (stars[mid] == target) {
                result = mid;
                high = mid - 1;
            } else if (stars[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }


    static int lastOccurrence(int[] stars, int target) {
        int low = 0;
        int high = stars.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (stars[mid] == target) {
                result = mid;
                low = mid + 1;
            } else if (stars[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }


    static int findMinimum(int[] stars) {
        int low = 0;
        int high = stars.length - 1;

        while (low < high) {
            int mid = (low + high) / 2;

            if (stars[mid] > stars[high])
                low = mid + 1;
            else
                high = mid;
        }

        return stars[low];
    }


    public static void main(String[] args) {

        int[] sortedStars = {
            10, 20, 30, 40, 50, 60, 70
        };

        int target = 40;

        System.out.println("Binary Search Index: "
                + binarySearch(sortedStars, target));


        int[] rotatedCatalog = {
            50, 60, 70, 10, 20, 30, 40
        };

        System.out.println("Rotated Search Index: "
                + rotatedBinarySearch(rotatedCatalog, 30));


        int[] repeatedBrightness = {
            10, 20, 20, 20, 30, 40
        };

        System.out.println("First Occurrence: "
                + firstOccurrence(repeatedBrightness, 20));

        System.out.println("Last Occurrence: "
                + lastOccurrence(repeatedBrightness, 20));


        int[] glitchCatalog = {
            40, 50, 60, 10, 20, 30
        };

        System.out.println("Minimum Brightness: "
                + findMinimum(glitchCatalog));
    }
}