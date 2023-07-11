package takeuforward.recursion.leetcode;

import java.util.*;

public class CombinationSumII {
    public static void main(String[] args) {
        int[] arr1 = new int[]{10,1,2,7,6,1,5};
        int[] arr2 = new int[]{2,5,2,1,2};
        int[] arr3 = new int[]{14,6,25,9,30,20,33,34,28,30,16,12,31,9,9,12,34,16,25,32,8,7,30,12,33,20,21,29,24,17,27,34,11,17,30,6,32,21,27,17,16,8,24,12,12,28,11,33,10,32,22,13,34,18,12};
        int[] arr4 = new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        int[] arr5 = new int[]{1,2};
        System.out.println(combinationSum2(arr1,8));
        System.out.println(combinationSum2(arr2,5));
        System.out.println(combinationSum2(arr3,27));
        System.out.println(combinationSum2(arr4,30));
        System.out.println(combinationSum2(arr5,4));
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> ans = new HashSet<>();
        Arrays.sort(candidates);
        recursion(0, candidates, target, ans, new ArrayList<>());
        return ans.stream().toList();
    }

    private static void recursion(int index, int[] arr, int target,
                                  Set<List<Integer>> ans,
                                  List<Integer> ds) {
        if (target == 0) {
            List<Integer> temp = new ArrayList<>(ds);
            temp.sort(Comparator.naturalOrder());
            ans.add(temp);
            return;
        }

        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i-1])
                continue;
            if (arr[i] > target)
                break;

            ds.add(arr[i]);
            recursion(i + 1, arr, target - arr[i], ans, ds);
            ds.remove(ds.size()-1);
        }
    }
}
