// Task 43 (the comparison task): Using the same starting array {9, 3, 7, 1, 6, 2} you already sorted with both bubble sort
// (Task 38) and now selection sort (Task 41), write a short comment comparing their pass-by-pass intermediate states side by
// side. Are the arrays identical after each corresponding pass, or do they diverge? What does that tell you about whether
// "same final answer" means "same process" in sorting algorithms?

class Task43_BubbleVsSelectionTrace {
    public static void main(String[] args) {
        bubbleSort();
    }

    public static void bubbleSort() {
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

        }
        /// Trace: pass=0;0<5;pass++
        /// i=0;0<n-1-pass(4);i++
        /// if(arr[0] > arr[1]): 9>3 after: 3,9,7,1,6,2
        /// if(arr[1]>arr[2]): 9>7 after: 3,7,9,1,6,2
        /// if(arr[2]>arr[3]): 9>1 after: 3,7,1,9,6,2
        /// if(arr[3]>arr[4]): 9>6 after: 3,7,1,6,9,2
        /// if(arr[4]>arr[5]): 9>2 after: 3,7,1,6,2,9 --> 1 iteration
        /// pass=1;1<5;pass++
        /// if(arr[0]> arr[1]): 3>7: false-->no swap
        /// if(arr[1]> arr[2]): 7>1 after: 3,1,7,6,2,9
        /// if(arr[2]> arr[3]): 7>6 after: 3,1,6,7,2,9
    }

    public static void selectionSort() {
        int[] arr = { 9, 3, 7, 1, 6, 2 };
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int swapedIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[swapedIndex]) {
                    swapedIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[swapedIndex];
            arr[swapedIndex] = temp;
        }

        /// trace:
    }
}