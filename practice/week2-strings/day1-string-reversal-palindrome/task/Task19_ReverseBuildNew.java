// Task 19: Reverse the same string using the "build a new string backward" approach. Confirm both approaches give identical output.

class Task19_ReverseBuildNew {
    public static void main(String[] args) {
        String original = "programming";
        String reversed = "";

        for (int i = original.length() - 1; i >= 0; i--) {
            reversed = reversed + original.charAt(i);
        }
        System.out.println(reversed);
    }
}
