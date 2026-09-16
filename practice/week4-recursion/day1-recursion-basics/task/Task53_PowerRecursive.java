// Task 53 (a fresh one to derive yourself): Implement power(base, exp) — computing base^exp (e.g., power(2, 5) = 32) using 
// recursion, not Math.pow. Think it through the same way as factorial: how can 2^5 be redefined in terms of a smaller version 
// of itself? What's the base case (the smallest exponent that needs no further breaking down)?

class Task53_PowerRecursive {
    public static void main(String[] args) {
        power(4, 5);

    }

    public static int power(int base, int exp) {

        if (exp == 0) {
            return 1;
        }

        int result = 0;

        result = base * power(base, (exp - 1));
        System.out.println(result);
        return result;
    }
}