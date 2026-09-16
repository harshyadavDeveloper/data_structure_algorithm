/// Task 60: Build the array-based queue exactly as derived above (enqueue, dequeue). Test it: enqueue 10, 20, 30, then dequeue 
// twice, printing what comes off each time (should be 10, then 20, confirming FIFO order).

class Task60_ArrayQueue{
    public static void main(String[] args){
        Queue.enqueue(10);
        Queue.enqueue(20);
        Queue.enqueue(30);
        System.out.println("Removed: " + Queue.dequeue());
        System.out.println("Removed: " + Queue.dequeue());

    }
}

class Queue{
    static int[] queue = new int[10];
    static int front =0;
    static int rear=-1;
    static int size=0;

    public static void enqueue(int value){
        rear++;
        queue[rear] = value;
        size++;
    }

    public static int dequeue(){
        int value = queue[front];
        front++;
        size--;
        return value;
    }
}