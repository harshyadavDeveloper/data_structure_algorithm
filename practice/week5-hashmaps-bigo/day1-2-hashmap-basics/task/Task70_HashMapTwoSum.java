// Task 70: Implement the hash-map-based two-sum exactly as derived above, test on {3, 2, 4} looking for target 6.

import java.util.HashMap;

class Main {
    public static void main(String[] args) {
        int[] arr = { 3, 2, 4 };
        int target = 6;
        HashMap<Integer, Integer> values = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int compliment = target - arr[i];
            if (values.containsKey(compliment)) {
                System.out.println(compliment + " + " + arr[i] + " = " + target);
            }

            values.put(arr[i], i);
        }

    }
}