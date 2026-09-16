/// Task 59: Build the array-based stack exactly as derived above (push, pop, peek functions). Test it: push 10, 20, 30, then pop 
// twice, printing what comes off each time (should be 30, then 20, confirming LIFO order).

class Task59_ArrayStack {
    public static void main(String[] args) {
        Stack.push(10);
        Stack.push(20);
        Stack.push(30);

        System.out.println("At index 1: " + Stack.peekIndex(1));
        System.out.println("Popped: " + Stack.pop());
        System.out.println("Popped: " + Stack.pop());
        System.out.println("Peeked: " + Stack.peek());

    }
}

class Stack {
    static int[] stack = new int[10];
    static int top = -1; // -1 if there are no values present;

    public static void push(int value) {
        top++;
        stack[top] = value;
    }

    public static int pop() {
        int value = stack[top];
        top--;
        return value;
    }

    public static int peek() {
        return stack[top];
    }

    public static int peekIndex(int index) { // a stack should not show the internal values the entire point of stack is
                                             // to hide everything and show only the top element
        return stack[index];
    }
}