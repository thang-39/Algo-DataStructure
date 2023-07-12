package takeuforward.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lec013Permutations2Approach {
    public static void main(String[] args) {
        System.out.println(permutations(new int[]{1,2,3}));
    }

    public static List<List<Integer>> permutations(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        recursion(0,nums,ans);
        return ans;
    }

    private static void recursion(int index, int[] nums,
                                  List<List<Integer>> ans) {
        if (index == nums.length) {
            ans.add(Arrays.stream(nums).boxed().toList());
            return;
        }

        for (int i = index; i < nums.length; i++) {
            swap(i, index, nums);
            recursion(index+1, nums, ans);
            swap(i, index, nums);
        }
    }

    private static void swap(int i, int index, int[] nums) {
        int t = nums[i];
        nums[i] = nums[index];
        nums[index] = t;
    }
}
