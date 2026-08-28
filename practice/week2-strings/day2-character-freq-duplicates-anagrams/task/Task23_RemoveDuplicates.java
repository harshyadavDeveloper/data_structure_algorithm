// Remove duplicate characters from "programming", keeping only the first occurrence of each letter (expected result: "progamin").

class Main {
    public static void main(String[] args) {
        String word = "programming";
        boolean[] seen = new boolean[26]; // initializes 26 slots with false
        String result = ""; // to store the result

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (!seen[index]) {
                result = result + c; // updated the result with the not seen char
                seen[index] = true; // skip its second and further appreance
            }
        }
        System.out.println(result);
    }
}