// Task 67: Given a linked list 10 → 20 → 30 → 40, write a function that sums all the node values by traversing the list 
// (reuse the accumulator pattern from Week 1 — same idea, just walking .next instead of incrementing an array index).

class Task67_LinkedListSum {
    public static void main(String[] args) {
        Node first = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);
        Node fourth = new Node(40);

        first.next = second;
        second.next = third;
        third.next = fourth;

        Node curr = first;
        int sum = 0;
        while (curr != null) {
            sum = sum + curr.data;
            curr = curr.next;
        }
        System.out.print("Sum: " + sum);

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