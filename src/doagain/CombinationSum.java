package doagain;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2,3,6,7},7));
    }

    public static List<List<Integer>> combinationSum(int[] candidates,
                                              int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();

        recursion(0,0,candidates,target,ans,ds);
        return ans;
    }

    private static void recursion(int index, int sum, int[] candidates, int target,
                           List<List<Integer>> ans, List<Integer> ds) {

        if (sum == target) {
            ans.add(List.copyOf(ds));
            return;
        }

        if (index >= candidates.length)
            return;

        if (sum + candidates[index] <= target) {
            ds.add(candidates[index]);
            recursion(index,sum+candidates[index],candidates,target,ans,ds);
            ds.remove(ds.size()-1);
        }
        recursion(index+1,sum,candidates,target,ans,ds);
    }
}
