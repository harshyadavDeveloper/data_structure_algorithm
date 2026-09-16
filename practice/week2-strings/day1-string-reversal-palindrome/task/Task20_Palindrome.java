// Check if a string is a palindrome (reads the same forward and backward) — test with "racecar" (should be true) and "hello"
//  (should be false). Before coding, think: you already have a working reverse-string method from Task 18 or 19 — could you
//  solve this by comparing the original string to its reversed version? Would that actually work correctly, and is it the most
//  efficient approach, or can you check it more directly using the two-pointer idea without fully reversing first?

// class Task20_Palindrome {
//     public static void main(String[] args) {
//         isPalindrome("racecar");

//     }

//     // approach 1 to check after completly reversing the string
//     public static boolean isPalindrome(String word) {
//         char[] charWord = word.toCharArray();
//         int start = 0;
//         int end = word.length() - 1;
//         String reversed = "";
//         while (start < end) {
//             char temp = charWord[start];
//             charWord[start] = charWord[end];
//             charWord[end] = temp;
//             start++;
//             end--;
//         }

//         reversed = new String(charWord);
//         if (word.equals(reversed)) {
//             System.out.println("it is a palindrome");
//             return true;
//         } else {
//             System.out.println("it is not a palindrome");
//             return false;
//         }

//         /// same thing could have been done using for loop but i prefer this 

//     }
// }

class Task20_Palindrome {
    public static void main(String[] args) {
        String word = "hello";
        isPlaindrome(word);

    }

    public static boolean isPlaindrome(String word) {
        char[] newCharArr = word.toCharArray();

        int start = 0;
        int end = newCharArr.length - 1;
        while (start < end) {
            if (newCharArr[start] != newCharArr[end]) {
                System.out.println("Not a Palindrome");
                return false;
            }
            start++;
            end--;
        }

        System.out.println("It is a Palindrome");
        return true;
        /// this approach is much better because here we compare directly the char the
        /// place instead of creating a new string
        // adding char in it and then comparing
    }
}