package takeuforward.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lec09MazeObstacles {

    // https://www.codingninjas.com/studio/problems/unique-paths-ii_977241
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> mat1 = new ArrayList<>();

        ArrayList<Integer> row1 = new ArrayList<>();
        row1.add(0);
        row1.add(0);
        row1.add(0);

        ArrayList<Integer> row2 = new ArrayList<>();
        row2.add(0);
        row2.add(-1);
        row2.add(0);

        ArrayList<Integer> row3 = new ArrayList<>();
        row3.add(0);
        row3.add(0);
        row3.add(0);

        mat1.add(row1);
        mat1.add(row2);
        mat1.add(row3);
        System.out.println(mazeObstacles(3,3,mat1));
        System.out.println(mazeObstaclesMemorization(3,3,mat1));
        System.out.println(mazeObstaclesTabulation(3,3,mat1));
        System.out.println(mazeObstaclesSpaceOptimization(3,3,mat1));
    }

    static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {
        // Write your code here.
        return recursion(m-1, n-1, mat);

    }

    private static int recursion(int m, int n, ArrayList<ArrayList<Integer>> mat) {
        if (m == 0 && n == 0) return 1;
        if (m < 0 || n < 0) return 0;
        if (mat.get(m).get(n) == -1) return 0;

        int up = recursion(m-1,n,mat);
        int left = recursion(m,n-1,mat);
        return up + left;
    }

    static int mazeObstaclesMemorization(int n, int m, ArrayList<ArrayList<Integer>> mat) {

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i] = new int[n];
            Arrays.fill(dp[i],-1);
        }

        return recursionMemorization(m-1, n-1, mat, dp);

    }

    private static int recursionMemorization(int m, int n, ArrayList<ArrayList<Integer>> mat, int[][] dp) {
        if (m == 0 && n == 0) return 1;
        if (m < 0 || n < 0) return 0;
        if (mat.get(m).get(n) == -1) return 0;
        if (dp[m][n] != -1) return dp[m][n];

        int up = recursionMemorization(m-1,n,mat, dp);
        int left = recursionMemorization(m,n-1,mat, dp);
        return dp[m][n] = up + left;
    }

    public static int mazeObstaclesTabulation(int m, int n, ArrayList<ArrayList<Integer>> mat) {

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat.get(i).get(j) == -1) dp[i][j] = 0;
                else if (i == 0 && j == 0) dp[0][0] = 1;
                else {
                    int up = 0, left = 0;
                    if (i > 0) up = dp[i-1][j];
                    if (j > 0) left = dp[i][j-1];
                    dp[i][j] = up + left;
                }
            }
        }
        return dp[m-1][n-1];
    }

    public static int mazeObstaclesSpaceOptimization(int m, int n, ArrayList<ArrayList<Integer>> mat) {

        int mod = (int) (Math.pow(10,9) + 7);
        int[] prev = new int[n];

        for (int i = 0; i < m; i++) {
            int[] temp = new int[n];
            for (int j = 0; j < n; j++) {
                if (mat.get(i).get(j) == -1) temp[j] = 0;
                else if (i == 0 && j == 0) temp[0] = 1;
                else {
                    int left = 0;
                    int up = prev[j];
                    if (j > 0) left = temp[j-1];
                    temp[j] = up + left;
                }
            }
            prev = temp;
        }
        return prev[n-1];
    }


}
