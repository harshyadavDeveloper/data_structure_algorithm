// Task 33 (combining ideas): Given {{1,2,3},{4,5,6},{7,8,9}}, print the sum of each row separately, and then the sum of each
// column separately. Think about which loop needs to be the "outer" one for row-sums vs column-sums — does the accumulator's
// reset timing change between the two?

// explain: the outer look shall be of row and inner if cols. 

class Main {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 } };

        for (int row = 0; row < matrix.length; row++) {
            int rowSum = 0;
            for (int col = 0; col < matrix[row].length; col++) {

                rowSum += matrix[row][col];

            }
            System.out.println("Row: " + row + " " + "Row Sum: " + rowSum);

        }

        for (int col = 0; col < matrix[0].length; col++) {
            int colSum = 0;
            for (int row = 0; row < matrix.length; row++) {
                colSum += matrix[row][col];
            }

            System.out.println("Column: " + col + " " + "Column Sum: " + colSum);
        }

    }
}