import java.util.ArrayList;

class Stack<T> {

    ArrayList<T> stack = new ArrayList<>();

    void push(T item) {
        stack.add(item);
    }

    T pop() {

        if (stack.isEmpty()) {
            return null;
        }

        return stack.remove(stack.size() - 1);
    }

    void display() {
        System.out.println(stack);
    }
}

public class StackDemo {

    public static void main(String[] args) {

        Stack<Integer> s = new Stack<>();

        s.push(10);
        s.push(20);
        s.push(30);

        s.display();

        System.out.println("Popped : " + s.pop());

        s.display();
    }
}