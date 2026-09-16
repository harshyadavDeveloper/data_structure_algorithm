// Task 37: Add a comparison counter to your Task 35 binary search (same idea as Task 34), then search for the same target value
// using both linear and binary search on the same sorted 10-element array, and print both comparison counts side by side. Confirm
// binary search takes meaningfully fewer steps.

class Task37_StepComparison {
    public static void main(String[] args) {
        linearSearch();
        binarySearch();

    }

    public static void binarySearch() {
        int[] arr = { 2, 5, 8, 12, 16, 23, 38, 45, 56, 72 };
        int target = 56;
        int left = 0;
        int right = arr.length - 1;
        int foundIndex = -1;
        int count = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            count++;
            if (arr[mid] == target) {
                foundIndex = mid;
                System.out.println("Found number at index: " + foundIndex);
                System.out.println("Total count: " + count);
                break;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else if (arr[mid] > target) { // not required this condition simply put it in else
                right = mid - 1;
            }
        }

        if (foundIndex == -1) {
            System.out.println("Provided target is not present");
        }

    }

    public static void linearSearch() {
        int[] arr = { 2, 5, 8, 12, 16, 23, 38, 45, 56, 72 };
        int target = 56;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            count++;
            if (arr[i] == target) {
                System.out.println("Found target at index: " + i);
                System.out.println("Total counts: " + count);
                break;

            }
        }
    }
}