
/// Task 62: Using Java's built-in Queue (via LinkedList), simulate a simple ticket system: enqueue 5 
//  customer numbers (101, 102, 103, 104, 105), then process (dequeue and print) them one at a time in 
//  a loop until the queue is empty, printing "Serving customer: X" for each.
import java.util.LinkedList;
import java.util.Queue;

class Task62_QueueUsingBuiltIn {
    public static void main(String[] args) {
        ticketSystem();

    }

    public static void ticketSystem() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(101);
        queue.add(102);
        queue.add(103);
        queue.add(104);
        queue.add(105);

        while (!queue.isEmpty()) {
            System.out.println("Serving Cus: " + queue.poll());

        }

    }
}