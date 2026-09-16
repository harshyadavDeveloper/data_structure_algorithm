// reverse a string using char[]

// class ExampleReverseAString{
//     public static void main(String[] args){
//         String original = "hello";
//         char[] reverse = original.toCharArray();
//         int start = 0;
//         int end = reverse.length - 1; // start and end are the valid indexs
//         while(start < end){
//             char temp = reverse[start];
//             reverse[start] = reverse[end];
//             reverse[end] = temp;
//             start++;
//             end--;
//         }
//         String newString = new String(reverse);
//         System.out.println(newString);
//     }
// }

// approach 2 building a new string by walking backward

class ExampleReverseAString {
    public static void main(String[] args) {
        String original = "Harsh";
        String reversed = "";

        for (int i = original.length() - 1; i >= 0; i--) {
            reversed = reversed + original.charAt(i);
        }
        System.out.println(reversed);
    }
}