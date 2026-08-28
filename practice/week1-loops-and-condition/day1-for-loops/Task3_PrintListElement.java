// Task 3: Given int[] arr = {10, 20, 30, 40, 50};, print every element from first to last, one per line, using a for loop and 
// indexing (arr[i]) — not a for-each loop, since we're building index intuition.

class Main {
    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, 40, 50 };

        for (int i = 0; i < arr.length - 1; i++) {
            System.out.println(arr[i]);
        }
    }
}