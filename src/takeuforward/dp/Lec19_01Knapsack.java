package takeuforward.dp;

import java.util.Arrays;

// https://www.codingninjas.com/studio/problems/0-1-knapsack_920542
public class Lec19_01Knapsack {
    public static void main(String[] args) {
        System.out.println(knapsack(new int[]{1,2,4,5},new int[] {5,4,8,6},4,5));
        System.out.println(knapsack(new int[]{1},new int[] {7},1,1));
        System.out.println(knapsack(new int[]{1,5,6,9,7,9,7},new int[] {1,7,1,5,1,7,7},7,37));
        System.out.println(knapsack(new int[]{6,5,1,5,6,5,9},new int[] {5,3,4,9,6,1,1},7,63));

        System.out.println(knapsackMemorization(new int[]{1,2,4,5},new int[] {5,4,8,6},4,5));
        System.out.println(knapsackMemorization(new int[]{1},new int[] {7},1,1));
        System.out.println(knapsackMemorization(new int[]{1,5,6,9,7,9,7},new int[] {1,7,1,5,1,7,7},7,37));
        System.out.println(knapsackMemorization(new int[]{6,5,1,5,6,5,9},new int[] {5,3,4,9,6,1,1},7,63));

        System.out.println(knapsackTabulation(new int[]{1,2,4,5},new int[] {5,4,8,6},4,5));
        System.out.println(knapsackTabulation(new int[]{1},new int[] {7},1,1));
        System.out.println(knapsackTabulation(new int[]{1,5,6,9,7,9,7},new int[] {1,7,1,5,1,7,7},7,37));
        System.out.println(knapsackTabulation(new int[]{6,5,1,5,6,5,9},new int[] {5,3,4,9,6,1,1},7,63));

        System.out.println(knapsackTabulationSpaceOptimization(new int[]{1,2,4,5},new int[] {5,4,8,6},4,5));
        System.out.println(knapsackTabulationSpaceOptimization(new int[]{1},new int[] {7},1,1));
        System.out.println(knapsackTabulationSpaceOptimization(new int[]{1,5,6,9,7,9,7},new int[] {1,7,1,5,1,7,7},7,37));
        System.out.println(knapsackTabulationSpaceOptimization(new int[]{6,5,1,5,6,5,9},new int[] {5,3,4,9,6,1,1},7,63));

        System.out.println(knapsackSpaceOptimization(new int[]{1,2,4,5},new int[] {5,4,8,6},4,5));
        System.out.println(knapsackSpaceOptimization(new int[]{1},new int[] {7},1,1));
        System.out.println(knapsackSpaceOptimization(new int[]{1,5,6,9,7,9,7},new int[] {1,7,1,5,1,7,7},7,37));
        System.out.println(knapsackSpaceOptimization(new int[]{6,5,1,5,6,5,9},new int[] {5,3,4,9,6,1,1},7,63));

    }

    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        return recursion(n-1,maxWeight,weight,value);
    }

    private static int recursion(int index, int maxWeight,
                                 int[] weight, int[] value) {
        if (index == 0) {
            if (weight[0] <= maxWeight) return value[0];
            else return 0;
        }

        int notPick = recursion(index-1,maxWeight,weight,value);

        int pick = Integer.MIN_VALUE;
        if (weight[index] <= maxWeight) {
            pick = value[index] + recursion(index-1,maxWeight-weight[index],
                                            weight,value);
        }

        return Math.max(pick,notPick);
    }

    static int knapsackMemorization(int[] weight, int[] value, int n, int maxWeight) {
        int[][] dp = new int[n][maxWeight+1];
        for (int[] row : dp) {
            Arrays.fill(row,-1);
        }
        return recursionMemorization(n-1,maxWeight,dp,weight,value);
    }

    private static int recursionMemorization(int index, int maxWeight, int[][] dp,
                                 int[] weight, int[] value) {
        if (index == 0) {
            if (weight[0] <= maxWeight) return value[0];
            else return 0;
        }

        if (dp[index][maxWeight] != -1) return dp[index][maxWeight];

        int notPick = recursionMemorization(index-1,maxWeight,dp,weight,value);

        int pick = Integer.MIN_VALUE;
        if (weight[index] <= maxWeight) {
            pick = value[index] + recursionMemorization(index-1,maxWeight-weight[index],dp,
                    weight,value);
        }

        return dp[index][maxWeight] = Math.max(pick,notPick);
    }

    static int knapsackTabulation(int[] weight, int[] value, int n, int maxWeight) {
        int[][] dp = new int[n][maxWeight+1];

        for (int w = weight[0]; w <= maxWeight; w++)
            dp[0][w] = value[0];


        for (int index = 1; index < n; index++) {
            for (int w = 0; w <= maxWeight; w++) {
                int notPick = dp[index-1][w];

                int pick = Integer.MIN_VALUE;
                if (weight[index] <= w) {
                    pick = value[index] + dp[index-1][w-weight[index]];
                }
                dp[index][w] = Math.max(pick,notPick);
            }
        }
        return dp[n-1][maxWeight];
    }

    static int knapsackTabulationSpaceOptimization(int[] weight, int[] value, int n, int maxWeight) {
        int[] prev = new int[maxWeight+1];

        for (int w = weight[0]; w <= maxWeight; w++)
            prev[w] = value[0];


        for (int index = 1; index < n; index++) {
            int[] cur = new int[maxWeight+1];
            for (int w = 0; w <= maxWeight; w++) {
                int notPick = prev[w];

                int pick = Integer.MIN_VALUE;
                if (weight[index] <= w) {
                    pick = value[index] + prev[w-weight[index]];
                }
                cur[w] = Math.max(pick,notPick);
            }
            prev = cur;
        }
        return prev[maxWeight];
    }

    static int knapsackSpaceOptimization(int[] weight, int[] value, int n, int maxWeight) {
        int[] prev = new int[maxWeight+1];

        for (int w = weight[0]; w <= maxWeight; w++)
            prev[w] = value[0];


        for (int index = 1; index < n; index++) {
            for (int w = maxWeight; w >= 0; w--) {
                int notPick = prev[w];

                int pick = Integer.MIN_VALUE;
                if (weight[index] <= w) {
                    pick = value[index] + prev[w-weight[index]];
                }
                prev[w] = Math.max(pick,notPick);
            }
        }
        return prev[maxWeight];
    }


}
