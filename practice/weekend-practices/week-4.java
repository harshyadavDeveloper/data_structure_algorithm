class Main {
    public static void main(String[] args) {
        // System.out.println("Factorial is: " + factorial(7));
        // System.out.println(reverseString("word"));
        countDown(5);

    }

    /// task 1: Write factorial(n) recursively, test with n = 7.
    public static int factorial(int number) {
        if (number == 0 || number == 1) {
            return 1;
        }

        int result = number * factorial(number - 1);
        return result;
    }

    /// task 2: Write a recursive function to reverse a string (no loops, no
    /// toCharArray two-pointer trick — think: first character + recursive call on
    /// the rest, reversed).
    public static String reverseString(String word) {
        if (word.length() <= 1) {
            return word;
        }

        return reverseString(word.substring(1)) + word.charAt(0);

    }

    /// task 3: Write a recursive function countDown(n) that prints n, n-1, n-2,
    /// ..., 1 then prints "Liftoff".
    public static void countDown(int n) {
        if (n == 1) {
            System.out.println(n);
            System.out.println("Liftoff");
            return;
        }
        System.out.println(n);
        countDown(n - 1);
    }
}