// Task 41: Sort {9, 3, 7, 1, 6, 2} ascending using selection sort, exactly as derived above. Print the array after each pass
// (same style as Task 38).

class Task41_SelectionSort {
    public static void main(String[] args) {
        int[] arr = { 9, 3, 7, 1, 6, 2 };
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;

            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();

        }

    }
}