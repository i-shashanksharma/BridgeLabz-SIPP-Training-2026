import java.util.*;

class Pair<T, U> {
    T first;
    U second;

    Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public void display() {
        System.out.println(first + " " + second);
    }
}

class Stack<T> {
    ArrayList<T> list = new ArrayList<>();

    public void push(T item) {
        list.add(item);
    }

    public T pop() {
        if (list.isEmpty())
            return null;
        return list.remove(list.size() - 1);
    }

    public void display() {
        System.out.println(list);
    }
}

class Repository<T> {
    ArrayList<T> data = new ArrayList<>();

    public void add(T item) {
        data.add(item);
    }

    public void display() {
        System.out.println(data);
    }
}

public class GenericDemo {

    public static <T extends Comparable<T>> T findMax(T[] arr) {
        T max = arr[0];

        for (T item : arr) {
            if (item.compareTo(max) > 0)
                max = item;
        }

        return max;
    }

    public static void printList(List<?> list) {
        for (Object item : list) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<>("Age", 20);
        pair.display();

        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.display();
        System.out.println(stack.pop());

        Integer[] nums = {10, 50, 30, 40};
        System.out.println(findMax(nums));

        Repository<String> repo = new Repository<>();
        repo.add("Java");
        repo.add("Python");
        repo.display();

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        printList(names);
    }
}