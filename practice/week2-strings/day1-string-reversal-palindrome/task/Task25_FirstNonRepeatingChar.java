// Find the first non-repeating character in "swiss" — i.e., the first letter whose frequency count is exactly 1
//  (expected answer: 'w', since s repeats but w appears only once and comes before i). Think carefully here: you'll likely
//  need two passes over the string — one to build the frequency counts, and a second to walk through the string in its
//  original order checking each character's count, since scanning the freq[26] array directly won't preserve the original
//  left-to-right order of the string itself.

// class Main {
//     public static void main(String[] args) {
//         String word = "swiss";
//         int[] freq = new int[26];

//         for (int i = 0; i < word.length(); i++) {
//             char c = word.charAt(i); // grab the char
//             int index = c - 'a'; // get the index from it
//             freq[index] += 1; // update it in the array
//         }

//         for (int i = 0; i < word.length(); i++) { // loop thru word because that has order stored naturally
//             char c = word.charAt(i); // grab the char
//             int index = c - 'a'; // get the index
//             if (freq[index] == 1) { // check if the freq is exactly 1
//                 System.out.println(c + " " + freq[index]); // return it here returing the char too(optional not what is
//                                                            // asked)
//                 break; // get out of the loop
//             }

//         }

//     }
// }

class Main {
    public static void main(String[] args) {
        String word = "swiss";
        int[] freq = new int[26];

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            freq[index] += 1;

        }

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (freq[index] == 1) {
                System.out.println(c);
                break;
            }
        }
    }
}