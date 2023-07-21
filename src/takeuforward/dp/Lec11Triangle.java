package takeuforward.dp;

// https://www.codingninjas.com/studio/problems/triangle_1229398

import java.util.Arrays;

// from any point, we can go down and diagonal
// when reach the last row, it is done
// find minimum path sum
public class Lec11Triangle {
    public static void main(String[] args) {
        int[][] triangle1 = {{1},{2,3},{3,6,7},{8,9,6,10}};
        System.out.println(minimumPathSum(triangle1,4));
        System.out.println(minimumPathSumMemorization(triangle1,4));
        System.out.println(minimumPathSumTabulation(triangle1,4));
        System.out.println(minimumPathSumTabulationSpaceOptimization(triangle1,4));
    }

    public static int minimumPathSum(int[][] triangle, int n) {
        return recursion(0,0, triangle);
    }

    private static int recursion(int row, int col, int[][] triangle) {
       if (row == triangle.length - 1)
           return triangle[row][col];

       int down = triangle[row][col] + recursion(row+1,col,triangle);
       int diagonal = triangle[row][col] + recursion(row+1,col+1,triangle);

       return Math.min(down,diagonal);
    }

    public static int minimumPathSumMemorization(int[][] triangle, int n) {

        int[][] dp = new int[triangle.length][];
        for (int i = 0; i < triangle.length; i++) {
            dp[i] = Arrays.copyOf(triangle[i], triangle[i].length);
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (j <= i) {
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        return recursion(0,0, triangle,dp);
    }

    private static int recursion(int row, int col, int[][] triangle, int[][] dp) {
        if (row == triangle.length - 1)
            return triangle[row][col];
        if (dp[row][col] != Integer.MAX_VALUE) return dp[row][col];

        int down = triangle[row][col] + recursion(row+1,col,triangle,dp);
        int diagonal = triangle[row][col] + recursion(row+1,col+1,triangle,dp);

        return dp[row][col] = Math.min(down,diagonal);
    }

    public static int minimumPathSumTabulation(int[][] triangle, int n) {

        int[][] dp = new int[n][n];

        // copy last row of triangle to dp array
        // last row is base case of tabulation
        System.arraycopy(triangle[n - 1], 0, dp[n - 1], 0, n);

        for (int i = n-2; i >= 0; i--) {
            for (int j = 0; j < triangle[i].length; j++) {
                int down = dp[i+1][j] + triangle[i][j];
                int diagonal = dp[i+1][j+1] + triangle[i][j];
                dp[i][j] = Math.min(down,diagonal);
            }
        }
        return dp[0][0];
    }

    public static int minimumPathSumTabulationSpaceOptimization(int[][] triangle, int n) {

        int[]dp = new int[n];

        // copy last row of triangle to dp array
        // last row is base case of tabulation
        System.arraycopy(triangle[n - 1], 0, dp, 0, n);

        for (int i = n-2; i >= 0; i--) {
            int[] temp = new int[triangle[i].length];
            for (int j = 0; j < triangle[i].length; j++) {
                int down = dp[j] + triangle[i][j];
                int diagonal = dp[j+1] + triangle[i][j];
                temp[j] = Math.min(down,diagonal);
            }
            dp = temp;
        }
        return dp[0];
    }
}
