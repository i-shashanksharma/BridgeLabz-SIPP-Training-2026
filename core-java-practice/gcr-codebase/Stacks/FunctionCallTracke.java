class FunctionCallTracker {

    private static class Frame {
        String functionName;
        Frame next;

        Frame(String name, Frame next) {
            functionName = name;
            this.next = next;
        }
    }

    private Frame top = null;

    void push(String functionName) {
        top = new Frame(functionName, top);
    }

    String pop() {
        if (isEmpty())
            throw new RuntimeException("No active call");

        String name = top.functionName;
        top = top.next;

        return name;
    }

    String peek() {
        if (isEmpty())
            throw new RuntimeException("No active call");

        return top.functionName;
    }

    boolean isEmpty() {
        return top == null;
    }

    public static void main(String[] args) {
        FunctionCallTracker stack = new FunctionCallTracker();

        stack.push("main()");
        stack.push("calculate()");
        stack.push("print()");

        System.out.println(stack.peek());
        System.out.println(stack.pop());
    }
}