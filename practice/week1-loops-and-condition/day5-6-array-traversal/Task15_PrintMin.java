// Task 15: Given the same array, find and print the minimum value. Before coding — in words, why should min start at arr[0] 
// rather than some large number like 9999? (Think about what would happen if every number in the array happened to be larger 
// than whatever guess you hardcoded.)

class Main {
    public static void main(String[] args) {
        int[] arr = { 4, 15, 7, 22, 9, 3 };
        int min = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println(min);

    }
}