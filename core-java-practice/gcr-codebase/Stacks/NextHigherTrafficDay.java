import java.util.*;

class NextHigherTrafficDay {

    static int[] nextBusierDay(int[] visitors) {

        int n = visitors.length;

        int[] answer = new int[n];

        Arrays.fill(answer, -1);

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() &&
                   visitors[i] > visitors[stack.peek()]) {

                answer[stack.pop()] = visitors[i];
            }

            stack.push(i);
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] visitors = {100, 120, 90, 150, 130};

        System.out.println(Arrays.toString(nextBusierDay(visitors)));
    }
}