// Task 31: Transpose {{1,2},{3,4},{5,6}} (a 3×2 matrix) and print the result (should be a 2×3 matrix).

// Explain: the idea of transpose is matrix[row][col] -> transpose[col][row]

class Main {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2 }, { 3, 4 }, { 5, 6 } };
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transpose = new int[cols][rows];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                transpose[col][row] = matrix[row][col];
            }
        }

        for (int[] newRow : transpose) {
            for (int element : newRow) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}