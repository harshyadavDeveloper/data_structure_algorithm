class Main {
    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 2, 2, 3, 4, 4 };
        // int count = removeDuplicatesSortedInPlace(arr);
        int[] result = removeDuplicatesSorted(arr);
        for (int num : result) {
            System.out.print(num + " ");
        }

        // for (int i = 0; i < count; i++) {
        // System.out.print(arr[i] + " ");
        // }

    }

    public static int removeDuplicatesSortedInPlace(int[] arr) {
        int uniqPos = 1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != arr[uniqPos - 1]) {
                arr[uniqPos] = arr[i];
                uniqPos++;
            }
        }
        return uniqPos; // tells u how many unique elements are there in the array
    }

    public static int[] removeDuplicatesSorted(int[] arr) { // Since the input is sorted, duplicates are next to each
                                                            // other.
        if (arr.length == 0) {
            return new int[0];
        }

        int uniqCount = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                uniqCount++;
            }
        }

        int[] result = new int[uniqCount];

        result[0] = arr[0];
        int index = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                result[index] = arr[i];
                index++;
            }
        }

        return result;

    }

}
