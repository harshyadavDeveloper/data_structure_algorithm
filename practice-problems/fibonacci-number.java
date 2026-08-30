class Main {
    public static void main(String[] args) {
        // int end = 10;
        // int first = 0;
        // int second = 1;

        // for (int i = 0; i < end; i++) {
        // System.out.print(first + ", ");

        // int next = first + second;
        // first = second;
        // second = next;

        // }
        int end = 10;

        for (int i = 0; i < end; i++) {
            System.out.print(fibonacci(i) + ", ");
        }

    }

    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);

    }
}