// Rotate {1, 2, 3, 4, 5} left by 2 (expected: {3, 4, 5, 1, 2}) — this is a variant, not identical
// to Task 26. Before coding: think about how the index formula changes for rotating left instead of
// right. (Hint: think about it as "rotating right by some equivalent amount" — is there a relationship
// between rotating left by k and rotating right by some other value, given the array's length? Or derive
// a fresh formula directly for left rotation — either path is fine, whichever makes more sense to you.)

class Main {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int k = 2;
        int n = arr.length;
        int[] rotated = new int[n];

        for (int i = 0; i < n; i++) {
            int newIndex = (i - k + n) % n;
            rotated[newIndex] = arr[i];
        }

        for (int i = 0; i < n; i++) {
            System.out.print(rotated[i] + " ");
        }
    }
}