// Task 66 (deletion — a fresh derivation for you): Remove the node with value 30 from the chain. Think it 
// through: to delete a node, you don't need to touch the node itself at all — you just need to make the node 
// before it skip over it, pointing directly to the node after it instead. You'll need to traverse and keep 
// track of the previous node as you walk the chain looking for the one to delete (similar spirit to keeping a 
// "previous" tracker, which is a genuinely new pattern — think about what variable you need to hold onto as you 
// walk forward, so that when you find the target, you still have a handle on what came right before it).

class Task66_DeleteNode {
    public static void main(String[] main) {
        Node first = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);
        Node fourth = new Node(40);

        first.next = second;
        second.next = third;
        third.next = fourth;

        Node newNode = new Node(15);
        first.next = newNode;
        newNode.next = second;

        // list after insertion
        Node curr = first;
        System.out.print("After Insertion: ");
        while (curr != null) {
            System.out.print(curr.data + "->");
            curr = curr.next;
        }
        System.out.println();

        // removing value 30
        // second.next = fourth;
        // Node newCurr = first;
        // while (newCurr != null) {
        // System.out.print(newCurr.data + "->");
        // newCurr = newCurr.next;
        // } this is a more direct way to do it

        // another way as per the question asked to solved
        Node previous = null;
        Node current = first;
        while (current != null) {
            if (current.data == 30) {
                previous.next = current.next;
                break;
            }
            previous = current;
            current = current.next;
        }

        Node printCurr = first;
        while (printCurr != null) {
            System.out.print(printCurr.data + "->");
            printCurr = printCurr.next;
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