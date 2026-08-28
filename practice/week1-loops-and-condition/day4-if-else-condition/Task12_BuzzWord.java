// Task 12: For numbers 1 to 50, print "Buzz" if the number is divisible by 5, and print the number itself otherwise. Before 
// coding — think about which of your two conditions should be checked first and why (there's only one real branch here, but 
// think about ordering anyway, it matters for Task 13).

class Main {
    public static void main(String[] args) {

        for (int i = 0; i <= 50; i++) {
            if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }

    }
}