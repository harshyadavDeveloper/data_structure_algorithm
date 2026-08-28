// Task 17: Given {5, 3, 8, 1, 9}, search for the value 100 (which does not exist in the array) using the linear search pattern 
// above. Trace it fully by hand first — predict what gets printed — before running it, and confirm your -1/"not found" logic 
// actually works correctly for a genuine miss, not just a hit.

class Main {
    public static void main(String[] args) {
        int[] arr = { 5, 3, 8, 1, 9, 100 };
        int target = 100;
        int targetIndex = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                targetIndex = i;

            }
        }

        System.out.println(targetIndex);

    }
}