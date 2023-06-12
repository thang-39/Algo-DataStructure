package YoutubeMockInterview;

import java.util.*;
import java.util.stream.Collectors;

// https://www.youtube.com/watch?v=XyWtipeJkFE&t=992s
// https://leetcode.com/problems/median-of-two-sorted-arrays/
/* Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106

 */
public class FindMedianSortedArray {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,3}, new int[]{2}));
        System.out.println(findMedianSortedArrays(new int[]{1,1}, new int[]{1,2}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergeArray = new int[nums1.length + nums2.length];
        
        int index = 0;
        int i = 0;
        int j = 0;

        // this while loop run until 1 of input array is empty
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                mergeArray[index] = nums1[i];
                index++;
                i++;
            } else {
                mergeArray[index] = nums2[j];
                index++;
                j++;
            }
        }

        while (i < nums1.length) {
            mergeArray[index] = nums1[i];
            index++;
            i++;
        }

        while (j < nums2.length) {
            mergeArray[index] = nums2[j];
            index++;
            j++;
        }
        if (mergeArray.length % 2 == 0) {
            return (float) (mergeArray[mergeArray.length / 2] + mergeArray[mergeArray.length/2-1])/2;
        } else return (float) mergeArray[mergeArray.length/2];
    }
    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        List<Integer> mergeList = new ArrayList<>();

        for (int m : nums1) {
            mergeList.add(m);
        }

        for (int n : nums2) {
            mergeList.add(n);
        }

        mergeList.sort(Comparator.naturalOrder());

        System.out.println(mergeList);

        if (mergeList.size() % 2 == 0) {
            return (float) (mergeList.get(mergeList.size() / 2) + mergeList.get(mergeList.size()/2-1))/2;
        } else return (float) mergeList.get(mergeList.size()/2);
    }
}
