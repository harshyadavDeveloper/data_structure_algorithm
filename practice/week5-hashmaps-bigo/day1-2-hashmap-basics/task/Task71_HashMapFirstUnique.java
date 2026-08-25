// Task 71: Rebuild your Week 2 first-non-repeating-character task ("swiss" → 'w') using a HashMap<Character, Integer> for 
// counting, then a second pass over the original string (same two-pass reasoning as before — the hash map alone doesn't preserve 
// original order, same issue as your old freq[26] array).

import java.util.HashMap;

class Main {
    public static void main(String[] args) {
        String word = "swiss";
        HashMap<Character, Integer> seen = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            seen.put(c, seen.getOrDefault(c, 0) + 1);
        }
        System.out.println(seen);

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (seen.get(c) == 1) {
                System.out.println("Firs non repeating element is: " + c);
                break;
            }
        }

    }
}