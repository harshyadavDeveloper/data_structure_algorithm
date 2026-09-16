class ExampleCharCount {
    // public static void main(String[] args){
    // String word = "harsh";
    // int[] freq = new int[26]; // create a array with exactly 26 slots
    // representing every character

    // for(int i=0;i<word.length();i++){ // loop thru every char one at a time
    // char c = word.charAt(i); // grab the current char
    // int index = c - 'a'; // get the index of the current char
    // freq[index] = freq[index] +1; // go to the exact slot in array and add +1 to
    // whatever is there
    // }

    // for(int i = 0;i<26;i++){
    // if(freq[i] > 0){
    // char letter = (char) (i+'a');
    // System.out.println(letter + " " + freq[i]);
    // }
    // }
    // }

    // THIS FOR PRACTICE NOTHING ELSE

    public static void main(String[] args) {
        String word = "hello";
        int[] freq = new int[26];

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            freq[index] = freq[index] + 1;
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                char letter = (char) +(i + 'a');
                System.out.println(letter + " " + freq[i]);

            }
        }
    }
}