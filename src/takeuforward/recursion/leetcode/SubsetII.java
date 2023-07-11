package takeuforward.recursion.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetII {
    public static void main(String[] args) {
        System.out.println(subset2(new int[]{1,2,2,2,3,3}));

    }

    public static List<List<Integer>> subset2(int[] candidates) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        recursion(0, candidates, ans, new ArrayList<>());
        return ans;
    }

    private static void recursion(int index, int[] arr,
                                  List<List<Integer>> ans,
                                  List<Integer> ds) {
        ans.add(List.copyOf(ds));

        for (int i = index; i < arr.length; i++) {
            if (i != index && arr[i] == arr[i-1]) // điều kiện giống với bài combinationSum II
                continue;
            ds.add(arr[i]);
//            ans.add(List.copyOf(ds)); // nếu để ở đây thì sẽ ko có phần tử rỗng
            recursion(i + 1,arr, ans, ds);
            ds.remove(ds.size()-1);
        }
    }


}
