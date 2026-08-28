class Main {
    public static void main(String[] args) {
        // char c = 'e';
        // int index = c - 'a'; // return 4
        // System.out.println(index);

        // int x = 4;
        // char z = (char) ('a' + x);
        // System.out.println(z);

        // char ch = 'f';
        // int ind = ch - 'a';
        // System.out.println(ind);

        // char ch1 = 'g'; // convert this to uppercase
        // char uc = (char)(ch1-'a'+'A');
        // System.out.println(uc);

        // frequency-counting
        // char c = 's';
        // int[] freq = new int[26];
        // int index = c-'a';
        // freq[index]++;
        // System.out.println(index);
        // System.out.println(freq[index]);

        // frequency of a character in a string
        // String str = "banana";
        // int[] freq = new int[26];

        // for (int i = 0; i < str.length(); i++) {
        // char c = str.charAt(i);
        // int index = c - 'a';
        // freq[index]++;
        // }
        // for (int i = 0; i < 26; i++) {
        // if (freq[i] != 0) {
        // char ch = (char) (i + 'a');
        // System.out.println(ch + " " + freq[i]);
        // }
        // }

        // remove duplicates
        // String s = "aabbccdd"; // output: abcd
        // boolean[] seen = new boolean[26];
        // String result = "";

        // for (int i = 0; i < s.length(); i++) {
        // char c = s.charAt(i);
        // int index = c - 'a';
        // if (!seen[index]) {
        // result = result + c;
        // seen[index] = true;
        // }
        // }
        // System.out.println(result);

        // check anagram
        String s1 = "listen";
        String s2 = "silent";
        if(s1.length() != s2.length()){
            System.out.println("Not Anagram");
            return;

        }

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for(int i=0; i<s1.length();i++){
            char c = s1.charAt(i);
            int index = c-'a';
            freq1[index]++;

        }

        for(int i=0;i<s2.length();i++){
            char c = s2.charAt(i);
            int index = c-'a';
            freq2[index]++;

        }

        for(int i=0;i<26;i++){
            if(freq1[i] != freq2[i]){
                System.out.print("Not Anagram");
                return;
            }
        }
        System.out.println("s1 and s2 are anagrams");

    }
}