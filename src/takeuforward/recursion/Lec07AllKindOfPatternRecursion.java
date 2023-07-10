package takeuforward.recursion;

import java.util.ArrayList;
import java.util.List;

public class Lec07AllKindOfPatternRecursion {

    public static void main(String[] args) {

        int[] arr = new int[]{1,2,1};
        printAllSubSum(arr, 0, 2, new ArrayList<>());
        print1SubSum(arr, 0, 2, new ArrayList<>());
        System.out.println(countSubSum(arr, 0, 2));
    }

    //  find subsequence with sum = N
    public static void printAllSubSum(int[] arr, int index, int remainingSum, List<Integer> subsequence) {
        if (index >= arr.length) {
            if (remainingSum == 0)
                System.out.println(subsequence);
            return;
        }

        subsequence.add(arr[index]);
        printAllSubSum(arr, index + 1, remainingSum - arr[index], subsequence);
        subsequence.remove(subsequence.size()-1);
        printAllSubSum(arr, index + 1, remainingSum, subsequence);
    }

    //  find only 1 subsequence with sum = N
    public static boolean print1SubSum(int[] arr, int index, int remainingSum, List<Integer> subsequence) {
        if (index >= arr.length) {
            if (remainingSum == 0) {
                System.out.println(subsequence);
                return true;
            }
            return false;
        }

        subsequence.add(arr[index]);
        if (print1SubSum(arr, index + 1, remainingSum - arr[index], subsequence))
            return true;
        subsequence.remove(subsequence.size()-1);
        if (print1SubSum(arr, index + 1, remainingSum, subsequence))
            return true;

        return false;
    }

    // count
    public static int countSubSum(int[] arr, int index, int remainingSum) {
        if (index >= arr.length) {
            if (remainingSum == 0) return 1;
            return 0;
        }

        int left = countSubSum(arr, index + 1, remainingSum - arr[index]);

        int right =countSubSum(arr, index + 1, remainingSum);

        return left  + right;
    }

    public static int countSubSumImprove(int[] arr, int index, int remainingSum) {

        // strictly done if array contains only positives
        if (remainingSum < 0) return 0;

        if (index >= arr.length) {
            if (remainingSum == 0) return 1;
            return 0;
        }

        int left = countSubSumImprove(arr, index + 1, remainingSum - arr[index]);

        int right =countSubSumImprove(arr, index + 1, remainingSum);

        return left  + right;
    }
}
