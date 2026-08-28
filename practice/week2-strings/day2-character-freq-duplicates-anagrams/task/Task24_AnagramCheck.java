// Check if "listen" and "silent" are anagrams (should be true), and separately check "hello" and "world" (should be false).

class Main {
    public static void main(String[] args) {
        String word1 = "hello";
        String word2 = "world";

        String word3 = "silent";
        String word4 = "listen";
        boolean check1 = isAnagram(word1, word2);
        boolean check2 = isAnagram(word3, word4);
        System.out.println(check1);
        System.out.println(check2);

    }

    public static boolean isAnagram(String word1, String word2) {

        if (word1.length() != word2.length()) {
            System.out.println("Not a anagram");
            return false;
        } else {
            int[] freq1 = new int[26];
            int[] freq2 = new int[26];

            for (int i = 0; i < word1.length(); i++) {
                freq1[word1.charAt(i) - 'a']++;
            }
            for (int i = 0; i < word2.length(); i++) {
                freq2[word2.charAt(i) - 'a']++;
            }

            for (int i = 0; i < 26; i++) {
                if (freq1[i] != freq2[i]) {
                    return false;
                }
            }

        }
        return true;
    }

}