package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class HouseRobber {

    public static void main(String[] args) {
        System.out.println(robRecursive(new int[] {1,2,3,1}));


    }

    // recursion top down - start from end of nums - with cache Map
    public static int robRecursive(int[] nums) {
        Integer[] cache = new Integer[nums.length];
        return recursion(nums, nums.length - 1, cache);
    }

    private static int recursion(int[] nums, int lastHouse, Integer[] cache) {
        if (lastHouse < 0) return 0;
        if (cache[lastHouse] != null) return cache[lastHouse];
        return cache[lastHouse] = Math.max(nums[lastHouse] + recursion(nums,lastHouse - 2, cache), recursion(nums, lastHouse - 1, cache));

    }

    // recursion top down - start from end of nums - with cache Map
    public static int robRecursive2(int[] nums) {
        Map<Integer, Integer> cache = new HashMap<>();
        return recursion2(nums, nums.length - 1, cache);
    }

    private static int recursion2(int[] nums, int lastHouse, Map<Integer, Integer> cache) {
        if (lastHouse < 0) return 0;
        if (cache.containsKey(lastHouse)) return cache.get(lastHouse);
        int result = Math.max(nums[lastHouse] + recursion2(nums,lastHouse - 2, cache), recursion2(nums, lastHouse - 1, cache));
        cache.put(lastHouse, result);
        return result;
    }


    // recursion top down - start from end of nums
    public static int robRecursive1(int[] nums) {
        return recursion1(nums, nums.length - 1);
    }

    private static int recursion1(int[] nums, int lastHouse) {
        if (lastHouse < 0) return 0;
        return Math.max(nums[lastHouse] + recursion1(nums,lastHouse - 2), recursion1(nums, lastHouse - 1));
    }


    // db
    public static int rob(int[] nums) {
        int rob1 = 0;
        int rob2 = 0;

        // [rob1, rob2, n, n + 1, ...]
        for (int n : nums) {
            int temp = Math.max(rob1 + n, rob2);
            rob1 = rob2;
            rob2 = temp;
        }

        return rob2;
    }
}
