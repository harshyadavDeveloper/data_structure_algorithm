// Task 30: Given {{2,4,6},{1,3,5},{7,8,9}}, find and print the sum of all elements.

class Main {
    public static void main(String[] main) {
        int[][] matrix = { { 2, 4, 6 }, { 1, 3, 5 }, { 7, 8, 9 } };
        int sum = 0;

        for (int row = 0; row < matrix.length; row++) { // rows is like floor
            for (int col = 0; col < matrix[row].length; col++) { // col is like the lockers on each row
                sum += matrix[row][col];
            }
        }
        System.out.println("Sum: " + sum);
    }
}