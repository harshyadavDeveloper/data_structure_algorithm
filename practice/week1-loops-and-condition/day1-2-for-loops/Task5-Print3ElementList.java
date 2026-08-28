// Task 5 (the trap-tester): Print only the first 3 elements of the array {10, 20, 30, 40, 50} using a for loop. 
// Before coding, answer in your notebook: what should my stop condition be, and why is it not simply i < arr.length?

class Main {
    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, 40, 50 };
        for (int i = 0; i < 3; i++) {
            System.out.println(arr[i]);
        }
    }
}