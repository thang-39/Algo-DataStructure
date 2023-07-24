package takeuforward.dp;

import java.util.Arrays;

public class Lec12MaxFallingPathSum {
    public static void main(String[] args) {
        int[][] matrix1 = {{1,2,10,4},{100,3,2,1},{1,1,20,2}, {1,2,2,1}};
        int[][] matrix2 = {{10,2,3}, {3,7,2},{8,1,5}};
        int[][] matrix3 = {{-9999,-9888,-9777,-9666,-9555}};
        int[][] matrix4 = {{-9999,-9888,-9777,-9666,-9555},{1,10,2,4,5},{-9999,-9888,-9777,-9666,-9555},{0,0,0,0,0},{-99,-98,-97,-96,-95}};

        System.out.println(getMaxPathSum(matrix1));
        System.out.println(getMaxPathSum(matrix2));

        System.out.println(getMaxPathSumMemorization(matrix1));
        System.out.println(getMaxPathSumMemorization(matrix2));

        System.out.println(getMaxPathSumMTabulation(matrix1));
        System.out.println(getMaxPathSumMTabulation(matrix2));

        System.out.println(getMaxPathSumMTabulationSpaceOptimization(matrix1));
        System.out.println(getMaxPathSumMTabulationSpaceOptimization(matrix2));
        System.out.println(getMaxPathSumMTabulationSpaceOptimization(matrix3));
        System.out.println(getMaxPathSumMTabulationSpaceOptimization(matrix4));


    }

    public static int getMaxPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int result = Integer.MIN_VALUE;

        for (int col = 0; col < matrix[0].length; col++) {

//            result = Math.max(result, recursion(0,col,matrix));
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

    private static int recursion4(int row, int col, int[][] matrix) {
        if (row == matrix.length - 1)
            return matrix[row][col];

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

    public static int getMaxPathSumMTabulation(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] dp = new int[n][m];

        System.arraycopy(matrix[0],0,dp[0],0,m);

        int result = Integer.MIN_VALUE;

        for (int row = 1; row < n; row++) {
            for (int col = 0; col < m; col++) {

                int down = dp[row-1][col] + matrix[row][col];

                int leftDiagonal = Integer.MIN_VALUE;
                if (col > 0)
                    leftDiagonal = dp[row-1][col-1] + matrix[row][col];

                int rightDiagonal = Integer.MIN_VALUE;
                if (col < m-1)
                    rightDiagonal = dp[row-1][col+1] + matrix[row][col];

                dp[row][col] = Math.max(down, Math.max(rightDiagonal,leftDiagonal));

                if (row == n-1)
                    result = Math.max(dp[row][col],result);
            }
        }
        return result;
    }

    public static int getMaxPathSumMTabulationSpaceOptimization(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[] dp = new int[m];

        System.arraycopy(matrix[0],0,dp,0,m);

        int result = Integer.MIN_VALUE;

        if (n==1) {
            for (int j : dp) {
                result = Math.max(result, j);
            }
        }

        for (int row = 1; row < n; row++) {
            int[] temp = new int[m];
            for (int col = 0; col < m; col++) {

                int down = dp[col] + matrix[row][col];

                int leftDiagonal = Integer.MIN_VALUE;
                if (col > 0)
                    leftDiagonal = dp[col-1] + matrix[row][col];

                int rightDiagonal = Integer.MIN_VALUE;
                if (col < m-1)
                    rightDiagonal = dp[col+1] + matrix[row][col];

                temp[col] = Math.max(down, Math.max(rightDiagonal,leftDiagonal));

                if (row == n-1)
                    result = Math.max(temp[col],result);
            }
            dp = temp;
        }
        return result;
    }

}
