// Given {4, 8, 15, 16, 23, 42}, print every element once using a single loop. (Maps to Q1.)

class Main {
    public static void main(String[] args) {
        int[] arr = { 4, 8, 15, 16, 23, 42 };
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
        // here the time complexity is O(n) becuase there 1 loop that starts from the
        // beginning 0 and does till the very end of the list as the size increases the
        // work will increase
    }
}