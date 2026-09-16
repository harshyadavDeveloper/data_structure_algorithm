class BubbleSort {
    public static void main(String[] args) {
        int[] arr = { 5, 2, 8, 1 };
        int n = arr.length;

        for (int pass = 0; pass < n - 1; pass++) {
            for (int i = 0; i < n - 1 - pass; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }

        for (int num : arr) {
            System.out.println(num);
        }
    }
}