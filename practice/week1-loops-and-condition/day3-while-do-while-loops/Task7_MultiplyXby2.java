// Task 7: Write a while loop that keeps multiplying a number x by 2, starting from x = 1, and prints each value, stopping once 
// x exceeds 1000. (You genuinely don't know upfront how many iterations this takes — that's the point, and exactly why while 
// fits here better than for.)

class Main {
    public static void main(String[] args) {
        int x = 1;
        while (x <= 1000) {
            x = x * 2;
            System.out.println(x);
        }
    }
}