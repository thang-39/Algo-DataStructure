package LeetCode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        removeDuplicates(new int[]{1,1,2});
        removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4});
    }

    public static int removeDuplicates(int[] nums) {

        int addindex = 1;

        for (int i=0; i< nums.length -1; i++) {
            if (nums[i] != nums[i+1]) {
                nums[addindex] = nums[i+1];
                addindex++;
            }
        }

        return addindex;
    }

    // this is not remove the duplicates in-place
    public static int removeDuplicates1(int[] nums) {
        List<Integer> expectedNums = new ArrayList<>();
        expectedNums.add(nums[0]);

        for (int i = 0; i < nums.length -1; i++) {
            if (nums[i] != nums[i+1]) {
                expectedNums.add(nums[i+1]);
            } else {
                if (!expectedNums.contains(nums[i])) {
                    expectedNums.add(nums[i]);
                } else if (!expectedNums.contains(nums[i+1])){
                    expectedNums.add(nums[i+1]);
                }
            }
        }
        System.out.println(expectedNums);
        return expectedNums.size();
    }

}
