// Task 14: Given {4, 15, 7, 22, 9, 3}, find and print the sum of all elements.

class Main {
    public static void main(String[] args) {
        int[] arr = { 4, 15, 7, 22, 9, 3 };
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        System.out.println(sum);

    }
}