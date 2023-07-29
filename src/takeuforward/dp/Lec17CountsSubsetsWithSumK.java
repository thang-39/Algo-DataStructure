package takeuforward.dp;

import java.util.Arrays;

//https://www.codingninjas.com/studio/problems/number-of-subsets_3952532?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos
public class Lec17CountsSubsetsWithSumK {

    public static void main(String[] args) {

        System.out.println(findWays(new int[]{1,1,4,5},5));
        System.out.println(findWays(new int[]{1,1,1},2));
        System.out.println(findWays(new int[]{2,34,5},40));

        System.out.println(findWaysMemorization(new int[]{1,1,4,5},5));
        System.out.println(findWaysMemorization(new int[]{1,1,1},2));
        System.out.println(findWaysMemorization(new int[]{2,34,5},40));

        System.out.println(findWaysTabulation(new int[]{1,1,4,5},5));
        System.out.println(findWaysTabulation(new int[]{1,1,1},2));
        System.out.println(findWaysTabulation(new int[]{2,34,5},40));

        System.out.println(findWaysTabulationSpaceOptimization(new int[]{1,1,4,5},5));
        System.out.println(findWaysTabulationSpaceOptimization(new int[]{1,1,1},2));
        System.out.println(findWaysTabulationSpaceOptimization(new int[]{2,34,5},40));

    }

    public static int findWays(int[] num, int tar) {
        int n = num.length;
        return recursion(n-1, tar, num);
    }

    private static int recursion(int index, int tar, int[] num) {
        if (tar == 0) return 1;
        if (index == 0) {
            return (num[0] == tar) ? 1 : 0;
        }

        int notPick = recursion(index-1,tar,num);
        int pick = 0;
        if (num[index] <= tar) {
            pick = recursion(index-1,tar-num[index],num);
        }

        return pick + notPick;
    }

    public static int findWaysMemorization(int num[], int tar) {
        int n = num.length;
        int[][] dp = new int[n][tar+1];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }

        return recursion(n-1, tar, num, dp);
    }

    private static int recursion(int index, int tar, int[] num, int[][] dp) {
        if (tar == 0) return 1;
        if (index == 0) {
            return (num[0] == tar) ? 1 : 0;
        }

        if (dp[index][tar] != -1) return dp[index][tar];

        int notPick = recursion(index-1,tar,num);
        int pick = 0;
        if (num[index] <= tar) {
            pick = recursion(index-1,tar-num[index],num);
        }

        return dp[index][tar] = pick + notPick;
    }

    public static int findWaysTabulation(int num[], int tar) {
        int n = num.length;
        int[][] dp = new int[n][tar+1];

        for (int i = 0; i < n; i++)
            dp[i][0] = 1;

        if (num[0] <= tar)
            dp[0][num[0]] = 1;

        for (int index = 1; index < n; index++) {
            for (int target = 1; target <= tar; target++) {
                int notPick = dp[index-1][target];
                int pick = 0;
                if (num[index] <= target)
                    pick = dp[index-1][target - num[index]];
                dp[index][target] = pick + notPick;
            }
        }

        return dp[n-1][tar];
    }

    public static int findWaysTabulationSpaceOptimization(int num[], int tar) {
        int n = num.length;

        int[] prev = new int[tar+1];
        prev[0] = 1;

        if (num[0] <= tar)
            prev[num[0]] = 1;

        for (int index = 1; index < n; index++) {
            int[] temp = new int[tar+1];
            temp[0] = 1;
            for (int target = 1; target <= tar; target++) {
                int notPick = prev[target];
                int pick = 0;
                if (num[index] <= target)
                    pick = prev[target - num[index]];
                temp[target] = pick + notPick;
            }
            prev = temp;
        }

        return prev[tar];
    }
}
