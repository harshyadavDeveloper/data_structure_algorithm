// Task 55: Implement recursive binary search exactly as derived above. Test on {2,5,8,12,16,23,38,45,56,72} searching for 45. 
// Hand-trace the call chain (like the fibonacci(5) tree above, but simpler) before running.

class Task55_RecursiveBinarySearch {
    public static void main(String[] args) {
        int[] arr = { 1, 5, 7, 9, 10, 33, 76, 89, 91 };
        int start = 0;
        int end = arr.length - 1;
        int target = 33;
        recursiveBinarySearch(arr, target, start, end);

    }

    // call(start=0,end=8): mid=4, arr[4]=10,10<33,call(5,6)
    // call(start=5, end=8): mid=6, arr[6]=76, 76>33,call(5,5)
    // call(start=5,end=5): mid=5, arr[5]=33, return 5

    public static int recursiveBinarySearch(int[] arr, int target, int start, int end) {
        if (start > end) {
            System.out.println("Target not present in the array");
            return -1;
        }

        int mid = start + (end - start) / 2;
        if (target == arr[mid]) {
            System.out.println("Found target at index: " + mid);
            return mid;
        } else if (target < arr[mid]) {
            end = mid - 1;
            return recursiveBinarySearch(arr, target, start, end);

        } else {
            start = mid + 1;
            return recursiveBinarySearch(arr, target, start, end);
        }
    }
}