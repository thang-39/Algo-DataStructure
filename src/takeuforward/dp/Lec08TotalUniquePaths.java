package takeuforward.dp;

import java.util.Arrays;

public class Lec08TotalUniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths(2,2));
        System.out.println(uniquePaths(3,7));

        System.out.println(uniquePathsMemorization(2,2));
        System.out.println(uniquePathsMemorization(3,7));

        System.out.println(uniquePathsTabulation(2,2));
        System.out.println(uniquePathsTabulation(3,7));

        System.out.println(uniquePathsTabulationSpaceOptimization(2,2));
        System.out.println(uniquePathsTabulationSpaceOptimization(3,7));



    }

    public static int uniquePaths(int m, int n) {
        return recursion(m-1,n-1);
    }

    private static int recursion(int m, int n) {
        if (m == 0 && n == 0) return 1;
        if (m < 0 || n < 0) return 0;
        int left = recursion(m-1,n);
        int right = recursion(m,n-1);
        return left + right;
    }

    public static int uniquePathsMemorization(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i] = new int[n];
            Arrays.fill(dp[i],-1);
        }

        return recursionMemorization(m-1,n-1, dp);
    }

    private static int recursionMemorization(int m, int n, int[][] dp) {

        if (m == 0 && n == 0) return 1;
        if (m < 0 || n < 0) return 0;

        if (dp[m][n] != -1)  return dp[m][n];

        int left = recursionMemorization(m,n-1, dp);
        int up = recursionMemorization(m-1,n, dp);


        return dp[m][n] = up + left;
    }

    public static int uniquePathsTabulation(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++)
            dp[i] = new int[n];

        for (int i = 0; i < m; i++) {
            int up = 0;
            int left = 0;
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) dp[0][0]=1;
                else {
                    if (i > 0) up = dp[i-1][j];
                    if (j > 0) left = dp[i][j-1];
                    dp[i][j] = up + left;
                }
            }
        }

        return dp[m-1][n-1];
    }

    public static int uniquePathsTabulationSpaceOptimization(int m, int n) {
        int[] dp = new int[n];

        for (int i = 0; i < m; i++) {
            int[] temp = new int[n];
            for (int j = 0; j < n; j++) {
                if (i == 0 & j == 0) temp[0]=1;
                else {
                    int up = 0;
                    int left = 0;

                    if (i>0) up = dp[j];
                    if (j>0) left = temp[j-1];
                    temp[j] = up + left;
                }
            }
            dp = temp;
        }

        return dp[n-1];
    }
}
