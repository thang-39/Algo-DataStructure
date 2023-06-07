package LeetCode;

public class SortedArrayToBST {
    public static void main(String[] args) {
        sortedArrayToBST1(new int[]{-10,-3,0,5,9});
    }

    public static TreeNode sortedArrayToBST1(int[] nums) {
        return CreateBST1(nums, 0, nums.length - 1);
    }

    private static TreeNode CreateBST1(int[] nums,int leftPoint,int rightPoint) {
        if (leftPoint > rightPoint) return null;

        int midPoint = (leftPoint + rightPoint) / 2;
        TreeNode root = new TreeNode(nums[midPoint]);
        root.left = CreateBST1(nums,leftPoint,midPoint - 1);
        root.right = CreateBST1(nums,midPoint + 1,rightPoint);
        return root;
    }
}
