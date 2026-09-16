// Task 36 (the important edge case): Using the same binary search logic, search for 100 — a value not present in the array.
// Trace by hand what happens to left and right as the loop progresses, and confirm your code correctly reports "not found"
// via the -1 sentinel, without crashing or looping forever.
// array = {2, 5, 8, 12, 16, 23, 38, 45, 56, 72},
// target=100
// Trace: start=0,end=9,mid=9/2=4,arr[mid] is arr[4] is 16  condition: start<=end
// 16 < 100, start = mid+1=5, end=9, mid=14/2=7 = arr[7] is 45
// 45 < 100, start=mid+1=8, end=9, mid=17/2=8 = arr[8] is 56
// 56 < 100, start=mid+1=9, end=9, mid=9 = arr[9] is 72
// 72 < 100, start= mid+1-10, end=9 condition start<=end i.e.: 10<=9 meaning the target is not present return -1

class Task36_BinarySearchMissing {
    public static void main(String[] args) {
        int[] arr = { 2, 5, 8, 12, 16, 23, 38, 45, 56, 72 };
        int target = 100;
        int start = 0;
        int end = arr.length - 1;
        int foundIndex = -1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) {
                foundIndex = mid;
                System.out.println("Found the target at index: " + foundIndex);
                break;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        if (foundIndex == -1) {
            System.out.println("Targtet number does not exist in the array");
        }

    }
}