// Re-implement recursive factorial(n) (you already have this from Week 4 — just paste/adapt it), test with n = 8. Add the callCount tracking pattern from 
// Task 58 (Fibonacci) to it as well — increment a class-level counter once per call. (Maps to Q3 — compare the call count's 
// growth pattern to Fibonacci's.)

class Main {
    static int callCount = 0;

    public static void main(String[] args) {
        System.out.println("Factorial is: " + factorial(8));
        System.out.println(callCount);

    }

    public static int factorial(int n) {
        callCount++;
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
    // here also the TC is O(n) because the recursive call gets call n times apart from the constant work like call cout if condition
}