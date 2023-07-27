package takeuforward.dp;

import java.util.Arrays;

//https://www.codingninjas.com/studio/problems/partition-equal-subset-sum-_892980
public class Lec15PartitionEqualSubsetSum {
    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{3,1,1,2,2,1},6));
        System.out.println(canPartition(new int[]{5,6,5,11,6},5));
    }

    public static boolean canPartition(int[] arr, int n) {
        int totalSum = 0;
        for (int i = 0; i < arr.length; i++) {
            totalSum += arr[i];
        }
        if (totalSum % 2 != 0) return false;
        else {
            return subsetSumToKTabulationSpaceOptimization(n,totalSum/2,arr);
        }
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
