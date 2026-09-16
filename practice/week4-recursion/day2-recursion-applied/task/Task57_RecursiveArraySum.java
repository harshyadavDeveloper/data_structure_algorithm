// Task 57: Implement recursive array sum — given {4, 8, 15, 16, 23}, write arraySum(arr, index) that returns the sum of all 
// elements from index to the end of the array, using recursion (base case: what should happen when index goes past the last 
// valid index?). Derive this yourself the same way as the others — think about how "sum of everything from index to the end" 
// relates to "sum of everything from index+1 to the end."

class Task57_RecursiveArraySum {
    public static void main(String[] args) {
        int[] arr = { 1, 5, 3, 55, 77, 22, 21, 32, 47 };
        int index = 4;
        int sum = arraySum(arr, index);
        System.out.print(sum);

    }

    public static int arraySum(int[] arr, int index) {
        if (index >= arr.length) {
            return 0;
        }
        int result = 0;

        result = arr[index] + arraySum(arr, index + 1);
        // System.out.println(result);
        return result;
    }
}