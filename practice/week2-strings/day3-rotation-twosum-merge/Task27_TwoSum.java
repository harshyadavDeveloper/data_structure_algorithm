// Given sorted array {1, 4, 6, 8, 12, 15}, find a pair that sums to 14.

class Main {
    public static void main(String[] args) {
        int[] arr = { 1, 4, 6, 8, 12, 15 };
        int target = 14;
        int start = 0;
        int end = arr.length - 1;
        boolean found = false;

        while (start < end) {
            int sum = arr[start] + arr[end];

            if (sum == target) {
                System.out.println("Found Pair " + arr[start] + " " + arr[end]);
                found = true;
                break;
            } else if (sum > target) {
                end--;
            } else {
                start++;
            }
        }
        if (!found) {
            System.out.println("Cound not find any pair");
        }

    }
}
