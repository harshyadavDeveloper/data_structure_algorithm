import java.util.HashMap;

class Main {
    public static void main(String[] args) {
        // printFactors();
        // findAverage();
        // checkNumberPalindrome();
        // checkMode();
        // reverseVowels();
        // System.out.println(containsDigit("Ha1rsh"));
        // isPrimeNumber(50);
        // System.out.println(isPrime(47));
        // isPrimeNumber(50);
        // printEvenIndexes();
        checkRotation();

    }

    // 1. Print all numbers from 1 to 100 that are divisible by both 3 and 7.
    public static void printFactors() {
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 7 == 0) {
                System.out.println(i);
            } else if (i % 3 == 0) {
                System.out.println(i);

            } else if (i % 7 == 0) {
                System.out.println(i);
            }
        }
    }

    // 2. Given {3, 9, 1, 7, 5, 2}, find the sum and the average in one pass.
    public static void findAverage() {
        int[] arr = { 3, 9, 1, 7, 5, 2 };
        int sum = 0;
        double average = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        average = (double) sum / 2;
        System.out.println("Sum: " + sum + " " + "Average: " + average);

    }

    // 3. Check if a number n is a palindrome (e.g., 12321 is, 1234 isn't) — without
    // converting it to a string, using only
    // arithmetic (% and /).
    public static void checkNumberPalindrome() {
        int number = 12321;
        int original = number;
        int reversed = 0;

        while (number > 0) {
            int last = number % 10;
            reversed = reversed * 10 + last;
            number = number / 10;
        }

        if (original == reversed) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a palindrome");
        }
    }

    // 4. Given {4, 2, 9, 2, 5, 9, 9}, find which number appears the most times (the
    // mode).
    public static void checkMode() {
        // for this 2 approaches can be used first is the nested loop and then a better
        // approad is hashmap
        int[] arr = { 4, 2, 9, 2, 5, 9, 9, 1, 1, 1, 1, 1, 1 };
        HashMap<Integer, Integer> map = new HashMap<>();
        int mode = -1;
        int maxCount = 0;

        for (int num : arr) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);

            if (count > maxCount) {
                maxCount = count;
                mode = num;
            }
        }

        System.out.println(mode);

        // int maxCount = 0;
        // int mode = arr[0];

        // for (int i = 0; i < arr.length; i++) {
        // int count = 0;
        // for (int j = 0; j < arr.length; j++) {
        // if (arr[i] == arr[j]) {
        // count++;

        // }
        // }
        // if (count > maxCount) {
        // maxCount = count;
        // mode = arr[i];
        // }

        // }
        // System.out.println("Mode: " + mode);

    }

    // 5. Reverse only the vowels in a string — e.g., "hello" → "holle" (h-e-l-l-o →
    // h-o-l-l-e).

    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void reverseVowels() {
        String word = "hello";
        char[] arr = word.toCharArray();
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            while (start < end && !isVowel(arr[start])) {
                start++;
            }
            while (start < end && !isVowel(arr[end])) {
                end--;
            }
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;

        }
        String newWord = new String(arr);

        System.out.println(newWord);
    }

    // 6. Given a string, check if it contains only digits (no loops using built-in
    // isDigit — use character range comparison
    // '0' to '9').

    public static boolean containsDigit(String word) {
        for (int i = 0; i < word.length(); i++) {
            char currChar = word.charAt(i);
            if (Character.isDigit(currChar)) {

                return true;
            }
        }
        return false;
    }

    // 7. Print all prime numbers between 1 and 50 (reuse or rebuild your
    // prime-check logic).
    public static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }

        }
        return true;
    }

    public static void isPrimeNumber(int number) {
        for (int i = 1; i <= number; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    // 8. Given {1, 2, 3, 4, 5, 6, 7, 8, 9}, print elements at even indexes only.
    public static void printEvenIndexes() {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        for (int i = 0; i < arr.length; i += 2) {
            System.out.println(arr[i]);
        }
    }

    // 9. Given two strings, check if one is a rotation of the other (e.g., "abcde"
    // and "cdeab" — true).
    public static void checkRotation() {
        String word1 = "abcde";
        String word2 = "cdeabsdd";
        String result = word1 + word1;

        if (result.contains(word2)) {
            System.out.println("It is a rotation");
        } else {

            System.out.println("It is not a rotation");
        }
    }

}