// Task 45: Add a counter tracking the total number of shifts (increment once per arr[j+1] = arr[j] execution
// — i.e., inside the while loop). Run it on the same array and note the total. Then think about and write a
// one-line comment: on an array that's already fully sorted (like {1,2,3,4,5,6}), what would this shift count be, 
// and why? (You don't need to test this one — reason about it.)

class Main {
    public static void main(String[] args) {
        int[] arr = { 9, 3, 7, 1, 6, 2 }; // {1,2,3,4,5,6} for a sorted arr like shwon i think no shift will because the
                                          // condition inside the while loop(2nd condition) will never hit
        int n = arr.length;
        int count = 0;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                count++;
                j--;

            }
            arr[j + 1] = key;

        }
        System.out.println("Count: " + count);

    }
}