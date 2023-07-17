package hackerRank;

import java.util.Arrays;
import java.util.List;

public class Q3Mot {
    public static void main(String[] args) {
        System.out.println(gainMaxValueGPTRecursion(List.of(2,-3,4,6,1),2));
        System.out.println(gainMaxValueGPTRecursion(List.of(2,5,-8,-6,-7),3));
        System.out.println(gainMaxValueGPTRecursion(List.of(1),2));
    }
    public static int gainMaxValueGPTRecursion(List<Integer> security, int k) {
        int index = security.size() -1;
        int[] dp = new int[index+1];
        dp[index] = security.get(index);
        return recursionJump(index,security,k, dp);
    }



    public static int recursionJump(int index, List<Integer> arr, int k, int[] dp) {

        for (int i = index; i >= 0; i--) {
            if (i+k >= arr.size()) {
                dp[i] = arr.get(i);

            } else {
                dp[i] = dp[i+k] + arr.get(i);

            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
