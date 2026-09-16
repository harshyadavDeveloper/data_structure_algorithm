class SelectionSort {
    public static void main(String[] args) {
        int[] arr = { 5, 2, 8, 1 };
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdex]) {
                    minIdex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIdex];
            arr[minIdex] = temp;
        }

        for (int num : arr) {
            System.out.print(num + " ");

        }
    }
}