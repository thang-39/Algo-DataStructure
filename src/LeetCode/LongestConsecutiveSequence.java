package LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums1 = {100,4,200,1,3,2};
        int[] nums2 = {0,3,7,2,5,8,4,6,0,1};
        int[] nums3 = {0};
        int[] nums4 = {1,2,0,1};
//        System.out.println(longestConsecutive(nums1));
        System.out.println(longestConsecutive(nums4));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        Arrays.sort(nums);

        int prev = nums[0];
        int dem = 1;
        int cur = 1;

        for (int i = 1 ; i < nums.length; i++) {
            if (nums[i] == prev + 1) {
                cur++;
            } else if (prev != nums[i]) {
                cur = 1;
            }
            prev = nums[i];
            cur = Math.max(cur ,dem);
        }
        return dem;
    }

    public static int longestConsecutive1(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int[] sortedArray = Arrays.stream(nums).sorted().toArray();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < sortedArray.length - 1; i++) {
            map.put(sortedArray[i], 1);
            int temp = sortedArray[i];
            while (sortedArray[i +1] == sortedArray[i] + 1 || sortedArray[i +1] == sortedArray[i]) {
                if (sortedArray[i +1] == sortedArray[i] + 1) {
                    map.put(temp, map.get(temp) +1);
                    i++;
                } else {
                    i++;
                }
                if (i == sortedArray.length-1) {
                    break;
                }
            }
        }
        System.out.println(map);
        return map.values().stream().max(Comparator.naturalOrder()).get();

    }
}
