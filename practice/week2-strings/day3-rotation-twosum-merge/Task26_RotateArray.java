// Rotate {10, 20, 30, 40, 50} right by 3 (expected: {30, 40, 50, 10, 20}).

class Main {
    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, 40, 50 };
        int length = arr.length;
        int k = 3;
        int[] rotated = new int[length];

        for (int i = 0; i < length; i++) {
            int newIndex = (i + k) % length;
            rotated[newIndex] = arr[i];
        }

        for (int num : rotated) {
            System.out.print(num + " ");
        }
    }
}