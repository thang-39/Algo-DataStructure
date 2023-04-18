package LeetCode;

public class ConvertSortedArrayToBinarySearchTree {

    public static void main(String[] args) {
        sortedArrayToBST(new int[]{-10,-3,0,5,9});
    }

    public static TreeNode sortedArrayToBST(int[] nums) {

        return CreateBST(nums, 0, nums.length - 1);
    }

    private static TreeNode CreateBST(int nums[], int l, int r) {
        if (l > r) { // Base Condition or Recursion Stoping Condition
            return null;
        }
        // so basically in this question we have to convert sorted array to height balanced tree
        // so if we directly create tree in given sorted order it will become linked list
        // so we have to take middle element as head value such it will  become height balanced tree
        int midPoint = (l + r) / 2;
        TreeNode root = new TreeNode(nums[midPoint]); // mid value or median
        root.left = CreateBST(nums, l, midPoint - 1); // assign the value for left of subtree that is l to mid -1 for given array
        root.right = CreateBST(nums, midPoint + 1, r); // assign the value for right go subtree that is mid+1 to r for given array
        return root;
    }
}

