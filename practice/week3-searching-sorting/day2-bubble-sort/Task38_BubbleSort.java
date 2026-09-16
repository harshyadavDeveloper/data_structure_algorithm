// Task 38: Sort {9, 3, 7, 1, 6, 2} ascending using bubble sort, exactly as derived above. Print the array after each full pass
// (not just the final result) so you can see the "settling" happen visually, matching the hand-trace style.

class Task38_BubbleSort {
    public static void main(String[] args) {
        int[] arr = { 9, 3, 7, 1, 6, 2 };
        int n = arr.length;

        for (int pass = 0; pass < n - 1; pass++) {
            for (int i = 0; i < n - 1 - pass; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
            // 3 7 1 6 2 9
            // 3 1 6 2 7 9
            // 1 3 2 6 7 9
            // 1 2 3 6 7 9
            // 1 2 3 6 7 9
        }
        // for(int num: arr){
        // System.out.println(num);
        // }

    }
}