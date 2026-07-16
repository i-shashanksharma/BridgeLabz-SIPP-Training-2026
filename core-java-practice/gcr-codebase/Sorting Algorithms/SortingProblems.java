public class SortingProblems {

    static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    static void merge(int[] arr, int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];

        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j])
                arr[k++] = L[i++];
            else
                arr[k++] = R[j++];
        }

        while (i < n1)
            arr[k++] = L[i++];

        while (j < n2)
            arr[k++] = R[j++];
    }


    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {

        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (arr[j] <= pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    static void countingSort(int[] arr, int maxValue) {

        int[] count = new int[maxValue + 1];

        for (int value : arr)
            count[value]++;

        int index = 0;

        for (int i = 0; i <= maxValue; i++) {
            while (count[i] > 0) {
                arr[index++] = i;
                count[i]--;
            }
        }
    }

    static int[] mergeSortedArrays(int[] a, int[] b) {

        int[] result = new int[a.length + b.length];

        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {

            if (a[i] <= b[j])
                result[k++] = a[i++];
            else
                result[k++] = b[j++];
        }

        while (i < a.length)
            result[k++] = a[i++];

        while (j < b.length)
            result[k++] = b[j++];

        return result;
    }

    static long countInversions(int[] arr) {
        return mergeSortCount(arr, 0, arr.length - 1);
    }

    static long mergeSortCount(int[] arr, int left, int right) {

        long count = 0;

        if (left < right) {

            int mid = left + (right - left) / 2;

            count += mergeSortCount(arr, left, mid);
            count += mergeSortCount(arr, mid + 1, right);
            count += mergeCount(arr, left, mid, right);
        }

        return count;
    }

    static long mergeCount(int[] arr, int left, int mid, int right) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];

        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;
        long inv = 0;

        while (i < n1 && j < n2) {

            if (L[i] <= R[j])
                arr[k++] = L[i++];
            else {
                arr[k++] = R[j++];
                inv += (n1 - i);
            }
        }

        while (i < n1)
            arr[k++] = L[i++];

        while (j < n2)
            arr[k++] = R[j++];

        return inv;
    }

    static int kthHighest(int[] arr, int k) {

        int target = arr.length - k;

        int low = 0, high = arr.length - 1;

        while (true) {

            int p = partition(arr, low, high);

            if (p == target)
                return arr[p];
            else if (p < target)
                low = p + 1;
            else
                high = p - 1;
        }
    }

    static long fraudPairs(int[] arr) {
        return fraudMergeSort(arr, 0, arr.length - 1);
    }

    static long fraudMergeSort(int[] arr, int left, int right) {

        if (left >= right)
            return 0;

        int mid = left + (right - left) / 2;

        long count = fraudMergeSort(arr, left, mid)
                + fraudMergeSort(arr, mid + 1, right);

        int j = mid + 1;

        for (int i = left; i <= mid; i++) {
            while (j <= right && (long) arr[i] > 3L * arr[j])
                j++;
            count += j - (mid + 1);
        }

        merge(arr, left, mid, right);

        return count;
    }


    static void printArray(int[] arr) {

        for (int x : arr)
            System.out.print(x + " ");

        System.out.println();
    }


    public static void main(String[] args) {

        int[] salaries = {45000, 32000, 78000, 55000, 40000, 60000};
        mergeSort(salaries, 0, salaries.length - 1);
        System.out.print("Merge Sort: ");
        printArray(salaries);

        int[] prices = {4500, 2200, 3800, 1800, 5200};
        quickSort(prices, 0, prices.length - 1);
        System.out.print("Quick Sort: ");
        printArray(prices);

        int[] genres = {5, 2, 7, 1, 5, 3, 2, 4};
        countingSort(genres, 20);
        System.out.print("Counting Sort: ");
        printArray(genres);

        int[] a = {1, 4, 8};
        int[] b = {2, 5, 7};
        System.out.print("Merged Arrays: ");
        printArray(mergeSortedArrays(a, b));

        int[] scores = {70, 95, 80, 100};
        System.out.println("Promotion Conflicts: " + countInversions(scores));

        int[] priority = {10, 30, 15, 50, 40};
        System.out.println("2nd Highest Priority: " + kthHighest(priority, 2));

        int[] transactions = {12, 4, 5, 2};
        System.out.println("Fraud Pairs: " + fraudPairs(transactions));

        int[] response = {300, 250, 270, 100};
        System.out.println("Performance Violations: " + countInversions(response));

        int[] sizes = {100, 1000, 10000};

        for (int size : sizes) {

            int[] arr = new int[size];

            for (int i = 0; i < size; i++)
                arr[i] = (int) (Math.random() * 100000);

            int[] copy1 = arr.clone();
            int[] copy2 = arr.clone();

            long start = System.nanoTime();
            mergeSort(copy1, 0, copy1.length - 1);
            long mergeTime = System.nanoTime() - start;

            start = System.nanoTime();
            quickSort(copy2, 0, copy2.length - 1);
            long quickTime = System.nanoTime() - start;

            System.out.println("\nSize = " + size);
            System.out.println("Merge Sort Time = " + mergeTime + " ns");
            System.out.println("Quick Sort Time = " + quickTime + " ns");
        }
    }
}