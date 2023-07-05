package udemylearn.selection;

import java.util.Random;

public class QuickSelect {
    private int[] nums;

    public QuickSelect(int[] nums) {
        this.nums = nums;
    }

    public int select(int k) {
        return quickSelect(0, nums.length - 1, k - 1);
    }

    private int quickSelect(int firstIndex, int lastIndex, int k) {
        int pivotIndex = partition(firstIndex, lastIndex);

        if (pivotIndex < k) {
            return quickSelect(pivotIndex + 1, lastIndex, k);
        } else if (pivotIndex > k) {
            return quickSelect(firstIndex, pivotIndex -1, k);
        }
        return nums[pivotIndex];
    }

    private int partition(int firstIndex, int lastIndex) {
        int pivot = new Random().nextInt(lastIndex - firstIndex + 1) + firstIndex;
        
        swap(pivot, lastIndex);

        for (int i = firstIndex; i < lastIndex; i++) {
            if (nums[i] < nums[lastIndex]) { // change this to find the k-th greatest item
                swap(i, firstIndex);
                firstIndex++;
            }
        }

        swap(lastIndex, firstIndex);
        return firstIndex;
    }

    private void swap(int pivot, int lastIndex) {
        int temp = nums[pivot];
        nums[pivot] = nums[lastIndex];
        nums[lastIndex]=temp;
    }
}
