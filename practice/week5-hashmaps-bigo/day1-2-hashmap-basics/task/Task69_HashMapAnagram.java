// Task 69: Rebuild your Week 2 anagram check ("listen"/"silent") using two HashMap<Character, Integer> frequency maps instead of 
// int[26] arrays — compare the maps for equality (think about how you'd check two maps are identical, since you can't just 
// compare them with ==; consider using .equals(), which HashMap supports directly, and briefly reason about why that works here).

import java.util.HashMap;

class Main {
    public static void main(String[] args) {
        String word1 = "listen";
        String word2 = "silenta";

        HashMap<Character, Integer> seen1 = new HashMap<>();
        HashMap<Character, Integer> seen2 = new HashMap<>();

        for (int i = 0; i < word1.length(); i++) {
            char c = word1.charAt(i);
            seen1.put(c, seen1.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < word2.length(); i++) {
            char c = word2.charAt(i);
            seen2.put(c, seen2.getOrDefault(c, 0) + 1);
        }

        if(seen1.equals(seen2)){ // basically == asks are a and b the same object in the memory but .equals asks does a and b has the same value and in hashmap we really care about the value
            System.out.println("It is a anagram");
        }else{
            System.out.println("It is not a anagram");
        }

    }
}