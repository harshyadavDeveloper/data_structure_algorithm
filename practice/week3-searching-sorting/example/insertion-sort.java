class InsertionSort {
    public static void main(String[] args) {
        insertionSort();
        int[] arr = { 5, 2, 8, 1 };
        int n = arr.length;
        int count = 0;

        for (int i = 1; i < n; i++) { // start at index 1 — index 0 is trivially "sorted" alone
            int key = arr[i]; // the value we're currently trying to insert
            // System.out.println("Starting Key is: " + key);
            int j = i - 1; // start comparing from the immediately-preceding, already-sorted element

            while (j >= 0 && arr[j] > key) { // keep shifting right as long as we're still bigger than key
                arr[j + 1] = arr[j]; // shift this element one spot to the right
                j--; // move one step further left, check the next one

            }
            // System.out.println("Key: " + key);

            arr[j + 1] = key; // found the correct spot — place key there
            count++;

        }
        // System.out.println(count);

    }

    public static void insertionSort() {
        int[] arr = { 5, 2, 8, 1 };
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;

        }
        for (int num : arr) {
            System.out.print(num + " ");

        }
        System.out.println();

    }
}