package hackerRank;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Q3MaxSercurityValueWithKJump {
    public static void main(String[] args) {
        System.out.println(gainMaxValue(List.of(1),2));
        System.out.println(gainMaxValue(List.of(2,-3,4,6,1),2));
        System.out.println(gainMaxValue(List.of(2,5,-8,-6,-7),3));

        System.out.println(gainMaxValueMemorization(List.of(1),2));
        System.out.println(gainMaxValueMemorization(List.of(2,-3,4,6,1),2));
        System.out.println(gainMaxValueMemorization(List.of(2,5,-8,-6,-7),3));


    }

    public static int gainMaxValue(List<Integer>  security, int k) {
        int n = security.size();

        int result = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int jumpK = recursion(i, k, security);
            result = Math.max(result,jumpK);
        }
        return result;
    }

    private static int recursion(int index, int k, List<Integer>  security) {
        if (index >= security.size()) return 0;
        return security.get(index) + recursion(index+k, k, security);
    }

    public static int gainMaxValueMemorization(List<Integer>  security, int k) {
        int n = security.size();

        int result = Integer.MIN_VALUE;

        int[] dp = new int[n];
        Arrays.fill(dp,Integer.MIN_VALUE);

        for (int i = 0; i < n; i++) {
            int jumpK = recursionMemorization(i, k, security, dp);
            result = Math.max(result,jumpK);
        }

        return result;
    }

    private static int recursionMemorization(int index, int k, List<Integer>  security, int[] dp) {
        if (index >= security.size()) return 0;
        if (dp[index] != Integer.MIN_VALUE) return dp[index];
        return dp[index] = security.get(index) + recursionMemorization(index+k, k, security, dp);
    }


}
