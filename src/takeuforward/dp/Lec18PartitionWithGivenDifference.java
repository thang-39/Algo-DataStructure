package takeuforward.dp;
//https://www.codingninjas.com/studio/problems/partitions-with-given-difference_3751628
public class Lec18PartitionWithGivenDifference {

    public static void main(String[] args) {

    }

    public static int countPartitions(int n, int d, int[] arr) {
        int totalSum = 0;
        for (int j : arr)
            totalSum += j;

        if (totalSum - d < 0 || (totalSum - d) % 2 != 0) return 0;
        return recursion0(n-1,(totalSum - d) / 2, arr);
    }


    private static int recursion0(int index, int tar, int[] num) {

        if (index == 0) {
            if (tar == 0 && num[index] == 0) return 2; // pick and non-pick 0
            if (tar == 0 || num[0] == tar) return 1;
            return 0;
        }

        int notPick = recursion0(index-1,tar,num);
        int pick = 0;
        if (num[index] <= tar) {
            pick = recursion0(index-1,tar-num[index],num);
        }

        return (pick + notPick) % ((int) 1e9 + 7);
    }

    public static int countPartitionsTabulation(int n, int d, int[] arr) {
        int totalSum = 0;
        for (int j : arr)
            totalSum += j;

        if (totalSum - d < 0 || (totalSum - d) % 2 != 0) return 0;

        return findWaysTabulation(arr, (totalSum - d) / 2);
    }

    public static int findWaysTabulation(int num[], int tar) {
        int n = num.length;
        int[][] dp = new int[n][tar+1];

        // create the base case
        if (num[0] == 0) dp[0][0] = 2;
        else dp[0][0] = 1;

        // num[0] = 0 - it will wrong
        if (num[0] != 0 && num[0] <= tar)
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

}
