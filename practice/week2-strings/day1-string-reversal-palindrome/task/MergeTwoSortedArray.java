// merge {1,3,5} and {2,4,6} into one sorted array {1,2,3,4,5,6}.

class Main {
    public static void main(String[] args) {
        int[] a = { 1, 3, 5 };
        int[] b = { 2, 4, 6 };
        int[] merged = new int[a.length + b.length];

        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                merged[k] = a[i];
                i++;

            } else {
                merged[k] = b[j];
                j++;
            }
            k++;
        }

        while (i < a.length) {
            merged[k] = a[i];
            i++;
            k++;
        }
        while (j < b.length) {
            merged[k] = b[j];
            j++;
            k++;
        }

        for (int num : merged) {
            System.out.print(num + " ");
        }

    }
}