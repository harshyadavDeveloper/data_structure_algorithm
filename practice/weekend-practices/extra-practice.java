class Main {
    public static void main(String[] args) {
        // reverseString();
        // moveZeros();
        // missingNumberSorted();
        missingNumberUnsorted();
    }

    // task 1: Reverse an integer (no string conversion)
    public static void reverseString() {
        int number = 12;
        int newNumber = 0;

        while (number > 0) {
            int last = number % 10;
            newNumber = newNumber * 10 + last;
            number = number / 10;

        }
        System.out.println(newNumber);
    }

    // task 2: Move all zeroes to the end of an array, keep relative order of
    // non-zeros
    public static void moveZeros() {
        int[] arr = { 0, 1, 0, 3, 12 };
        int interPos = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[interPos] = arr[i];
                interPos++;
            }
        }

        while (interPos < arr.length) {
            arr[interPos] = 0;
            interPos++;
        }
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    // task 3: Find the missing number in an array containing 0 to n (one number
    // missing)
    public static void missingNumberSorted() {
        int[] arr = { 1, 2, 3, 4, 5, 6 }; // missing element is 7
        int missingNum = -1;
        if (arr[0] != 0) {
            System.out.println("Missing element: " + 0);
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] != arr[i] + 1) {
                missingNum = arr[i] + 1;
                System.out.print("Missing element: " + missingNum);
                break;
            }
        }
        if (missingNum == -1) {
            missingNum = arr[arr.length - 1] + 1;
            System.out.println("Last missing element is: " + missingNum);
        }
    }

    public static void missingNumberUnsorted() {
        int[] arr = { 3, 0, 1, 6, 4, 2 };
        int n = arr.length;
        int sum = n * (n + 1) / 2;
        for (int i = 0; i < arr.length; i++) {
            sum -= arr[i];
        }
        System.out.println("Missing Element is: " + sum);

    }
}