package LeetCode;

public class SearchInsertPosition {
    public static void main(String[] args) {
        searchInsert(new int[]{1,3,5,6},5);
        searchInsert(new int[]{1,3,5,6},2);
        searchInsert(new int[]{1,3,5,6},7);
    }
    public static int searchInsert(int[] nums, int target) {

        if (target < nums[0]) return 0;

        int insertIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                insertIndex = i;
            } else if (target > nums[i]) {
                insertIndex++;
            }
        }
        System.out.println(insertIndex);
        return insertIndex;
    }
}
