// Task 44: Sort {9, 3, 7, 1, 6, 2} ascending using insertion sort, printing the array after each outer-loop 
// iteration (each "card inserted"), same visualization style as before.

class Task44_InsertionSort {
    public static void main(String[] args) {
        int[] arr = { 9, 3, 7, 1, 6, 2 };
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i]; // 3
            int j = i - 1; // 0th index
                           // 9 3
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j]; // arr[j+1] is 3 arr[j] is 9
                j--;

            }

            arr[j + 1] = key; // arr[j+1] is 9 and key is 3 before after arr[j+1] becomes 3
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

    }
}