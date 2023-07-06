package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2,3,6,7}, 7));
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        recursion(candidates, target, ans, cur, 0, 0);
        return ans;
    }

    private static void recursion(int[] candidates, int target, List<List<Integer>> ans, List<Integer> cur,
                                  int index, int sum) {
        if (sum == target)
            ans.add(List.copyOf(cur));
        else if (sum < target) {
            for (int i = index; i < candidates.length; i++) {
                cur.add(candidates[i]);
                recursion(candidates, target, ans, cur, i, sum + candidates[i]);
                cur.remove(cur.size() - 1);
            }
        }
    }

    public static List<List<Integer>> combinationSum1(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        recursion1(0, candidates, target, ans, new ArrayList<>());

        return ans;
    }

    private static void recursion1(int index,
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
            recursion1(index, candidates, remainTarget - candidates[index], ans, ds);
            ds.remove(ds.size() - 1);
        }
        recursion1(index + 1, candidates, remainTarget, ans, new ArrayList<>());

    }


}
