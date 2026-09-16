// Task 18: Reverse the string "programming" using the char-array two-pointer approach.

class Task18_ReverseCharArray {
    public static void main(String[] args) {
        String original = "programming";
        char[] array1 = original.toCharArray();
        int start = 0;
        int end = array1.length - 1;

        while (start < end) {
            char temp = array1[start];
            array1[start] = array1[end];
            array1[end] = temp;
            start++;
            end--;
        }
        String newString = new String(array1);
        System.out.println(newString);

    }
}