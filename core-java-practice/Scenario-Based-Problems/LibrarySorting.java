import java.util.*;
public class LibrarySorting {
    static void mergeSort(int[] books, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(books, left, mid);
            mergeSort(books, mid + 1, right);
            merge(books, left, mid, right);
        }
    }

    static void merge(int[] books, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = books[left + i];

        for (int i = 0; i < n2; i++)
            R[i] = books[mid + 1 + i];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j])
                books[k++] = L[i++];
            else
                books[k++] = R[j++];
        }

        while (i < n1)
            books[k++] = L[i++];

        while (j < n2)
            books[k++] = R[j++];
    }


    static void quickSort(int[] books, int low, int high) {
        if (low < high) {
            int pivot = partition(books, low, high);

            quickSort(books, low, pivot - 1);
            quickSort(books, pivot + 1, high);
        }
    }

    static int partition(int[] books, int low, int high) {
        int pivot = books[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (books[j] <= pivot) {
                i++;

                int temp = books[i];
                books[i] = books[j];
                books[j] = temp;
            }
        }

        int temp = books[i + 1];
        books[i + 1] = books[high];
        books[high] = temp;
        return i + 1;
    }


    static void countingSort(int[] genres) {
        int[] count = new int[21];

        for (int genre : genres)
            count[genre]++;

        int index = 0;

        for (int i = 1; i <= 20; i++) {
            while (count[i] > 0) {
                genres[index++] = i;
                count[i]--;
            }
        }
    }


    static long measureMerge(int[] arr) {
        long start = System.nanoTime();
        mergeSort(arr, 0, arr.length - 1);
        return System.nanoTime() - start;
    }

    static long measureQuick(int[] arr) {
        long start = System.nanoTime();
        quickSort(arr, 0, arr.length - 1);
        return System.nanoTime() - start;
    }

    static long measureCounting(int[] arr) {
        long start = System.nanoTime();
        countingSort(arr);
        return System.nanoTime() - start;
    }


    public static void main(String[] args) {

        int[] sizes = {100, 1000, 10000};
        Random random = new Random();

        for (int size : sizes) {

            int[] years1 = new int[size];
            int[] years2 = new int[size];
            int[] genres = new int[size];

            for (int i = 0; i < size; i++) {
                years1[i] = 1900 + random.nextInt(126);
                years2[i] = years1[i];
                genres[i] = 1 + random.nextInt(20);
            }

            System.out.println("\nSize: " + size);

            System.out.println("Merge Sort: " +
                    measureMerge(years1) + " ns");

            System.out.println("Quick Sort: " +
                    measureQuick(years2) + " ns");

            System.out.println("Counting Sort: " +
                    measureCounting(genres) + " ns");
        }


        int[] sample = {2005, 1999, 2010, 1980, 2020};

        System.out.println("\nBefore Merge Sort:");
        System.out.println(Arrays.toString(sample));

        mergeSort(sample, 0, sample.length - 1);

        System.out.println("After Merge Sort:");
        System.out.println(Arrays.toString(sample));
    }
}