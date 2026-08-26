// Given an array of n elements (test with {5, 10, 15, 20, 25}), for each element, print it 5 times in a row (a nested loop — 
// outer runs once per array element, inner always runs exactly 5 times, never depending on n). Example partial output for 
// element 5: 5 5 5 5 5. (Maps to Q2 — pay attention to whether the inner loop's bound is tied to n or fixed.)

class Main {
    public static void main(String[] args) {
        int[] arr = {5, 10, 15, 20, 25};
        for(int i=0;i<arr.length;i++){
            for(int j=1;j<=5;j++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
    // here the TC is also 0(n) because the outer loop goes till n and innter loop is fixed 5 that means it becomes O(5xn)
    // and constants are ignored because our big O is only interested in how does the time increases when the input n increases
}