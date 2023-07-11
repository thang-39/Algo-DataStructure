package takeuforward.recursion.leetcode;

import java.util.*;

public class CombinationSumIIThang {
    public static void main(String[] args) {
        int[] arr1 = new int[]{10,1,2,7,6,1,5};
        int[] arr2 = new int[]{2,5,2,1,2};
        int[] arr3 = new int[]{14,6,25,9,30,20,33,34,28,30,16,12,31,9,9,12,34,16,25,32,8,7,30,12,33,20,21,29,24,17,27,34,11,17,30,6,32,21,27,17,16,8,24,12,12,28,11,33,10,32,22,13,34,18,12};
        int[] arr4 = new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        System.out.println(combinationSumIIFail(arr1,8));
        System.out.println(combinationSumIIFail(arr2,5));
        System.out.println(combinationSumIIFail(arr3,27));
        System.out.println(combinationSumIIFail(arr4,30));
    }

    // false because Time out - need to optimize
    public static List<List<Integer>> combinationSumIIFail(int[] candidates, int target) {

        Set<List<Integer>> result = new HashSet<>();
        List<Integer> sequence = new ArrayList<>();

        recursionIIFail(candidates, target, 0, result, sequence);
        return result.stream().toList();
    }

    public static void recursionIIFail(int[] arr, int target, int index,
                                   Set<List<Integer>> result,
                                   List<Integer> sequence) {

        if (index >= arr.length) {
            if (target == 0) {
                List<Integer> rightSet = new ArrayList<>(sequence);
                rightSet.sort(Comparator.naturalOrder());
                result.add(new ArrayList<>(rightSet));
            }
            return;
        }

        if (arr[index] <= target) {
            sequence.add(arr[index]);

            recursionIIFail(arr, target - arr[index], index+1, result, sequence);

            sequence.remove(sequence.size()-1);
        }

        recursionIIFail(arr, target, index+1, result, sequence);
    }
}
