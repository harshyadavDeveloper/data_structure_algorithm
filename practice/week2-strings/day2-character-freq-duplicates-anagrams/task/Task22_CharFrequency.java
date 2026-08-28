// Count and print the frequency of each character in "mississippi" (only print letters that actually appear,
//  alphabetical order, using the freq[26] approach).

class Main {
    public static void main(String[] args) {
        String word = "mississippi";
        int[] freq = new int[26]; // to store the frequency for all the possible letters
        for (int i = 0; i < word.length(); i++) { // scan thru all the char one by one
            char c = word.charAt(i); // grab the current char
            int index = c - 'a'; // obtain the index from the current char
            freq[index] = freq[index] + 1; // updated the freq
        }

        for (int i = 0; i < 26; i++) { // to show alphabetical wise
            if (freq[i] > 0) { // if count is 0 then the alphabet did not appear so skip
                char letter = (char) (i + 'a'); // obtain the letter by the current index
                System.out.println(letter + " " + freq[i]); // print

            }
        }
    }
}