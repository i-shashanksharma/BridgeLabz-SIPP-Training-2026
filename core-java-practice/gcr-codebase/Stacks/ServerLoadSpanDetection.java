import java.util.*;

class ServerLoadSpanDetection {

    static int[] loadSpan(int[] load) {

        int n = load.length;

        int[] span = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() &&
                   load[stack.peek()] <= load[i]) {

                stack.pop();
            }

            span[i] = stack.isEmpty() ? i + 1 : i - stack.peek();

            stack.push(i);
        }

        return span;
    }

    public static void main(String[] args) {

        int[] load = {100, 80, 60, 70, 60, 75, 85};

        System.out.println(Arrays.toString(loadSpan(load)));
    }
}