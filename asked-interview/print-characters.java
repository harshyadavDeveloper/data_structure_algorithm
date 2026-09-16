class PrintCharacters {
    public static void main(String[] args) {
        prinChars();

    }

    public static void prinChars() {
        String word = "cat";
        int count = 2;

        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < count; j++) {
                System.out.print(word.charAt(i) + " ");
            }
            count++;
        }
    }
}