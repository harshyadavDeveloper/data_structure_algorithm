// Task 52: Implement sumOfDigits(n) as derived above, test with n = 98765.

class Main {
    public static void main(String[] main) {
        sumOfDigit(98765);

    }

    public static int sumOfDigit(int n) {
        if (n == 0) {
            return 0;
        }
        int result = (n % 10) + sumOfDigit(n / 10);
        System.out.print(result + " ");
        return result;
    }
}