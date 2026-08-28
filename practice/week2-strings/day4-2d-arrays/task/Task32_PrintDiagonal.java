// Task 32: Given {{5,1,2},{3,9,4},{6,7,8}}, print the main diagonal. expected output is 5 9 8

class Main {

    public static void main(String[] args) {
        int[][] matrix = { { 5, 1, 2 },
                { 3, 9, 4 },
                { 6, 7, 8 } };

        for (int i = 0; i < matrix.length; i++) {
            System.out.print(matrix[i][i] + " ");
        }

    }
}