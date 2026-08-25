// Task 68: Rebuild your Week 2 character frequency counter using HashMap<Character, Integer> on "mississippi" (same word as Task 
// 22) — use getOrDefault. Print each key-value pair.

import java.util.HashMap;

class Main {
    public static void main(String[] args) {
        String word = "mississippi";
        HashMap<Character, Integer> seen = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            // if (seen.containsKey(c)) {
            // seen.put(c, seen.get(c) + 1);

            // } else {
            // seen.put(c, 1);
            // }
            seen.put(c, seen.getOrDefault(c, 0) + 1);

        }
        System.out.println(seen);

    }
}