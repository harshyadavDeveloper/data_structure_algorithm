// Task 51: Implement factorial(n) exactly as derived above, test with n = 6. Add a System.out.println at the very top of the 
// function (before the base case check) printing n, so you can literally watch the "going down" phase happen, then add another 
// print right before each return showing what's being returned, so you can watch the "coming back up" phase too.

class Task51_FactorialRecursive {
    public static void main(String[] args) {
        factorial(6);

    }

    public static int factorial(int n) {
        System.out.println("value of n: " + n);
        if (n == 0) {
            return 1;
        }
        int result = n * factorial(n - 1);
        System.out.println(result);
        return result;
    }
}