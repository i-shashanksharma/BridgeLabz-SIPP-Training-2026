import java.util.*;

public class StackCompilerValidator {

    static boolean validateBrackets(String code) {

        Stack<Character> stack = new Stack<>();

        for (char ch : code.toCharArray()) {

            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }

            else if (ch == ')' || ch == '}' || ch == ']') {

                if (stack.isEmpty())
                    return false;

                char top = stack.pop();

                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }


    static int[] nextGreaterPrice(int[] prices) {

        int n = prices.length;
        int[] result = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() &&
                    stack.peek() <= prices[i]) {
                stack.pop();
            }

            if (stack.isEmpty())
                result[i] = -1;
            else
                result[i] = stack.peek();

            stack.push(prices[i]);
        }

        return result;
    }


    static int[] stockSpan(int[] prices) {

        int n = prices.length;
        int[] span = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() &&
                    prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            if (stack.isEmpty())
                span[i] = i + 1;
            else
                span[i] = i - stack.peek();

            stack.push(i);
        }

        return span;
    }


    public static void main(String[] args) {

        String code1 = "{[()]}";
        String code2 = "{[(])}";

        System.out.println("Code 1 Valid: "
                + validateBrackets(code1));

        System.out.println("Code 2 Valid: "
                + validateBrackets(code2));


        int[] prices = {100, 80, 60, 70, 60, 75, 85};

        System.out.println("Stock Prices:");
        System.out.println(Arrays.toString(prices));

        System.out.println("Next Greater Price:");
        System.out.println(Arrays.toString(
                nextGreaterPrice(prices)));

        System.out.println("Stock Span:");
        System.out.println(Arrays.toString(
                stockSpan(prices)));
    }
}