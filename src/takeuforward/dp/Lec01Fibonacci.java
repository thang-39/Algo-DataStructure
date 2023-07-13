package takeuforward.dp;

public class Lec01Fibonacci {

    public static void main(String[] args) {
        System.out.println(fibonacci(2));
        System.out.println(fibonacciTabulation(3));
    }

    public static int fibonacci(int n) {
        int[] dp = new int[n+1];
        return recursion(n, dp);
    }

    private static int recursion(int n, int[] dp) {
        if (n <= 1) return n;
        if (dp[n] != 0) return dp[n];
        return dp[n] = recursion(n-1, dp) + recursion(n-2, dp);
    }

    public static int fibonacciTabulation(int n) {
        if (n==0) return 0;
        int prev2 = 0;
        int prev = 1;
        for (int i = 2; i <= n; i++) {
            int current = prev + prev2;
            prev2 = prev;
            prev = current;
        }
        return prev;

    }
}
