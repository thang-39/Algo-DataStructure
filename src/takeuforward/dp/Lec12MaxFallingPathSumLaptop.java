package takeuforward.dp;

// Variable Starting and Ending Points
// https://www.codingninjas.com/studio/problems/maximum-path-sum-in-the-matrix_797998?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos
public class Lec12MaxFallingPathSumLaptop {
    public static void main(String[] args) {
        int[][] matrix1 = {{1,2,10,4},{100,3,2,1},{1,1,20,2},{1,2,2,1}};
        int[][] matrix2 = {{10,2,3}, {3,7,2},{8,1,5}};
        System.out.println(getMaxPathSum(matrix1));
        System.out.println(getMaxPathSum(matrix2));
    }

    public static int getMaxPathSum(int[][] matrix) {
        int result = Integer.MIN_VALUE;
        for (int col = 0; col < matrix[0].length; col++) {
            int temp = recursion(0, col, matrix);
            result = Math.max(temp, result);
        }
        return result;
    }

    private static int recursion(int row, int col, int[][] matrix) {
        if (col < 0 || col == matrix[0].length) return - (int) Math.pow(10,8);
        if (row == matrix.length-1) return matrix[row][col];

        int down = matrix[row][col] + recursion(row+1,col,matrix);

        int leftDiagonal = matrix[col][row] + recursion(row+1,col-1,matrix);

        int rightDiagonal = matrix[col][row] + recursion(row+1,col+1,matrix);

        return Math.max(down, Math.max(leftDiagonal,rightDiagonal));
    }

}
