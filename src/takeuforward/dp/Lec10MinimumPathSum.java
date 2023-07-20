package takeuforward.dp;

import java.util.Arrays;

// https://www.codingninjas.com/studio/problems/minimum-path-sum_985349
public class Lec10MinimumPathSum {
    public static void main(String[] args) {
        int[][] grid1 = {{5,9,6},{11,5,2}};
        int[][] grid2 = {{1,2,3},{4,5,4},{7,5,9}};

        System.out.println(minSumPath(grid1));
        System.out.println(minSumPath(grid2));

        System.out.println(minSumPathMemorization(grid1));
        System.out.println(minSumPathMemorization(grid2));

        System.out.println(minSumPathTabulation(grid1));
        System.out.println(minSumPathTabulation(grid2));

        System.out.println(minSumPathTabulationSpaceOptimization(grid1));
        System.out.println(minSumPathTabulationSpaceOptimization(grid2));
    }

    public static int minSumPath(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        return recursion(row - 1, col - 1, grid);
    }

    private static int recursion(int row, int col, int[][] grid) {
        if (row == 0 && col == 0) return grid[0][0];
        if (row < 0 || col < 0) return (int) Math.pow(10,6);

        int up = grid[row][col] + recursion(row-1,col,grid);
        int left = grid[row][col] + recursion(row,col-1,grid);
        return Math.min(up,left);
    }

    public static int minSumPathMemorization(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        return recursion(row - 1, col - 1, grid, dp);
    }

    private static int recursion(int row, int col, int[][] grid, int[][] dp) {
        if (row == 0 && col == 0) return grid[0][0];
        if (row < 0 || col < 0) return (int) Math.pow(10,6);
        if (dp[row][col] != 0) return dp[row][col];

        int up = grid[row][col] + recursion(row-1,col,grid,dp);
        int left = grid[row][col] + recursion(row,col-1,grid,dp);
        return dp[row][col] = Math.min(up,left);
    }

    public static int minSumPathTabulation(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) dp[0][0] = grid[0][0];
                else {
                    int up = (int) Math.pow(10,6), left = (int) Math.pow(10,6);
                    if (i > 0) up = grid[i][j] + dp[i-1][j];
                    if (j > 0) left = grid[i][j] + dp[i][j-1];
                    dp[i][j] = Math.min(up, left);
                }
            }
        }
        return dp[row-1][col-1];
    }

    public static int minSumPathTabulationSpaceOptimization(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[] dp = new int[col];

        for (int i = 0; i < row; i++) {
            int[] temp = new int[col];
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) temp[0] = grid[0][0];
                else {
                    int up = grid[i][j];
                    if (i > 0) up += dp[j];
                    else up += Math.pow(10,9);

                    int left = grid[i][j];
                    if (j > 0) left += temp[j-1];
                    else left += Math.pow(10,9);

                    temp[j] = Math.min(up, left);
                }
            }
            dp = temp;
        }
        return dp[col-1];
    }
}
