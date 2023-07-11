package takeuforward.recursion.leetcode;

import java.util.*;

public class CombinationSumThang {

    public static void main(String[] args) {
        int[] arr = new int[]{ 2,3,6,7};
        int[] arr1 = new int[]{10,1,2,7,6,1,5};
        int[] arr2 = new int[]{2,5,2,1,2};
//        System.out.println(combinationSum(arr,7));
        System.out.println(combinationSumII(arr1,8));
        System.out.println(combinationSumII(arr2,5));
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> sequence = new ArrayList<>();

        recursion(candidates, target, 0, 0, result, sequence);
        return result;
    }



    public static void recursion(int[] arr, int target, int index,
                                 int sum, List<List<Integer>> result,
                                 List<Integer> sequence) {

        if (sum == target) {
            result.add(new ArrayList<>(sequence));
        } else if (sum < target) {
            for (int i = index; i < arr.length; i++) {
                sequence.add(arr[i]);

                recursion(arr, target, i, sum + arr[i], result, sequence);

                sequence.remove(sequence.size()-1);
            }
        }
    }

    public static List<List<Integer>> combinationSumII(int[] candidates, int target) {

        Set<List<Integer>> result = new HashSet<>();
        List<Integer> sequence = new ArrayList<>();

        recursionII(candidates, target, 0, 0, result, sequence);
        return result.stream().toList();
    }

    public static void recursionII(int[] arr, int target, int index,
                                 int sum, Set<List<Integer>> result,
                                 List<Integer> sequence) {

        if (sum > target) return;

        if (sum == target) {
            List<Integer> rightSet = new ArrayList<>(sequence);
            rightSet.sort(Comparator.naturalOrder());
            result.add(new ArrayList<>(rightSet));
        }

        if( index >= arr.length) return;

        sequence.add(arr[index]);

        recursionII(arr, target, index+1, sum + arr[index], result, sequence);

        sequence.remove(sequence.size()-1);

        recursionII(arr, target, index+1, sum, result, sequence);
    }



}
