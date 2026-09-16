// Task 64: Insert a new node with value 5 at the front of your Task 63 list. Print the full chain before and 
// after to confirm.

class Task64_InsertAtFront {
    public static void main(String[] args) {
        Node first = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);
        Node fourth = new Node(40);

        first.next = second;
        second.next = third;
        third.next = fourth;

        // printing before inserting
        Node curr = first;
        System.out.println("Before LinkedList");
        while (curr != null) {
            System.out.print(curr.data + "->");
            curr = curr.next;
        }
        System.out.println();

        // inserting new Node(5) at the front
        Node newFirst = new Node(5);
        newFirst.next = first;
        first = newFirst;

        // printing after the insertion
        Node newCur = first;
        System.out.println("After LinkedList");
        while (newCur != null) {
            System.out.print(newCur.data + "->");
            newCur = newCur.next;

        }

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