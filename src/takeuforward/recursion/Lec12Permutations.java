package takeuforward.recursion;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Lec12Permutations {
    public static void main(String[] args) {
        System.out.println(permutations(new int[]{1,2,3}));
    }

    public static List<List<Integer>> permutations(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];

        recursion(nums, new ArrayList<>(), ans, freq);

        return ans;
    }

    private static void recursion(int[] arr,
                                  List<Integer> ds,
                                  List<List<Integer>> ans,
                                  boolean[] freq) {
        if (ds.size() == arr.length) {
            ans.add(List.copyOf(ds));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!freq[i]) {
                ds.add(arr[i]);
                freq[i] = true;
                recursion(arr, ds, ans, freq);
                freq[i] = false;
                ds.remove(ds.size() - 1);
            }
        }


    }


}
