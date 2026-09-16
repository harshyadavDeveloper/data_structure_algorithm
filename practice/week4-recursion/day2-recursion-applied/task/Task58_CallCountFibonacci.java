// Task 58 (making the waste visible): Add a static int callCount = 0; variable (declared outside the function, at the class level,
// so it persists across all recursive calls), increment it once at the very top of fibonacci() on every single call, and print 
// the total callCount after computing fibonacci(10). Compare that number to what you'd expect if each Fibonacci value were 
// computed only once (roughly 11 computations for fibonacci(0) through fibonacci(10)) — the gap between those two numbers is 
// the wasted, duplicated work, made concrete and countable rather than just visible in a tree diagram.

class Task58_CallCountFibonacci {
    static int count = 0;

    public static void main(String[] args) {
        fibonacci(10);

        System.out.println("Count: " + count);

    }

    public static int fibonacci(int n) {
        count++;

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int result = fibonacci(n - 1) + fibonacci(n - 2);
        return result;
    }

}