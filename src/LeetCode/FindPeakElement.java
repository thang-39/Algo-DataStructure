package LeetCode;

import java.util.Arrays;

public class FindPeakElement {
    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{2,1}));
        System.out.println(findPeakElement(new int[]{1,2,3,1}));
    }

    // binary
    public static int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        if (nums[0] > nums[1]) return 0;
        if (nums[nums.length - 1] > nums[nums.length - 2]) return nums.length-1;

        int low = 1 , high = nums.length - 2;
        while ( low <= high ) {
            int mid = (high + low) / 2;

            if (nums[mid] > nums[mid -1] && nums[mid] > nums[mid+1]) {
                return mid;
            } else if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            } else high = mid-1;
        }
        return -1;
    }


    // normal
    public static int findPeakElement1(int[] nums) {

        for (int i = 1; i < nums.length -1; i++) {

            if (nums[i] > nums[i-1] && nums[i] > nums[i+1]) {
                return i;
            }
        }

        if (nums.length > 1 && nums[0] > nums[1]) return 0;

        if (nums.length > 1 && nums[nums.length - 1] > nums[nums.length - 2]) return nums.length-1;

        return 0;
    }
}
