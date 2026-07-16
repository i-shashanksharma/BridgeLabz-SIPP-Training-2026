import java.util.Arrays;
import java.util.List;

public class WildcardDemo {

    public static void printList(List<?> list) {

        for (Object item : list) {
            System.out.print(item + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Ram", "Shyam", "Mohan");

        List<Integer> numbers = Arrays.asList(10, 20, 30);

        printList(names);

        printList(numbers);
    }
}