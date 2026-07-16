import java.util.*;

class ConfigBracketValidator {

    static boolean isValidConfig(String s) {

        Deque<Character> stack = new ArrayDeque<>();

        Map<Character, Character> matchFor = new HashMap<>();

        matchFor.put(')', '(');
        matchFor.put(']', '[');
        matchFor.put('}', '{');

        for (char c : s.toCharArray()) {

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } 
            else {
                if (stack.isEmpty() || stack.pop() != matchFor.get(c))
                    return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {

        String config = "{[()]}";

        System.out.println(isValidConfig(config));
    }
}