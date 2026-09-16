class recursion {
    public static void main(String[] args) {
        // factorial(7);
        sumOfDigit(123445);
        // System.out.print(fact + " ");

    }

    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        int result = n * factorial(n - 1);
        System.out.println(result);

        return result;

    }

    public static int sumOfDigit(int n) {
        if (n == 0) {
            return 0;
        }
        int result = (n % 10) + sumOfDigit(n / 10);
        System.out.println(result);
        return result;
    }
}