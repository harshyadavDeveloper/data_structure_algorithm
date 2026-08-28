// Task: turn {{1,2,3},{4,5,6}} into {{1,4},{2,5},{3,6}}.
// the core idea of transpose is matrix[row][col] -> transpose[col][row]

class Main {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 } };
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transpose = new int[cols][rows];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                transpose[col][row] = matrix[row][col];

            }
        }
        for (int[] currentRow : transpose) {
            for (int value : currentRow) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}