class Main {
    public static void main(String[] args) {
        // printMultiples();
        // printSecondlargest();
        // printCount();
        // fibonacci();
        // printNumCount();
        // reverseArray();
        // System.out.println("Is Prime: " + isPrime(30));
        // printEvenSum();
        // printStarts();
        printRepeatedVal();

    }

    // task 1: Print all multiples of 4 between 1 and 50 (inclusive).
    public static void printMultiples() {
        for (int i = 1; i <= 50; i++) {
            if (i % 4 == 0) {
                System.out.println(i);
            }
        }
    }

    // task 2: Given {12, 45, 7, 89, 34, 2}, find and print the second largest value
    // (no sorting allowed — one pass, using logic).
    public static void printSecondlargest() {
        int[] arr = { 12, 45, 7, 89, 89, 34, 2 };
        // int[] arr = { 89, 89, 45 };
        int firstHighest = arr[0];
        int secondHighest = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > firstHighest) {
                secondHighest = firstHighest;
                firstHighest = arr[i];
            } else if (arr[i] < firstHighest && arr[i] > secondHighest) {
                secondHighest = arr[i];
            }
        }
        System.out.println(secondHighest);
    }

    // task 3: Given {3, 7, 2, 7, 5, 7, 9}, count and print how many times the value
    // 7 appears.
    public static void printCount() {
        int[] arr = { 3, 7, 2, 7, 5, 7, 9 };
        int target = 7;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                count++;
            }
        }
        System.out.println(count);
    }

    // task 4: Print the first 10 numbers of the Fibonacci sequence (0, 1, 1, 2, 3,
    // 5, 8...) using a loop — no recursion.
    public static void fibonacci() {
        int first = 0;
        int second = 1;

        for (int i = 0; i < 10; i++) {
            System.out.println(first);
            int sum = first + second;
            first = second;
            second = sum;
        }
    }

    // task 5: Given {4, -2, 7, -9, 1, 0, -5}, print the count of positive numbers
    // and the count of negative numbers.
    public static void printNumCount() {
        int[] arr = { 4, -2, 7, -9, 1, 0, -5 };
        int positive = 0;
        int negative = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                positive++;
            } else {
                negative++;
            }
        }
        System.out.println("Positive: " + positive);
        System.out.println("Negative: " + negative);
    }

    // task 6: Reverse an array in place — given {1, 2, 3, 4, 5}, print it reversed
    // (5, 4, 3, 2, 1) without creating a second array (swap elements using a temp
    // variable).
    public static void reverseArray() {
        int[] arr = { 1, 2, 3, 4, 5 };
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    // task 7: Check if a number is prime — write it as a reusable check for int n,
    // test it with n = 29 and n = 30.
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) { // only need to go upto srqroot of n, because after that factors just mirrors
                                           // the ones we already checked. it can alse be written as i<= Math.sqrt(n)

            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // task 8: Given {5, 12, 8, 130, 44}, find and print the sum of only the even
    // numbers.
    public static void printEvenSum() {
        int[] arr = { 5, 12, 8, 130, 44 };
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                sum += arr[i];
            }
        }
        System.out.println(sum);
    }

    // task 9: Print a right-angled triangle pattern of stars, 5 rows tall:
    public static void printStarts() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // task 10: Given {2, 5, 5, 2, 3, 3, 2}, find and print any one element that
    // appears more than once (first repeated value found, using nested loops — for
    // each element, check if it matches any earlier element).
    public static void printRepeatedVal() {
        int[] arr = { 2, 5, 5, 2, 3, 3, 2 };
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    System.out.println(arr[i]);
                    return;
                }
            }
        }
    }
}