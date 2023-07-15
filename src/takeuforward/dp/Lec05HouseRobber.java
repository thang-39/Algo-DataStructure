package takeuforward.dp;

import java.util.Arrays;

public class Lec05HouseRobber {
    public static void main(String[] args) {
        System.out.println(robMemorization(new int[]{1,2,3,1}));
        System.out.println(robMemorization(new int[]{1}));

        System.out.println(robTabulation(new int[]{1,2,3,1}));
        System.out.println(robTabulation(new int[]{1}));

        System.out.println(robTabulationSpaceOptimization(new int[]{1,2,3,1}));
        System.out.println(robTabulationSpaceOptimization(new int[]{1}));
    }

    public static int rob(int[] nums) {
        int index = nums.length-1;

        return recursion(index, nums);
    }

    private static int recursion(int index, int[] nums) {
        if (index < 0) return 0;
        int pick = recursion(index-2, nums) + nums[index];
        int notPick = recursion(index-1, nums);
        return Math.max(pick, notPick);
    }

    public static int robMemorization(int[] nums) {
        int index = nums.length-1;
        int[] dp = new int[nums.length];

        return recursionMemorization(index, nums, dp);
    }

    private static int recursionMemorization(int index, int[] nums, int[] dp) {
        if (index < 0) return 0;
        if (dp[index] != 0) return dp[index];
        int pick = recursion(index-2, nums) + nums[index];
        int notPick = recursion(index-1, nums);
        return dp[index] = Math.max(pick, notPick);
    }

    // wrong
    public static int robTabulationWrong(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Arrays.stream(nums).max().getAsInt();
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            int pick = nums[i] + dp[i-2];
            int notPick = dp[i-1];
            dp[i] = Math.max(pick,notPick);
        }
        return dp[nums.length-1];
    }

    public static int robTabulation(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int pick = nums[i];
            if (i>=2) pick += dp[i-2];
            int notPick = dp[i-1];
            dp[i] = Math.max(pick,notPick);
        }
        return dp[nums.length-1];
    }

    public static int robTabulationSpaceOptimization(int[] nums) {
        int prev = nums[0];
        int prev2 = 0;

        for (int i = 1; i < nums.length; i++) {
            int pick = nums[i];
            if (i>=2) pick += prev2;

            int notPick = prev;

            int curi = Math.max(pick,notPick);
            prev2 = prev;
            prev = curi;
        }
        return prev;
    }



}
