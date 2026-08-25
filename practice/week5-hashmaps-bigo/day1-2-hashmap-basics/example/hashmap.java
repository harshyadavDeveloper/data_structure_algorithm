import java.util.HashMap;

class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("Apples", 3);
        map.put("Bananas", 5);
        map.put("Guvavas", 2);
        map.put("oranges", 6);
        map.put("Peaches", 4);
        map.put("Bananas", 2); // this replaces the old values

        int val = map.get("Bananas"); // gets the value stored against it
        boolean isExists = map.containsKey("Tomatoes"); // tells true or false
        System.out.println("Bananas are: " + val);
        System.out.println("Does tomatoes exists: " + isExists);
        System.out.println(map);

        for (String fruits : map.keySet()) {
            System.out.println(fruits + map.get(fruits));
        }
    }
}