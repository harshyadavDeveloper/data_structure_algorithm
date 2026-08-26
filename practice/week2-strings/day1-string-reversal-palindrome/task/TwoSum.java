// given sorted array {2, 7, 11, 15}, find two numbers that add up to 9

class Main {
    public static void main(String[] args) {
        int[] arr = { 2, 7, 11, 15 };
        int target = 9;
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int sum = arr[start] + arr[end];
            if (target == sum) {
                System.out.println("Found numbers: " + arr[start] + " " + arr[end]);
                break;
            } else if (sum > target) {
                end--; // to decrase the sum
            } else {
                start++; // to increase the sum
            }
        }
    }
}
