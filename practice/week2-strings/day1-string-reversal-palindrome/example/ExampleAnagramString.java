class ExampleAnagramString {
    public static void main(String[] args) {
        String s1 = "silent";
        String s2 = "harshi";

        if (s1.length() != s2.length()) {
            System.out.println("Not a anagram");
        } else {
            int[] freq1 = new int[26];
            int[] freq2 = new int[26];

            for (int i = 0; i < s1.length(); i++) {
                freq1[s1.charAt(i) - 'a']++;
            }
            for (int i = 0; i < s2.length(); i++) {
                freq2[s2.charAt(i) - 'a']++;
            }
            boolean isAnagram = true;
            for (int i = 0; i < 26; i++) {
                if (freq1[i] != freq2[i]) {
                    isAnagram = false;
                    break;
                }
            }
            System.out.println(isAnagram);
        }
    }
}