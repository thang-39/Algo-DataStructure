package takeuforward.recursion.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubsetSums {
    public static void main(String[] args) {

        int[] arr = new int[]{2,3};
        int[] arr1 = new int[]{5, 2, 1};
        int[] arr2 = new int[]{3, 2, 1};
        System.out.println(subsetSums(arr, 2));
        System.out.println(subsetSums(arr1, 3));
        System.out.println(subsetSums(arr2, 3));
    }

    public static List<Integer> subsetSums(int[] arr, int N) {
        Set<Integer> ans = new HashSet<>();
        recursion(0, arr, ans, 0);
        return ans.stream().toList();
    }

    private static void recursion(int index, int[] arr, Set<Integer> ans, int sum) {
        if (index >= arr.length) {
            ans.add(sum);
            return;
        }
        recursion(index+1,arr,ans,sum + arr[index]);
        recursion(index+1,arr,ans,sum);

    }

    public static List<Integer> subsetSums1(int[] arr, int N) {
        Set<Integer> ans = new HashSet<>();

        recursion1(0, arr, ans, new ArrayList<>());
        return ans.stream().toList();
    }

    private static void recursion1(int index, int[] arr,
                                  Set<Integer> ans, List<Integer> ds) {
        if (index >= arr.length) {
            ans.add(ds.stream().reduce(0,(Integer::sum)));
            return;
        }

        ds.add(arr[index]);
        recursion1(index + 1, arr, ans, ds);
        ds.remove(ds.size()-1);
        recursion1(index+1, arr,ans,ds);
    }
}
