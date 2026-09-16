// Task 65: Insert a new node with value 25 between 20 and 30 in your list (so the chain becomes 10→20→25→30→40). 
// Think carefully about the order of the two reference reassignments, the way it was derived above — get the 
// order wrong and you'll silently lose the rest of the chain.

// class Task65_InsertAtPosition {
//     public static void main(String[] args) {
//         Node first = new Node(10);
//         Node second = new Node(20);
//         Node third = new Node(30);
//         Node fourth = new Node(40);

//         first.next = second;
//         second.next = third;
//         third.next = fourth;

//         Node newNode = new Node(25);
//         /// Q1. What should NEW point to? answer: NEW → NEXT
//         /// Q2. What should PREVIOUS point to? answer: PREVIOUS → NEW
//         /// here 25 should clearly go between 20 -> 30
//         /// so 25.next should point to 30 --> that is the first question answered
//         /// second question is what should previous point to and the answer is 20.next
//         /// should point to 25
//         /// with these 25 is inserted and 20->25->30 are connected

//         second.next = newNode;
//         newNode.next = third;

//         Node curr = first;
//         while (curr != null) {
//             System.out.print(curr.data + "->");
//             curr = curr.next;
//         }

//     }
// }

class Task65_InsertAtPosition {
    public static void main(String[] args) {
        Node first = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);
        Node fourth = new Node(40);

        first.next = second;
        second.next = third;
        third.next = fourth;

        Node newNode = new Node(35);
        third.next = newNode;
        newNode.next = fourth;

        Node curr = first;
        while (curr != null) {
            System.out.print(curr.data + "->");
            curr = curr.next;
        }

        /// PREVIOUS → NEXT

        // becomes

        // PREVIOUS → NEW → NEXT

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