class RotateArrayByK {
    public static void main(String[] args) {
        // int[] arr = {1, 2, 3, 4, 5};
        // int k = 2;
        // int n = arr.length;
        // int[] rotated = new int[n];

        // for(int i = 0;i<n;i++){
        // int newIndex = (i+k)%n;
        // rotated[newIndex] = arr[i];
        // }
        // for(int num: rotated){
        // System.out.print(num + " ");
        // }

        int[] arr = { 1, 2, 3, 4, 5 };
        int k = 1;
        int n = arr.length;
        int[] rotated = new int[n];

        for (int i = 0; i < arr.length; i++) {
            int newIndex = (i + k) % n;
            rotated[newIndex] = arr[i];
        }

        for (int num : rotated) {
            System.out.print(num + " ");
        }
    }
}