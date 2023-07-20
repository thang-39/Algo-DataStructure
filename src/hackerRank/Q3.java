package hackerRank;

import java.util.*;

public class Q3 {
    public static void main(String[] args) {

//        System.out.println(gainMaxValue(List.of(1), 2));
//        System.out.println(gainMaxValueThang(List.of(2, -3, 4, 6, 1), 2));
//        System.out.println(gainMaxValueThang(List.of(2, 5, -8, -6, -7), 3));
//        System.out.println(gainMaxValueThang(List.of(1), 3));


//        System.out.println(gainMaxValueGPTRecursion(List.of(2, 5, -8, -6, -7), 3));
//
//        System.out.println(gainMaxValueGPT(List.of(2, -3, 4, 6, 1), 2));
//        System.out.println(gainMaxValueGPTRecursion(List.of(2, -3, 4, 6, 1), 2));


        System.out.println(gainMaxValue2(List.of(2, 5, -8, -6, -7), 3));

        System.out.println(gainMaxValue2(List.of(2, -3, 4, 6, 1), 2));

        System.out.println(gainMaxValue2(List.of(1), 2));
    }

    public static int gainMaxValueGPTRecursion(List<Integer> security, int k) {
        return recursionJump(0, security, k);
    }

    public static int recursionJump(int index, List<Integer> arr, int k) {
        if (index >= arr.size()) {
            return 0;
        }
        int maxSum = Integer.MIN_VALUE;
        for (int i = index; i < Math.min(index + k, arr.size()); i++) {
            int sum = recursionJump(i + k, arr, k) + arr.get(i);
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    public static int gainMaxValueGPT(List<Integer> security, int k) {
        Map<Integer, Integer> memo = new HashMap<>();
        return memoizedRecursionJumpGPT(0, security, k, memo);
    }

    public static int memoizedRecursionJumpGPT(int index, List<Integer> arr, int k, Map<Integer, Integer> memo) {
        if (index >= arr.size()) {
            return 0;
        }
        if (memo.containsKey(index)) {
            return memo.get(index);
        }
        int maxSum = Integer.MIN_VALUE;
        for (int i = index; i < Math.min(index + k, arr.size()); i++) {
            int sum = memoizedRecursionJumpGPT(i + k, arr, k, memo) + arr.get(i);
            maxSum = Math.max(maxSum, sum);
        }
        memo.put(index, maxSum);
        return maxSum;
    }

    public static int maxJumpSum(List<Integer> arr, int k) {
        int n = arr.size();
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j += k) {
                sum += arr.get(j);
            }
            maxSum = Math.max(sum,maxSum);
        }
        return maxSum;
    }



    public static int gainMaxValueThang(List<Integer> security, int k) {

        List<Integer> sumList = new ArrayList<>();

        recursionJump(0, security, k, sumList);

        return Collections.max(sumList);
    }

    public static void recursionJump(int index, List<Integer> arr,
                                     int k, List<Integer>sumList) {
        if (index >= arr.size()) return;
        int sum = 0;
        for (int i = index; i < arr.size(); i += k) {
            sum += arr.get(i);
        }
        sumList.add(sum);
        recursionJump(index + 1, arr, k, sumList);
    }



    public static int gainMaxValue(List<Integer> security, int k) {
//        System.out.println(security);
//        System.out.println(k);

        if(security.size() == 1) {
            return security.get(0);
        }

        int start = 0;

        List<Integer> gain = new ArrayList<>();
        recursion(security, gain, k, start);

        return Collections.max(gain);
    }
    private static void recursion(List<Integer> security, List<Integer> gain, int k, int start) {
        int tong = 0;

        if(start >= security.size()) {
            return;
        }
        for(int i = start ;  i <= security.size()-1 ; i=i+k) {

            tong = tong + security.get(i);
        }

        gain.add(tong);
        recursion(security,gain, k, ++start);
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
