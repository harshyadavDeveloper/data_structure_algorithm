// find and print sum of all elements in a matrix
class Main {
  public static void main(String[] args) {
    int[][] matrix = {
        { 1, 2, 3 },
        { 4, 5, 6 },
        { 7, 8, 9 }
    };
    int sum = 0;

    for (int row = 0; row < matrix.length; row++) {
      for (int col = 0; col < matrix[row].length; col++) {
        sum += matrix[row][col];
      }
    }
    System.out.println(sum);
  }

}