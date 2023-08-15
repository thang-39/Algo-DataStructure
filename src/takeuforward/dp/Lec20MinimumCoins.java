package takeuforward.dp;
// https://www.codingninjas.com/studio/problems/minimum-coins_982764
public class Lec20MinimumCoins {

    public static void main(String[] args) {
        System.out.println(minimumCoins(3));
        System.out.println(minimumCoins(60));
        System.out.println(minimumCoins(10));
        System.out.println(minimumCoins(24));
        System.out.println();
        System.out.println(minimumCoinsMemorization(3));
        System.out.println(minimumCoinsMemorization(60));
        System.out.println(minimumCoinsMemorization(10));
        System.out.println(minimumCoinsMemorization(24));
        System.out.println();
        System.out.println(minimumCoinsTabulation(3));
        System.out.println(minimumCoinsTabulation(60));
        System.out.println(minimumCoinsTabulation(10));
        System.out.println(minimumCoinsTabulation(24));
        System.out.println();
        System.out.println(minimumCoinsTabulationSpaceOptimization(3));
        System.out.println(minimumCoinsTabulationSpaceOptimization(60));
        System.out.println(minimumCoinsTabulationSpaceOptimization(10));
        System.out.println(minimumCoinsTabulationSpaceOptimization(24));
    }

    public static int minimumCoins(int p){
        int[] arr = {1,2,5,10,20,50,100,500,1000};
        int n = arr.length;
        return recursion(n-1, p, arr);
    }

    private static int recursion(int index, int target, int[] arr) {
        if (index == 0) {
            if (target % arr[index] == 0) return target/arr[index];
            return (int) 1e9;
        }

        int notTake = recursion(index-1, target, arr);

        int take = (int) 1e9;
        if (arr[index] <= target) {
            take = 1 + recursion(index,target-arr[index],arr);
        }
        return Math.min(notTake, take);
    }

    public static int minimumCoinsMemorization(int p){
        int[] arr = {1,2,5,10,20,50,100,500,1000};
        int n = arr.length;

        int[][] dp = new int[n][p+1];
        return recursionMemorization(n-1, p, arr, dp);
    }

    private static int recursionMemorization(int index, int target, int[] arr, int[][] dp) {
        if (index == 0) {
            if (target % arr[index] == 0) return target/arr[index];
            return (int) 1e9;
        }

        if (dp[index][target] != 0) return dp[index][target];

        int notTake = recursionMemorization(index-1, target, arr, dp);

        int take = (int) 1e9;
        if (arr[index] <= target) {
            take = 1 + recursionMemorization(index,target-arr[index],arr, dp);
        }
        return dp[index][target] = Math.min(notTake, take);
    }

    public static int minimumCoinsTabulation(int p){
        int[] arr = {1,2,5,10,20,50,100,500,1000};
        int n = arr.length;
        int[][] dp = new int[n][p+1];
        for (int target = 0; target <= p; target++) {
            if (target % arr[0] == 0) dp[0][target] = target/arr[0];
            else dp[0][target] = (int) 1e9;
        }

        for (int index = 1; index < n; index++) {
            for (int target = 0; target <= p; target++) {
                int notTake = dp[index-1][target];

                int take = (int) 1e9;
                if (arr[index] <= target) {
                    take = 1 + dp[index][target-arr[index]];
                }
                dp[index][target] = Math.min(notTake, take);
            }

        }
        return dp[n-1][p];
    }

    public static int minimumCoinsTabulationSpaceOptimization(int p){
        int[] arr = {1,2,5,10,20,50,100,500,1000};
        int n = arr.length;
        int[] prev = new int[p+1];
        for (int target = 0; target <= p; target++) {
            if (target % arr[0] == 0) prev[target] = target/arr[0];
            else prev[target] = (int) 1e9;
        }

        for (int index = 1; index < n; index++) {
            int[] cur = new int[p+1];
            for (int target = 0; target <= p; target++) {
                int notTake = prev[target];

                int take = (int) 1e9;
                if (arr[index] <= target) {
                    take = 1 + cur[target-arr[index]];
                }
                cur[target] = Math.min(notTake, take);
            }
            prev = cur;
        }
        return prev[p];
    }
}
