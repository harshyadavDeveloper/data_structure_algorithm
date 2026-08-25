import java.util.HashMap;

class Main {
    public static void main(String[] args) {
        // HashMap<String, Integer> map = new HashMap<>();

        // map.put("Apples", 3);
        // map.put("Bananas", 5);
        // map.put("Guvavas", 2);
        // map.put("oranges", 6);
        // map.put("Peaches", 4);
        // map.put("Bananas", 2); // this replaces the old values

        // int val = map.get("Bananas"); // gets the value stored against it
        // boolean isExists = map.containsKey("Tomatoes"); // tells true or false
        // System.out.println("Bananas are: " + val);
        // System.out.println("Does tomatoes exists: " + isExists);
        // System.out.println(map);

        // for (String fruits : map.keySet()) {
        // System.out.println(fruits + map.get(fruits));
        // }
        frequency();
    }

    public static void frequency() {
        String word = "mississippi";
        HashMap<Character, Integer> freq = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            // if (freq.containsKey(c)) {
            // freq.put(c, freq.get(c) + 1);
            // } else {
            // freq.put(c, 1);
            // }
            freq.put(c, freq.getOrDefault(c, 0) + 1); // cleaner and shorter method to do the same
        }
        System.out.println(freq);
    }
}