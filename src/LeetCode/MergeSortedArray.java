package LeetCode;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        merge(new int[]{1,2,3,0,0,0},3,new int[]{2,5,6},3);
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = 0;
        for (int i = m; i < (m+n); i++) {
            nums1[i] = nums2[index];
            index++;
        }
        Arrays.sort(nums1);
    }
}
