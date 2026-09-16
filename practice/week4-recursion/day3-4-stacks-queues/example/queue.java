class queue {
    public static void main(String[] args) {

        Queue.enqueue(10);
        Queue.enqueue(20);
        Queue.enqueue(30);

        System.out.println("Front: " + Queue.peekFront());
        System.out.println("Back: " + Queue.peekBack());

        System.out.println("Dequeued: " + Queue.dequeue());

        System.out.println("Front: " + Queue.peekFront());
        System.out.println("Back: " + Queue.peekBack());

        System.out.println("Dequeued: " + Queue.dequeue());

        System.out.println("Front: " + Queue.peekFront());
        System.out.println("Back: " + Queue.peekBack());

    }

}

class Queue {
    static int[] queue = new int[10];
    static int front = 0;
    static int rear = -1;
    static int size = 0;

    public static void enqueue(int value) { // add the value to the end
        rear++;
        queue[rear] = value;
        size++;
    }

    public static int dequeue() { // remove the front value
        int value = queue[front];
        front++;
        size--;
        return value;
    }

    public static int peekFront() { // peek the front value without removing
        return queue[front];
    }

    public static int peekBack() { // peek the last value without removing
        return queue[rear];
    }

}