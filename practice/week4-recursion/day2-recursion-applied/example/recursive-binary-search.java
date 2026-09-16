class RecursiveBinarySearch {
    public static void main(String[] args) {
        int[] arr = { 1, 4, 5, 8, 9, 11, 15 };
        int start = 0;
        int end = arr.length - 1;
        int target = 11;
        recursiveBinarySearch(arr, target, start, end);

    }

    public static int recursiveBinarySearch(int[] nums, int target, int start, int end) {
        if (start > end) {
            System.out.println("Targtet not present in the array");
            return -1;
        }

        int mid = start + (end - start) / 2;
        if (target == nums[mid]) {
            System.out.println("Found target at index: " + mid);
            return mid;

        }

        if (target < nums[mid]) {
            end = mid - 1;
            return recursiveBinarySearch(nums, target, start, end);
        } else {
            start = mid + 1;
            return recursiveBinarySearch(nums, target, start, end);
        }

    }
}