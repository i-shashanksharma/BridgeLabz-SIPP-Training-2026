class UndoBufferStack {

    private String[] data;
    private int top;

    UndoBufferStack(int maxDepth) {
        data = new String[maxDepth];
        top = -1;
    }

    boolean push(String edit) {
        if (top == data.length - 1)
            return false;

        data[++top] = edit;
        return true;
    }

    String pop() {
        if (isEmpty())
            throw new RuntimeException("Nothing to undo");

        return data[top--];
    }

    String peek() {
        if (isEmpty())
            throw new RuntimeException("Nothing to undo");

        return data[top];
    }

    boolean isEmpty() {
        return top == -1;
    }

    public static void main(String[] args) {
        UndoBufferStack stack = new UndoBufferStack(3);

        stack.push("Type A");
        stack.push("Type B");
        stack.push("Delete C");

        System.out.println(stack.peek());
        System.out.println(stack.pop());
    }
}