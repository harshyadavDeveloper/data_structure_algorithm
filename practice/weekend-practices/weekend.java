class Main {
    public static void main(String[] args) {
        // bubbleSort();
        // descSelectionSort();
        // newBinarySearch();
        bubbleSortCount();
        // mergeSortArray();
        // checkArray();
        // insertionSort();
        // rotatedBinarySearch();
        // findMedian();

    }

    // Task 1: Given {7, 2, 9, 4, 1, 8}, sort it using any one sort of your choice,
    // then binary search for 9 and
    // print its index.
    public static void bubbleSort() {
        int[] arr = { 7, 2, 9, 4, 1, 8 };
        int n = arr.length;

        for (int pass = 0; pass < n - 1; pass++) {
            for (int j = 0; j < n - 1 - pass; j++) {
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
        int tarInd = myBinarySearch(arr, 9);
        System.out.print("Found At: " + tarInd);
    }

    public static int myBinarySearch(int[] arr, int target) {
        int n = arr.length;
        int start = 0;
        int end = n - 1;
        int foundIndex = -1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                System.out.print("Found Index at: " + mid);
                foundIndex = mid;
                return foundIndex;
            } else if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            }

        }

        if (foundIndex == -1) {
            System.out.println("Index Not Present");
        }
        return foundIndex;
    }

    // Task: 2 Implement selection sort, but modify it to find the maximum each pass
    // instead of the minimum,
    // building the sorted array in descending order.
    public static void descSelectionSort() {
        int[] arr = { 7, 2, 9, 4, 1, 8 };
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int swapIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[swapIndex]) {
                    swapIndex = j;
                }

            }
            int temp = arr[i];
            arr[i] = arr[swapIndex];
            arr[swapIndex] = temp;
        }

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    // task 3: Given a sorted array {1, 3, 5, 7, 9, 11, 13}, use binary search to
    // find the
    // index where 6 would be inserted
    // if it were added to keep the array sorted (it's not present, so return the
    // position just before the next
    // larger element).
    public static void newBinarySearch() {
        int[] arr = { 1, 3, 5, 7, 9, 11, 13 };
        int insert = 6;
        int target = insert;
        int n = arr.length;
        int start = 0;
        int end = n - 1;
        boolean foundIndex = false;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                System.out.println("Insert Index At: " + mid);
                foundIndex = true;
                break;
            } else if (target < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }

        if (!foundIndex) {
            System.out.println("Insert index at: " + start);
        }
    }

    // Task 4: Given {5, 3, 8, 3, 9, 3, 2}, count how many comparisons bubble sort
    // makes in total to fully sort it
    // (add a comparison counter, incrementing once per if check, regardless of
    // whether a swap happens).

    public static void bubbleSortCount() {
        int[] arr = { 5, 3, 8, 3, 9, 3, 2 };
        int count = 0;
        int n = arr.length;

        for (int pass = 0; pass < n - 1; pass++) {
            for (int i = 0; i < n - 1 - pass; i++) {
                count++;
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }

            }

        }

        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println("Count: " + count);
    }

    // Task 5: Merge-sort style thinking (no new syntax, just logic): given two
    // already sorted arrays of different
    // lengths, {1,3,5,7,9} and {2,4,6}, merge them (reuse your Week 2 Day 3 merge
    // logic).

    public static void mergeSortArray() {
        int[] arr1 = { 1, 3, 5, 7, 9 };
        int[] arr2 = { 2, 4, 6 };
        int n = arr1.length;
        int m = arr2.length;
        int[] merged = new int[n + m];
        int i = 0, j = 0, k = 0;

        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                merged[k] = arr1[i];
                i++;
            } else {
                merged[k] = arr2[j];
                j++;
            }
            k++;
        }

        while (i < n) { // clean up if some values still remains in arr1 and arr2 gets empty
            merged[k] = arr1[i];
            i++;
            k++;
        }

        while (j < m) { // vice-versa of above
            merged[k] = arr2[j];
            j++;
            k++;
        }

        for (int num : merged) {
            System.out.print(num + " ");
        }
    }

    // task 6: Given an array, determine whether it's already sorted in ascending
    // order, without actually sorting
    // it — just a single pass checking neighbors.
    public static void checkArray() {
        int arr[] = { 1, 2, 3, 4, 7, 6 };
        int n = arr.length;
        boolean isSorted = true;

        for (int i = 0; i < n - 1; i++) { // n-1 because we are comparing i+1. the question i ask myself is what is the
                                          // maximum values i can have so that i+1 does not go out of bound
            if (arr[i] > arr[i + 1]) {
                System.out.println("Array is not sorted");
                isSorted = false;
                break;
            }
        }
        if (isSorted) {
            System.out.println("The array is sorted");
        }
    }

    // task 7: Implement insertion sort but count how many times the while loop's
    // condition is checked in total
    // (not just shifts — every single evaluation of the while condition, true or
    // false).
    public static void insertionSort() {
        int[] arr = { 5, 3, 8, 3, 9, 3, 2 };
        int n = arr.length;
        int count = 0;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            boolean condition = true;
            int j = i - 1;
            while (condition) {
                count++;
                condition = j >= 0 && arr[j] > key;
                if (condition) {
                    arr[j + 1] = arr[j];
                    j--;
                }

            }
            arr[j + 1] = key;

        }
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println("Count: " + count);

    }

    // task 8: Given {4, 5, 6, 7, 0, 1, 2} — a sorted array that's been "rotated" —
    // find the index of 0 using a modified binary search (think about how you'd
    // decide which half is still properly sorted at each step, since the whole
    // array isn't sorted anymore, but one half always still is).
    public static void rotatedBinarySearch() {
        int[] arr = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 0;
        int start = 0;
        int end = arr.length - 1;
        int foundIndex = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                foundIndex = mid;
                System.out.print("found target at index: " + foundIndex);
                break;
            }

            if (arr[start] <= arr[mid]) { // left is sorted
                if (target >= arr[start] && target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }

            } else { // right is sorted
                if (target > arr[mid] && target <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

    }

    // task 9: Given {3, 1, 4, 1, 5, 9, 2, 6}, find the median after sorting (for
    // even-length arrays, average the two middle elements).
    public static void findMedian() {
        int[] arr = { 3, 1, 4, 1, 5, 9, 2, 6 };
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
        int start = 0;
        int end = arr.length;
        if (arr.length % 2 == 0) {

            int mid1 = (start + end) / 2;
            int mid2 = (start + end) / 2 - 1;
            System.out.println("Mid 1 is: " + arr[mid1]);
            System.out.println("Mid 2 is: " + arr[mid2]);
            double median = (arr[mid1] + arr[mid2]) / 2.0;
            System.out.println("Mdeian of a even length arr is: " + median);

        } else {
            int median = (start + end) / 2;
            System.out.println("Median of a odd sized array is: " + arr[median]);
        }
    }

    // task 10: Reflection task, no code: in one paragraph, explain when you would
    // choose bubble sort vs. selection sort vs. insertion sort vs. binary search,
    // if you were told nothing about the data except its size. Base this on what
    // you've actually observed this week, not general knowledge.

    /// first of all binary search this is not a sorting algo it helps me cut half
    /// portion of my data based on some condition. bubble sort can be used when i
    /// need to constantly check neighbouring elements and arrange them in order
    /// if i want to find the smallest element and place it in the sarting of the
    /// array then i would prefer selection sort
    /// if i need a maintain a partly sorted array all the time while sorting itself
    /// then i would prefer insertion sort

}
