// given "aabbccdd", produce "abcd" — each character kept only once, first appearance wins.

class ExampleRemoveDuplicateString {
    // public static void main(String[] args) {
    // String word = "aabbccdd";
    // boolean[] seen = new boolean[26];
    // String result = "";

    // for (int i = 0; i < word.length(); i++) {
    // char c = word.charAt(i);
    // int index = c - 'a';
    // if(!seen[index]){
    // result = result + c;
    // seen[index] = true;
    // }
    // }
    // System.out.println(result);
    // }

    // FOR PRACTICE ONLY NOTHING NEW FROM ABOVE
    public static void main(String[] args) {
        String word = "aaabbbdddkkkk";
        boolean[] seen = new boolean[26];
        String result = "";

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (!seen[index]) {
                result = result + c;
                seen[index] = true;
            }
        }
        System.out.println(result);
    }
}