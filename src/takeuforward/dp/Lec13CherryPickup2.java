package takeuforward.dp;

import java.util.Arrays;

public class Lec13CherryPickup2 {
    public static void main(String[] args) {
        int[][] grid1 = {{2,3,1,2},{3,4,2,2},{5,6,3,5}};
        int[][] grid2 = {{1,1},{1,2}};
        System.out.println(maximumChocolates(3,4,grid1));
        System.out.println(maximumChocolates(2,2,grid2));

        System.out.println(maximumChocolatesMemorization(3,4,grid1));
        System.out.println(maximumChocolatesMemorization(2,2,grid2));

        System.out.println(maximumChocolatesTabulation(3,4,grid1));
        System.out.println(maximumChocolatesTabulation(2,2,grid2));

        System.out.println(maximumChocolatesTabulationSpaceOptimization(3,4,grid1));
        System.out.println(maximumChocolatesTabulationSpaceOptimization(2,2,grid2));
    }

    public static int maximumChocolates(int r, int c, int[][] grid) {
        return recursion(0,0,c-1,grid);
    }

    private static int recursion(int row, int alice, int bob, int[][] grid) {
        if (alice < 0 || alice >= grid[0].length || bob < 0 || bob >= grid[0].length)
            return -(int) Math.pow(10,9);

        if (row == grid.length-1) {
            if (alice == bob) return grid[row][alice];
            else return grid[row][alice] + grid[row][bob];
        }

        int result = Integer.MIN_VALUE;

        for (int delta1 = -1; delta1 <= 1; delta1++) {
            for (int delta2 = -1; delta2 <= 1; delta2++) {
                int temp;
                if (bob == alice) {
                    temp = grid[row][alice] + recursion(row + 1, alice + delta1, bob + delta2, grid);
                } else
                    temp = grid[row][alice] + grid[row][bob] + recursion(row + 1, alice + delta1, bob + delta2, grid);
                result = Math.max(result,temp);
            }
        }
        return result;
    }

    public static int maximumChocolatesMemorization(int r, int c, int[][] grid) {

        int[][][] dp = new int[r][c][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                for (int k = 0; k < c; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        return recursion(0,0,c-1,grid,dp);
    }

    private static int recursion(int row, int alice, int bob, int[][] grid, int[][][] dp) {
        if (alice < 0 || alice >= grid[0].length || bob < 0 || bob >= grid[0].length)
            return -(int) Math.pow(10,9);

        if (row == grid.length-1) {
            if (alice == bob) return grid[row][alice];
            else return grid[row][alice] + grid[row][bob];
        }

        if (dp[row][alice][bob] != -1) return dp[row][alice][bob];

        int result = Integer.MIN_VALUE;

        for (int delta1 = -1; delta1 <= 1; delta1++) {
            for (int delta2 = -1; delta2 <= 1; delta2++) {
                int temp = 0;

                if (bob == alice) temp += grid[row][alice];
                else temp += grid[row][alice] + grid[row][bob];

                temp += recursion(row + 1, alice + delta1, bob + delta2, grid,dp);
                result = Math.max(result,temp);
            }
        }
        return dp[row][alice][bob] = result;
    }

    public static int maximumChocolatesTabulation(int r, int c, int[][] grid) {

        int[][][] dp = new int[r][c][c];

        // base case - take last row to base case of alice and bob
        for (int alice = 0; alice < c; alice++) {
            for (int bob = 0; bob < c; bob++) {
                if (alice == bob)
                    dp[r-1][alice][bob] = grid[r-1][alice];
                else
                    dp[r-1][alice][bob] = grid[r-1][alice] + grid[r-1][bob];
            }
        }


        for (int row = r-2; row >= 0; row--) {
            for (int alice = 0; alice < c; alice++) {
                for (int bob = 0; bob < c; bob++) {
                    // copy from memorization
                    int maxValue = Integer.MIN_VALUE;
                    for (int delta1 = -1; delta1 <= 1; delta1++) {
                        for (int delta2 = -1; delta2 <= 1; delta2++) {
                            int temp;

                            if (bob == alice) temp = grid[row][alice];
                            else temp = grid[row][alice] + grid[row][bob];

                            // if everything in bound
                            if (alice+delta1 >= 0 && bob+delta2 >= 0 && alice+delta1 < c && bob+delta2 < c)
                                temp += dp[row + 1][alice + delta1][bob + delta2];
                            else
                                temp += (int) - Math.pow(10,8);
                            maxValue = Math.max(maxValue,temp);
                        }
                    }
                    dp[row][alice][bob] = maxValue;
                    // above - copy from memorization
                }
            }
        }
        return dp[0][0][c-1];
    }

    public static int maximumChocolatesTabulationSpaceOptimization(int r, int c, int[][] grid) {

         int[][] dp = new int[c][c];

        // base case - take last row to base case of alice and bob
        for (int alice = 0; alice < c; alice++) {
            for (int bob = 0; bob < c; bob++) {
                if (alice == bob)
                    dp[alice][bob] = grid[r-1][alice];
                else
                    dp[alice][bob] = grid[r-1][alice] + grid[r-1][bob];
            }
        }


        for (int row = r-2; row >= 0; row--) {
            int[][] tempMatrix = new int[c][c];
            for (int alice = 0; alice < c; alice++) {
                for (int bob = 0; bob < c; bob++) {
                    // copy from memorization
                    int maxValue = Integer.MIN_VALUE;
                    for (int delta1 = -1; delta1 <= 1; delta1++) {
                        for (int delta2 = -1; delta2 <= 1; delta2++) {
                            int temp;

                            if (bob == alice) temp = grid[row][alice];
                            else temp = grid[row][alice] + grid[row][bob];

                            // if everything in bound
                            if (alice+delta1 >= 0 && bob+delta2 >= 0 && alice+delta1 < c && bob+delta2 < c)
                                temp += dp[alice + delta1][bob + delta2];
                            else
                                temp += (int) - Math.pow(10,8);
                            maxValue = Math.max(maxValue,temp);

                        }
                    }
                    tempMatrix[alice][bob] = maxValue;
                    // above - copy from memorization
                }
            }
            dp = tempMatrix;
        }
        return dp[0][c-1];
    }




}
