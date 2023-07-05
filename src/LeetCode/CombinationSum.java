package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2,3,6,7}, 7));
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        recursion(0, candidates, target, ans, new ArrayList<>());

        return ans;
    }

    private static void recursion(int index,
                           int[] candidates,
                           int remainTarget,
                           List<List<Integer>> ans,
                           List<Integer> ds) {

        if (index == candidates.length) {
            if (remainTarget == 0)
                ans.add(new ArrayList<>(ds));
            return;
        }

        if (candidates[index] <= remainTarget) {
            ds.add(candidates[index]);
            recursion(index, candidates, remainTarget - candidates[index], ans, ds);
            ds.remove(ds.size() - 1);
        }
        recursion(index + 1, candidates, remainTarget, ans, new ArrayList<>());

    }


}
