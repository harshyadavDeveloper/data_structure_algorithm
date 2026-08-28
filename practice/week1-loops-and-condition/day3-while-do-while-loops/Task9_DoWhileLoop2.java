// Task 9: Write a do-while loop that starts at int i = 1;, prints i, increments it, and repeats while i <= 5. Then, separately, 
// write the exact same logic as a plain while loop. Run both. This time the starting condition is true from the beginning — 
// predict in your notebook whether the outputs will be identical or different between the two versions, and why, before running 
// either.

class Main {
    public static void main(String[] args) {
        int i = 1;
        do {
            System.out.println(i);
            i++;
        } while (i <= 5);

        int myi = 1;
        while (myi <= 5) {
            System.out.println(myi);
            myi++;
        }

    }
}