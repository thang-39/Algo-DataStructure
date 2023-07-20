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

        System.out.println(gainMaxValueTabulation(List.of(1),2));
        System.out.println(gainMaxValueTabulation(List.of(2,-3,4,6,1),2));
        System.out.println(gainMaxValueTabulation(List.of(2,5,-8,-6,-7),3));

        System.out.println(gainMaxValue2(List.of(1),2));
        System.out.println(gainMaxValue2(List.of(2,-3,4,6,1),2));
        System.out.println(gainMaxValue2(List.of(2,5,-8,-6,-7),3));


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

    public static int gainMaxValueTabulation(List<Integer>  security, int k) {
        int n = security.size();
        int[] dp = new int[n];
        dp[n-1] = security.get(n-1);

        for (int i = n-1; i >= 0 ; i--) {
            if (i + k >= n) dp[i] = security.get(i);
            else dp[i] = dp[i+k] + security.get(i);
        }

        return Arrays.stream(dp).max().getAsInt();
    }

    public static int gainMaxValue2(List<Integer> security, int k) {
        if(security.size() == 1) {
            return security.get(0);
        }
        int[] gain = new int[security.size()];
        gain[0] = security.get(0);
        gain[1] = Math.max(security.get(0), security.get(1));
        for(int i = 2;  i <= security.size()-1 ; i++) {
            if( i-k < 0) {
                gain[i] = security.get(i);
            } else {
                gain[i] = Math.max(gain[i-k] + security.get(i), security.get(i));
            }
        }
        return gain[gain.length-1];
    }
}
