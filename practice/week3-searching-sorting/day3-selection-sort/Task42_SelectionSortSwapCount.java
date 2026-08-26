// Task 42: Add a swap counter to Task 41's logic — increment it only when an actual swap happens (think carefully: should this be
// inside the inner loop, or right where the swap itself occurs?). Run it and print the total swap count. Compare this number
// mentally to how many swaps bubble sort would have needed on the same array (you don't need to actually re-run bubble sort
// — just reason about which one likely does fewer swaps, based on what you saw in the hand-trace above).

class Main {
    public static void main(String[] args) {
        int[] arr = { 9, 3, 7, 1, 6, 2 };
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            int swapIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[swapIndex]) {
                    swapIndex = j;

                }

            }
            if (swapIndex != i) {
                int temp = arr[i];
                arr[i] = arr[swapIndex];
                arr[swapIndex] = temp;
                count++;
            }
            // in this the count comes as 5 and i think we should increment the count where
            // the swap happens and if we increment count inside the inner loop then the
            // output comes as 15 & 7 if we put it inside the if condition which is not
            // correct that is the number of times minIndex
            // was changes and not the number of times swap has happened.

        }
        System.out.println(count);

    }
}