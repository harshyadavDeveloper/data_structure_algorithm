// Task 35: On the sorted array {2, 5, 8, 12, 16, 23, 38, 45, 56, 72}, implement binary search to find 56. Hand-trace it fully
// in comments before running (show left, right, mid for each round, the way I did above), then confirm your code matches your
// trace.

// left=0,right=9(arr.length-1), mid=9/2=4
// arr[4] = 16 < 56, left=mid+1(5),right=9, mid=14/2=7
// arr[7] = 45 < 56, left=mid+1(6), right=9,mid=15/2=7 
// arr[7] = 45 < 56, left=mid+1(7), right=9, mid= 16/2=8
// arr[8] = 56 == 56(match) return index 8

class Task35_BinarySearch {
    public static void main(String[] args) {
        int[] arr = { 2, 5, 8, 12, 16, 23, 38, 45, 56, 72 };
        int target = 56;
        int left = 0;
        int right = arr.length - 1;
        int foundIndex = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                foundIndex = mid;
                System.out.println("Found number at index: " + foundIndex);
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
}