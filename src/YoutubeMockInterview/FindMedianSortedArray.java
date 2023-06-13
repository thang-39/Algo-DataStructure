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
        System.out.println(findMedianSortedArrays(new int[]{-2,-1}, new int[]{3}));
        System.out.println(findMedianSortedArrays(new int[]{1}, new int[]{2,3}));
        System.out.println(findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));
        System.out.println(findMedianSortedArrays(new int[]{1}, new int[]{2,3,4,5,6}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if (nums1.length == 0) {
            if (nums2.length % 2 == 0) {
                return (float) (nums2[nums2.length / 2] + nums2[nums2.length/2-1])/2;
            } else {
                return nums2[nums2.length / 2];
            }
        }

        if (nums2.length == 0) {
            if (nums1.length % 2 == 0) {
                return (float) (nums1[nums1.length / 2] + nums1[nums1.length/2-1])/2;
            } else {
                return nums1[nums1.length / 2];
            }
        }

        if (nums1.length == 1 && nums2.length == 1) {
            return (float) (nums1[0] + nums2[0])/2;
        }

        int[] A;
        int[] B;

        if (nums1.length < nums2.length) {
            A = nums1;
            B = nums2;
        } else {
            A = nums2;
            B = nums1;
        }

        int total = A.length + B.length;
        int half = total / 2;

        int l = 0; // index of left
        int r = A.length - 1; // index of right

        while (true) {

            int i = Math.floorDiv(r+l,2);
            int j = half - i - 2;

            int Aleft, Aright;
            int Bleft, Bright;

            Aleft = (i >= 0) ? A[i] : Integer.MIN_VALUE;
            Aright = (i+1 < A.length) ? A[i+1] : Integer.MAX_VALUE;
            Bleft = (j >= 0) ? B[j] : Integer.MIN_VALUE;
            Bright = (j+1 < B.length) ? B[j+1] : Integer.MAX_VALUE;

            if (Aleft <= Bright && Bleft <= Aright) {
                if (total % 2 != 0) {
                    return Math.min(Aright,Bright);
                } else {
                    return (float) (Math.max(Aleft,Bleft) + Math.min(Aright,Bright))/2;
                }
            } else if (Aleft > Bright) {
                r = i-1;
            } else {
                l = i+1;
            }
        }

    }
    public static double findMedianSortedArrays3(int[] nums1, int[] nums2) {

        if (nums1.length == 0) {
            if (nums2.length % 2 == 0) {
                return (float) (nums2[nums2.length / 2] + nums2[nums2.length/2-1])/2;
            } else {
                return nums2[nums2.length / 2];
            }
        }

        if (nums2.length == 0) {
            if (nums1.length % 2 == 0) {
                return (float) (nums1[nums1.length / 2] + nums1[nums1.length/2-1])/2;
            } else {
                return nums1[nums1.length / 2];
            }
        }

        int total = nums1.length + nums2.length;
        int half = total / 2;


        int l = 0;
        int r = nums1.length - 1;

        while (true) {
            int i = (l + r) /2; //nums1
            int j = half - i - 2; //nums2

            int part1left, part1right; // nums1

            int part2left, part2right; // nums2

            if (i >= 0) part1left = nums1[i];
            else part1left = Integer.MIN_VALUE;

            if ((i+1) < nums1.length) part1right = nums1[i+1];
            else part1right = Integer.MAX_VALUE;

            if (j >= 0) part2left = nums2[j];
            else part2left = Integer.MIN_VALUE;

            if ((j+1) < nums2.length) part2right = nums2[j+1];
            else part2right = Integer.MAX_VALUE;

            //correct partition
            if (part1left <= part2right && part2left <= part1right) {
                // odd
                if (total % 2 != 0) {
                    return Math.min(part1right,part2right);
                //even
                } else {
                    return (float) (Math.max(part1left,part2left) + Math.min(part2right,part1right))/2;
                }
            } else if (part1left > part2right) {
                r = i - 1;
            } else {
                l = i + 1;
            }
        }



    }
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
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
