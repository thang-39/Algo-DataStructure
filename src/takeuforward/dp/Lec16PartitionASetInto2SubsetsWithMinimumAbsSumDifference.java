package takeuforward.dp;

public class Lec16PartitionASetInto2SubsetsWithMinimumAbsSumDifference {

    public static void main(String[] args) {
        System.out.println(minSubsetSumDifference(new int[]{1,2,3,4}, 4));
        System.out.println(minSubsetSumDifference(new int[]{1,2,3}, 3));
        System.out.println(minSubsetSumDifference(new int[]{3,1,5,2,8}, 5));
        System.out.println(minSubsetSumDifference(new int[]{8,6,5}, 3));

        System.out.println(minSubsetSumDifferenceSpaceOptimization(new int[]{1,2,3,4}, 4));
        System.out.println(minSubsetSumDifferenceSpaceOptimization(new int[]{1,2,3}, 3));
        System.out.println(minSubsetSumDifferenceSpaceOptimization(new int[]{3,1,5,2,8}, 5));
        System.out.println(minSubsetSumDifferenceSpaceOptimization(new int[]{8,6,5}, 3));
        System.out.println(minSubsetSumDifferenceSpaceOptimization(new int[]{13, 4, 3, 11, 7, 12, 8}, 7));
    }
    
    public static int minSubsetSumDifference(int[] arr, int n) {
        int totalSum = 0;
        for (int i : arr) {
            totalSum += i;
        }

        boolean[][] dp = new boolean[n][totalSum+1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        if (arr[0] <= totalSum) dp[0][arr[0]] = true;

        for (int row = 1; row < n; row++) {
            for (int target = 1; target <= totalSum; target++) {
                boolean notTake = dp[row-1][target];

                boolean take = false;
                if (arr[row] <= target) {
                    take = dp[row-1][target - arr[row]];
                }

                dp[row][target] = take | notTake;
            }
        }

        int min = (int) 1e9;
        for (int i = 0; i <= totalSum/2; i++) {
            if (dp[n-1][i]) {
                min = Math.min(min, Math.abs(totalSum - i - i));
            }
        }
        return min;
    }

    public static int minSubsetSumDifferenceSpaceOptimization(int[] arr, int n) {
        int totalSum = 0;
        for (int i : arr) {
            totalSum += i;
        }

        boolean[] dp = new boolean[totalSum+1];
        dp[0] = true;

        if (arr[0] <= totalSum) dp[arr[0]] = true;

        for (int row = 1; row < n; row++) {
            boolean[] temp = new boolean[totalSum+1];
            for (int target = 1; target <= totalSum; target++) {
                boolean notTake = dp[target];

                boolean take = false;
                if (arr[row] <= target) {
                    take = dp[target - arr[row]];
                }

                temp[target] = take | notTake;
            }
            dp = temp;
        }

        int min = (int) 1e9;
        for (int i = 0; i <= totalSum/2; i++) {
            if (dp[i]) {
                min = Math.min(min, Math.abs(totalSum - i - i));
            }
        }
        return min;
    }
}
