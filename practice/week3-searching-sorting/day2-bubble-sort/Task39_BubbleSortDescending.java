// Task 39: Sort the same array in descending order instead. Think about which single comparison operator needs to flip, and why 
// — everything else about the structure should stay identical.

class Task39_BubbleSortDescending {
    public static void main(String[] args) {
        int[] arr = { 9, 3, 7, 1, 6, 2 };
        int n = arr.length;

        for (int pass = 0; pass < n - 1; pass++) {
            for (int i = 0; i < n - 1 - pass; i++) {
                if (arr[i] < arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
            // 9 7 3 6 2 1
            // 9 7 6 3 2 1
            // 9 7 6 3 2 1
            // 9 7 6 3 2 1
            // 9 7 6 3 2 1
            // 9 7 6 3 2 1
        }
    }
}