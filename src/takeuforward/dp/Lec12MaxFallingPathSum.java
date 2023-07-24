package takeuforward.dp;

import java.util.Arrays;

public class Lec12MaxFallingPathSum {
    public static void main(String[] args) {
        int[][] matrix1 = {{1,2,10,4},{100,3,2,1},{1,1,20,2}, {1,2,2,1}};
        int[][] matrix2 = {{10,2,3}, {3,7,2},{8,1,5}};

        System.out.println(getMaxPathSum(matrix1));
        System.out.println(getMaxPathSum(matrix2));

        System.out.println(getMaxPathSumMemorization(matrix1));
        System.out.println(getMaxPathSumMemorization(matrix2));

    }

    public static int getMaxPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int result = Integer.MIN_VALUE;

        for (int col = 0; col < matrix[0].length; col++) {

//            result = Math.max(result, recursion(0,col,matrix));
//            result = Math.max(result, recursion2(n-1,col,matrix));
//            int temp = recursion3(n-1,col,matrix);
//            result = Math.max(result, temp);
            result = Math.max(result,recursion4(0,col,matrix));

        }
        return result;
    }

    private static int recursion(int row, int col, int[][] matrix) {

        if (col < 0 || col >= matrix[0].length)
            return -(int) Math.pow(10,9);

        if (row == matrix.length - 1)
            return matrix[row][col];



        int up = matrix[row][col] + recursion(row+1,col,matrix);

        int leftDiagonal = matrix[row][col] + recursion(row+1,col-1,matrix);

        int rightDiagonal = matrix[row][col] + recursion(row+1,col+1,matrix);

        return Math.max(up,Math.max(leftDiagonal,rightDiagonal));
    }

    private static int recursion2(int row, int col, int[][] matrix) {

        if (col < 0 || col >= matrix[0].length)
            return -(int) Math.pow(10,9);

        if (row == 0)
            return matrix[0][col];

        int up = matrix[row][col] + recursion2(row-1,col,matrix);

        int leftDiagonal = matrix[row][col] + recursion2(row-1,col-1,matrix);

        int rightDiagonal = matrix[row][col] + recursion2(row-1,col+1,matrix);

        return Math.max(up,Math.max(leftDiagonal,rightDiagonal));
    }

    private static int recursion3(int row, int col, int[][] matrix) {

        if (row == 0)
            return matrix[0][col];

        int up = matrix[row][col] + recursion3(row-1,col,matrix);

        int leftDiagonal = - (int) Math.pow(10,9);
        if (col > 0)
            leftDiagonal = matrix[row][col] + recursion3(row-1,col-1,matrix);

        int rightDiagonal = - (int) Math.pow(10,9);
        if (col < matrix[0].length-1)
            rightDiagonal = matrix[row][col] + recursion3(row-1,col+1,matrix);

        return Math.max(up,Math.max(leftDiagonal,rightDiagonal));
    }

    private static int recursion4(int row, int col, int[][] matrix) {
        if (row == matrix.length - 1) return matrix[row][col];

        int down = matrix[row][col] + recursion4(row+1,col,matrix);

        int leftDiagonal = - (int) Math.pow(10,8);
        if (col > 0)
            leftDiagonal = matrix[row][col] + recursion4(row+1,col-1,matrix);

        int rightDiagonal = - (int) Math.pow(10,8);
        if (col < matrix[0].length - 1)
            rightDiagonal = matrix[row][col] + recursion4(row+1,col+1,matrix);

        return Math.max(down,Math.max(leftDiagonal,rightDiagonal));
    }



    public static int getMaxPathSumMemorization(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] dp = new int[n][m];

        int result = Integer.MIN_VALUE;
        for (int col = 0; col < m; col++) {
//            result = Math.max(result, recursion2(n-1,col,matrix));
            result = Math.max(result, recursionMemorization(0,col,matrix,dp));
        }
        return result;
    }

    private static int recursionMemorization(int row, int col, int[][] matrix, int[][] dp ) {

        if (col < 0 || col >= matrix[0].length)
            return -(int) Math.pow(10,9);

        if (row == matrix.length - 1)
            return matrix[row][col];

        if (dp[row][col] != 0) return dp[row][col];

        int up = matrix[row][col] + recursionMemorization(row+1,col,matrix,dp);

        int leftDiagonal = matrix[row][col] + recursionMemorization(row+1,col-1,matrix,dp);

        int rightDiagonal = matrix[row][col] + recursionMemorization(row+1,col+1,matrix,dp);

        return dp[row][col] = Math.max(up,Math.max(leftDiagonal,rightDiagonal));
    }

}
