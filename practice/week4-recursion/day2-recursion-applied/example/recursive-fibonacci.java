class RecursiveFibonacci {
    public static void main(String[] args) {
        for (int i = 0; i <= 9; i++) {
            System.out.print(recursiveFibonacci(i) + " ");
        }

    }

    public static int recursiveFibonacci(int n) {
        if (n == 0) {
            return 0;

        }
        if (n == 1) {
            return 1;
        }
        int result = recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
        // System.out.println(result);

        return result;
    }
}