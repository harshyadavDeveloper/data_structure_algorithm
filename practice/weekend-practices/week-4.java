import java.util.*;
import java.util.Queue;
import java.util.Stack;

class Main {
    public static void main(String[] args) {
        String word = "racecar";
        // System.out.println("Factorial is: " + factorial(7));
        // System.out.println(reverseString("word"));
        // countDown(5);
        // stacksNqueues();
        // System.out.println("Total Sum is: " + printSum(0));
        // roundRobin();
        // printLength();
        // System.out.println("IS PALINDROME: " + isPalindrome(word, 0, word.length() -
        // 1));
        System.out.println("IS PALINDROME: " + isPalindrome2(word));

    }

    /// task 1: Write factorial(n) recursively, test with n = 7.
    public static int factorial(int number) {
        if (number == 0 || number == 1) {
            return 1;
        }

        int result = number * factorial(number - 1);
        return result;
    }

    /// task 2: Write a recursive function to reverse a string (no loops, no
    /// toCharArray two-pointer trick — think: first character + recursive call on
    /// the rest, reversed).
    public static String reverseString(String word) {
        if (word.length() <= 1) {
            return word;
        }

        return reverseString(word.substring(1)) + word.charAt(0);

    }

    /// task 3: Write a recursive function countDown(n) that prints n, n-1, n-2,
    /// ..., 1 then prints "Liftoff".
    public static void countDown(int n) {
        if (n == 1) {
            System.out.println(n);
            System.out.println("Liftoff");
            return;
        }
        System.out.println(n);
        countDown(n - 1);
    }

    /// task 4: Implement a stack (array-based or Stack<Integer>) and use it to
    /// reverse the order of a queue's elements: push everything from a queue into a
    /// stack, then pop everything back into a new queue.
    public static void stacksNqueues() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);

        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()) {
            stack.add(queue.poll());
        }
        Queue<Integer> reversedQueue = new LinkedList<>();
        while (!stack.isEmpty()) {
            reversedQueue.add(stack.pop());

        }
        for (int num : reversedQueue) {
            System.out.println(num);
        }
    }

    /// task 5: Recursively compute the sum of an array {6, 2, 9, 4, 1} (same
    /// pattern as your Week 4 array-sum task).
    public static int printSum(int index) {
        int[] arr = { 6, 2, 9, 4, 1 };
        if (index == arr.length) {
            return 0;
        }
        return arr[index] + printSum(index + 1);
    }

    /// task 6: Using a Queue<Integer>, simulate a basic round-robin: enqueue
    /// 1,2,3,4,5, then dequeue one, print it, and re-enqueue it at the back — do
    /// this 8 times total, and observe the cycling pattern.
    public static void roundRobin() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        for (int i = 1; i <= 8; i++) {
            int removeVal = queue.poll(); // removes the first element and returns it
            System.out.println(removeVal);
            queue.add(removeVal);
        }
    }

    /// task 7: Build a linked list 5 → 10 → 15 → 20, then write a function to find
    /// and
    /// return the length of the list by traversal (no recursion needed, just count
    /// nodes).
    public static void printLength() {
        Node first = new Node(5);
        Node second = new Node(10);
        Node third = new Node(15);
        Node fourth = new Node(20);

        first.next = second;
        second.next = third;
        third.next = fourth;

        int count = 0;
        Node curr = first;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        System.out.println(count);

    }

    /// task 8: Recursively check if a string is a palindrome (base case: string of
    /// length 0 or 1; recursive case: first and last characters match, then recurse
    /// on the substring between them).
    public static boolean isPalindrome(String word, int start, int end) {
        if (start >= end) {
            return true;
        }

        if (word.charAt(start) == word.charAt(end)) {
            start = start + 1;
            end = end - 1;

            return isPalindrome(word, start, end);
        }
        return false;

    }

    public static boolean isPalindrome2(String word) {
        int n = word.length();
        if (n <= 1) {
            return true;
        }

        int first = 0;
        int last = n - 1;

        if (word.charAt(first) != word.charAt(last)) {
            System.out.println(word.charAt(first) + " and " + word.charAt(last));
            return false;
        }
        return isPalindrome2(word.substring(first + 1, last));
    }
}

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}