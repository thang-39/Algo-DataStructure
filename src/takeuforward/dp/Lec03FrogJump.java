package takeuforward.dp;

// https://www.codingninjas.com/studio/problems/frog-jump_3621012
public class Lec03FrogJump {
    public static void main(String[] args) {
        System.out.println(frogJump(3, new int[]{10,20,30,10}));
        System.out.println(frogJumpTabulation(3, new int[]{10,20,30,10}));
        System.out.println(frogJumpTabulationOptimize(3, new int[]{10,20,30,10}));
    }

    public static int frogJump(int n, int[] heights) {
        int index = n-1;
        int[] dp = new int[n];
        return recursion(index, heights, dp);
    }

    public static int recursion(int index, int[] heights) {
        if (index == 0) return 0;
        int left = recursion(index-1, heights) + Math.abs(heights[index]-heights[index-1]);
        int right = Integer.MAX_VALUE;
        if (index > 1)
            right = recursion(index-2, heights) + Math.abs(heights[index] - heights[index-2]);
        return Math.min(left,right);
    }

    public static int recursion(int index, int[] heights, int[] dp) {
        if (index == 0) return 0;
        if (dp[index] != 0) return dp[index];

        int left = recursion(index-1, heights, dp) + Math.abs(heights[index]-heights[index-1]);
        int right = Integer.MAX_VALUE;
        if (index > 1)
            right = recursion(index-2, heights,dp) + Math.abs(heights[index] - heights[index-2]);
        return dp[index] = Math.min(left,right);
    }

    public static int frogJumpTabulation(int n, int[] heights) {
        int[] dp = new int[n];
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            int firstStep = dp[i-1] + Math.abs(heights[i-1] - heights[i]);
            int secondStep = Integer.MAX_VALUE;
            if (i > 1)
                secondStep = dp[i-2] + Math.abs(heights[i-2] - heights[i]);
            dp[i] = Math.min(firstStep,secondStep);
        }
        return dp[n-1];
    }

    public static int frogJumpTabulationOptimize(int n, int[] heights) {
        int prev = 0;
        int prev2 = 0;

        for (int i = 1; i < n; i++) {
            int firstStep = prev + Math.abs(heights[i-1] - heights[i]);
            int secondStep = Integer.MAX_VALUE;
            if (i > 1)
                secondStep = prev2 + Math.abs(heights[i-2] - heights[i]);
            int curi = Math.min(firstStep,secondStep);
            prev2 = prev;
            prev = curi;
        }
        return prev;
    }
}
