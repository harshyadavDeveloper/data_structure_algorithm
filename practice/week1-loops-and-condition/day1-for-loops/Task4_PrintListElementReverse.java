// Task 4: Print the same array from last to first. from task 3

class Main {
    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, 40, 50 };

        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }
}