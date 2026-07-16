import java.util.*;
public class SportsMeet {
    static int bubbleSort(int[] scores) {
        int swaps = 0;
        boolean alreadySorted;

        for (int i = 0; i < scores.length - 1; i++) {
            alreadySorted = true;

            for (int j = 0; j < scores.length - i - 1; j++) {
                if (scores[j] > scores[j + 1]) {
                    int temp = scores[j];
                    scores[j] = scores[j + 1];
                    scores[j + 1] = temp;

                    swaps++;
                    alreadySorted = false;
                }
            }

            System.out.println("Bubble Pass " + (i + 1) + ": " + Arrays.toString(scores));

            if (alreadySorted) {
                System.out.println("Array already sorted (Best Case)");
                break;
            }
        }
        return swaps;
    }

    static int insertionSort(int[] scores) {
        int swaps = 0;

        for (int i = 1; i < scores.length; i++) {
            int key = scores[i];
            int j = i - 1;

            while (j >= 0 && scores[j] > key) {
                scores[j + 1] = scores[j];
                j--;
                swaps++;
            }

            scores[j + 1] = key;

            System.out.println("Insertion Pass " + i + ": " + Arrays.toString(scores));
        }

        return swaps;
    }

    static void topThree(int[] scores) {
        Arrays.sort(scores);

        System.out.println("Gold: " + scores[scores.length - 1]);
        System.out.println("Silver: " + scores[scores.length - 2]);
        System.out.println("Bronze: " + scores[scores.length - 3]);
    }

    static void traceArray() {
        int[] arr = {64, 25, 12, 22, 11};

        System.out.println("\nTrace for [64, 25, 12, 22, 11]");

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;

            System.out.println("Pass " + i + ": " + Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        int[] scores = new int[50];
        Random r = new Random();

        for (int i = 0; i < scores.length; i++) {
            scores[i] = r.nextInt(101);
        }

        int[] bubbleArray = scores.clone();
        int[] insertionArray = scores.clone();

        System.out.println("Original Scores:");
        System.out.println(Arrays.toString(scores));

        int bubbleSwaps = bubbleSort(bubbleArray);
        System.out.println("Bubble Sort Total Swaps: " + bubbleSwaps);

        int insertionSwaps = insertionSort(insertionArray);
        System.out.println("Insertion Sort Total Shifts: " + insertionSwaps);

        topThree(scores);

        traceArray();
    }
}