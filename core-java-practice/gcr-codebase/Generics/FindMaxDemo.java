public class FindMaxDemo {

    public static <T extends Comparable<T>> T findMax(T[] arr) {

        T max = arr[0];

        for (T value : arr) {

            if (value.compareTo(max) > 0) {
                max = value;
            }
        }

        return max;
    }

    public static void main(String[] args) {

        Integer[] numbers = {12, 45, 67, 23, 89};

        System.out.println("Maximum = " + findMax(numbers));

        String[] names = {"Ram", "Mohan", "Shyam"};

        System.out.println("Maximum = " + findMax(names));
    }
}