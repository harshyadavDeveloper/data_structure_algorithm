// Build a HashMap<String, Integer> representing file sizes in a folder — keys like "readme.txt", "main.java", "data.csv" 
// mapped to sizes in KB (make up 5-6 entries). Then check whether "main.java" exists in the map and print its size if so. 
// (Maps to Q4.)

import java.util.HashMap;

class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> files = new HashMap<>();
        files.put("readme.txt", 12);
        files.put("main.java", 25);
        files.put("data.csv", 150);
        files.put("config.json", 8);
        files.put("index.html", 32);
        files.put("styles.css", 18);

        if (files.containsKey("main.java")) {
            System.out.println(files.get("main.java"));
        }

    }
}