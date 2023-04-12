package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveElement {

    public static void main(String[] args) {
        removeElement(new int[]{0,1,2,2,3,0,4,2},2);
    }

    public static int removeElement(int[] nums, int val) {
        int p = 0;
        for (int i : nums) {
            if (i != val) {
                nums[p] = i;
                p++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return p;
    }
    public static int removeElement2(int[] nums, int val) {
        int p = 0, i = 0;
        while(i < nums.length){
            if(nums[i++] != val){
                nums[p++] = nums[i-1];
            }
        }
        System.out.println(Arrays.toString(nums));
        return p;
    }

    public static int removeElement1(int[] nums, int val) {
        int track = 0;
        for (int num : nums) {
            if (num != val) {
                nums[track] = val;
                track++;
            }
        }
        return track;
    }

    public static int removeElement10(int[] nums, int val) {
        List<Integer> keepIndexes = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val)  keepIndexes.add(i);
        }

        for (int i = 0; i < keepIndexes.size(); i++) {
            nums[i] = nums[keepIndexes.get(i)];
        }
        System.out.println(keepIndexes.size() + ", " + Arrays.toString(nums));
        return keepIndexes.size();
    }
}
