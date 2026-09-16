// Task 63: Build the Node class as derived above. Manually create and link four nodes (10 → 20 → 30 → 40), then 
// traverse and print the full chain using the while loop pattern shown.

class Task63_LinkedListBuildTraverse {
    public static void main(String[] args) {
        Node first = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);
        Node fourth = new Node(40);

        first.next = second;
        second.next = third;
        third.next = fourth;

        Node curr = first;
        while (curr != null) {
            System.out.print(curr.data + "->");
            curr = curr.next;
        }
        System.out.print("null");

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