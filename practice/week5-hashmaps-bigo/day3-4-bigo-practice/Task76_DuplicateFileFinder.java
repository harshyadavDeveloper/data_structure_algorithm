// Given an array of filenames (some repeated, simulating duplicate uploads): {"photo.jpg", "notes.txt", "photo.jpg", "report.pdf", 
// "notes.txt", "notes.txt"}, use a HashMap<String, Integer> to count how many times each filename appears, in a single pass (one 
// loop, getOrDefault lookup inside). Print any filename that appears more than once, along with its count. (Maps to Q5 — one 
// loop, O(1) work per iteration.)

import java.util.HashMap;

class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> seen = new HashMap<>();
        String[] filenames = { "photo.jpg", "notes.txt", "photo.jpg", "report.pdf", "notes.txt", "notes.txt" };

        for (int i = 0; i < filenames.length; i++) {
            String curr = filenames[i];
            seen.put(curr, seen.getOrDefault(curr, 0) + 1);
            // if (seen.get(curr) > 1) {
            //     System.out.println(curr + ": " + seen.get(curr));
            // }
        }
        for(String curr: seen.keySet()){
        if(seen.get(curr) > 1){
        System.out.println(curr + ": "+seen.get(curr));
        }

        }
        // here the TC is O(n) because putting the values in hashmap is O(n) and getting
        // the value O(1).

    }
}