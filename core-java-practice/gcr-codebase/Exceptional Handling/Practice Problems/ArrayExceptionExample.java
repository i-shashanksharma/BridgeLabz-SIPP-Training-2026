public class ArrayExceptionExample {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30};
        try {
            int index = 5;
            System.out.println(arr[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        }
    }
}