// Task 56: Implement recursive Fibonacci, print fibonacci(0) through fibonacci(10) in sequence (a loop calling the recursive 
// function 11 times, printing each result — this outer loop is fine, it's just driving the recursive calls).

class Task56_RecursiveFibonacci {
    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++) {
            System.out.print(fibonacciRecursive(i) + ", ");
        }

    }

    public static int fibonacciRecursive(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int result = fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
        return result;
    }
}