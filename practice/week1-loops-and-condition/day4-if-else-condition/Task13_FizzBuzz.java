// Task 13 (the classic, but understand it, don't recall it from anywhere): For numbers 1 to 30 — print "FizzBuzz" if divisible 
// by both 3 and 5, print "Fizz" if divisible by only 3, print "Buzz" if divisible by only 5, otherwise print the number. Before 
// writing code, answer in your notebook: why must the "divisible by both" check come first in your if-else chain, rather than 
// last? Think about what happens to a number like 15 if you check "divisible by 3" before checking "divisible by both."

class Main {
    public static void main(String[] args) {
        for (int i = 1; i <= 30; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }

    }
}