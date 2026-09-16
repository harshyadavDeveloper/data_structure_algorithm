// Task 34: On {4, 12, 7, 19, 3, 25, 8, 16, 1, 30} (unsorted — deliberately, since linear search doesn't care), search for
//  19 using linear search, and count how many comparisons it took (add a counter that increments each time you check
//  arr[i] == target).

class Task34_LinearSearchCount {
    public static void main(String[] args) {
        int[] arr = { 4, 12, 7, 19, 3, 25, 8, 16, 1, 30 };
        int target = 19;
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