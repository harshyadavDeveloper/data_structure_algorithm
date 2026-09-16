// Task 46 (the real payoff task): Using the same starting array {9, 3, 7, 1, 6, 2}, you now have pass-by-pass 
// results from all three sorts (bubble, selection, insertion). Write a comment summarizing: which one reached the 
// fully sorted state in the fewest "rounds" for this specific array, and — more importantly — explain in your own 
// words why you now understand that "which sort is best" isn't a single fixed answer, but depends on what the input 
// data looks like (e.g., nearly-sorted data vs. reverse-sorted data might favor different algorithms). This is a 
// conceptual wrap-up, not new code — just genuine reflection tying the week together.

class Task46_ThreeSortComparison {
    public static void main(String[] args) {
        // selecionSort();
        // bubbleSort();
        insertionSort();

    }

    public static void selecionSort() {
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
        }
        for (int num : arr) {
            System.out.print(num + " ");
        }

    }

    public static void bubbleSort() {
        int[] arr = { 9, 3, 7, 1, 6, 2 };
        int n = arr.length;

        for (int pass = 0; pass < n - 1; pass++) {
            for (int j = 0; j < n - pass - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void insertionSort() {
        int[] arr = { 9, 3, 7, 1, 6, 2 };
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    // i think the most in-efficient is selection sort because it compares all the
    // times even if the array is sorted. bubble sort if optimised can stop early so
    // it is better but the best is insertion swap cause it always takes n-1 rounds
    // to sort because first element is always sorted in the array and also
    // insertion sort can do 0 work if the array is already sorted while even the
    // optimsed bubble has to some work inorder to break in between. so it is most
    // optimal for almost sorted array too. we can use optimised bubble sort for
    // reverse sorting cause might can be better then selection
    // Point to note: bubble also take n-1 rounds to sort the array fully

}