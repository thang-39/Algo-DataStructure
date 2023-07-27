package takeuforward.dp;

import java.util.Arrays;

public class Lec14SubsetSumEqualToK {
    public static void main(String[] args) {
        System.out.println(subsetSumToK(4,5, new int[]{4,3,2,1}));
        System.out.println(subsetSumToK(5,4, new int[]{2,5,1,6,7}));

        System.out.println(subsetSumToKMemorization(4,5, new int[]{4,3,2,1}));
        System.out.println(subsetSumToKMemorization(5,4, new int[]{2,5,1,6,7}));

        System.out.println(subsetSumToKTabulation(4,5, new int[]{4,3,2,1}));
        System.out.println(subsetSumToKTabulation(5,4, new int[]{2,5,1,6,7}));

        System.out.println(subsetSumToKTabulationSpaceOptimization(4,5, new int[]{4,3,2,1}));
        System.out.println(subsetSumToKTabulationSpaceOptimization(5,4, new int[]{2,5,1,6,7}));

    }

    public static boolean subsetSumToK(int n, int k, int arr[]){
        return recursion(n-1,k,arr);
    }

    private static boolean recursion(int index, int target, int[] arr) {
        if (target == 0) return true;
        if (index == 0) return arr[0] == target;

        boolean notTake = recursion(index-1,target,arr);

        boolean take = false;
        if (arr[index] <= target) {
            take = recursion(index-1,target-arr[index],arr);
        }

        return take || notTake;
    }

    private static boolean recursionThang(int index, int target, int[] arr) {
        if (target == 0) return true;
        if (index < 0) return false;
        if (target < 0) return false;

        boolean take = recursion(index-1,target-arr[index],arr);
        boolean notTake = recursion(index-1,target,arr);

        return take || notTake;
    }

    public static boolean subsetSumToKMemorization(int n, int k, int arr[]){
        int[][] dp = new int[n][k+1];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }

        return recursion(n-1,k,arr,dp);
    }

    private static boolean recursion(int index, int target, int[] arr, int[][] dp) {
        if (target == 0) return true;
        if (index == 0) return arr[0] == target;
        if (dp[index][target] != -1) {
            return dp[index][target] == 1;
        }

        boolean notTake = recursion(index-1,target,arr,dp);

        boolean take = false;
        if (arr[index] <= target) {
            take = recursion(index-1,target-arr[index],arr,dp);
        }

        if (take || notTake) dp[index][target] = 1;
        else dp[index][target] = 0;

        return take || notTake;
    }

    public static boolean subsetSumToKTabulation(int n, int k, int arr[]){
        boolean[][] dp = new boolean[n][k+1];

        // for every index - target = 0 -> dp[i][0] = true
        // (always true) - what are you looking for???
        for (int i = 0; i < n; i++) dp[i][0] = true;

        if (arr[0] <= k)
            dp[0][arr[0]] = true;

        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= k; target++) {
                boolean notTake = dp[ind-1][target];

                boolean take = false;
                if (arr[ind] <= target) {
                    take = dp[ind-1][target-arr[ind]];
                }
                dp[ind][target] = take || notTake;
            }

        }
        return dp[n-1][k];
    }

    public static boolean subsetSumToKTabulationSpaceOptimization(int n, int k, int arr[]){
        boolean[] dp = new boolean[k+1];

        // for every index - target = 0 -> dp[i][0] = true
        // (always true) - what are you looking for???
        dp[0] = true;

        if (arr[0] <= k)
            dp[arr[0]] = true;

        for (int ind = 1; ind < n; ind++) {
            boolean[] temp = new boolean[k+1];
//            temp[0] = true;
            for (int target = 1; target <= k; target++) {
                boolean notTake = dp[target];

                boolean take = false;
                if (arr[ind] <= target) {
                    take = dp[target-arr[ind]];
                }
                temp[target] = take || notTake;
            }
            dp = temp;

        }
        return dp[k];
    }
}

