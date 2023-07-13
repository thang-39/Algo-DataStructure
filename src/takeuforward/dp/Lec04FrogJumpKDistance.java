package takeuforward.dp;

import java.util.Arrays;

public class Lec04FrogJumpKDistance {
    public static void main(String[] args) {
        System.out.println(frogJumpKDistanceRecursion(4, 2, new int[]{10,20,30,10}));
        System.out.println(frogJumpKDistanceMemorization(4, 3, new int[]{10,20,30,10}));
        System.out.println(frogJumpKDistanceTabulation(4, 2, new int[]{10,20,30,10}));
    }

    public static int frogJumpKDistanceRecursion(int n, int k,int[] heights) {
        int index = n-1;
        return recursion(index, k, heights);
    }

    private static int recursion(int index, int k, int[] heights) {
        if (index == 0) return 0;
        int ans = Integer.MAX_VALUE;
        for (int j = 1; j <= k; j++) {
            if (index - j >=0) {
                int jumpK = recursion(index - j, k, heights) + Math.abs(heights[index - j] - heights[index]);
                ans = Math.min(jumpK, ans);
            }
            else break;
        }
        return ans;
    }

    public static int frogJumpKDistanceMemorization(int n, int k,int[] heights) {
        int index = n-1;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return recursionMemorization(index, k, heights, dp);
    }

    private static int recursionMemorization(int index, int k, int[] heights, int[] dp) {
        if (index == 0) return 0;
        if (dp[index] != -1) return dp[index];
        int ans = Integer.MAX_VALUE;
        for (int j = 1; j <= k; j++) {
            if (index - j >= 0) {
                int jumpK = recursionMemorization(index-j,k,heights,dp) + Math.abs(heights[index - j] - heights[index]);
                ans = Math.min(ans,jumpK);
            }
        }
        return dp[index] = ans;
    }

    public static int frogJumpKDistanceTabulation(int n, int k, int[] heights) {
        int[] dp = new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            for (int j = i-1; j >= 0; j--) {
                if (j >= i-k) {
                    dp[i] = Math.min(dp[i], dp[j] +  Math.abs(heights[i] - heights[j]));
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n-1];

    }
}
