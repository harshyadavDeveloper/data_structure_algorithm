// Count the number of vowels (a, e, i, o, u — lowercase only, for now) in the string "programming is fun"

class Task21_CountVowels {
    public static void main(String[] args) {
        String check = "programming is fun";
        char[] arr = check.toCharArray();
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') {
                count++;
            }
        }
        System.out.println("Total Count: " + count);
    }
}

/// another approach that i had thought about first before the above solution

// class Task21_CountVowels {
// public static void main(String[] args) {
// String check = "programming is fun";

// char[] arr = check.toCharArray();
// char[] vowels = {'a', 'e', 'i', 'o', 'u'};

// int count = 0;

// for (int i = 0; i < arr.length; i++) {

// for (int j = 0; j < vowels.length; j++) {

// if (arr[i] == vowels[j]) {
// count++;
// break; // Stop checking once a vowel is found
// }

// }

// }

// System.out.println("Total vowels: " + count);
// }
// }

// branch question to print the vowels too
// class Task21_CountVowels {
// public static void main(String[] args) {
// String check = "programming is fun";

// char[] arr = check.toCharArray();
// char[] vowels = {'a', 'e', 'i', 'o', 'u'};

// for (int i = 0; i < arr.length; i++) {
// for (int j = 0; j < vowels.length; j++) {
// if (arr[i] == vowels[j]) {
// System.out.println(arr[i]);
// break;
// }
// }
// }
// }
// }

// branch question print only unique vowels
// class Task21_CountVowels {
// public static void main(String[] args) {
// String check = "programming is fun";

// char[] arr = check.toCharArray();
// char[] vowels = {'a', 'e', 'i', 'o', 'u'};
// boolean[] printed = new boolean[5];

// for (int i = 0; i < arr.length; i++) {
// for (int j = 0; j < vowels.length; j++) {
// if (arr[i] == vowels[j] && !printed[j]) {
// System.out.println(arr[i]);
// printed[j] = true;
// break;
// }
// }
// }
// }
// }