package udemylearn.search;

import java.util.Arrays;

public class Lec02BinarySearch {
    public static void main(String[] args) {
        System.out.println(find(new int[] {-3, 1, 5, 10, 55, 100},1, 0,5));
    }

    public static int find(int[] container, int item, int left, int right) {
        if (right < left) return -1;
        int mid = (left + right) / 2;
        if (container[mid] == item) return mid;
        else if (container[mid] > item) {
            return find(container,item,left,mid - 1);
        } else return find(container,item,mid + 1,right);
    }

    public static int find1(int[] container, int item) {
        // your algorithm here
        System.out.println(Arrays.toString(container));

        int low = 0;
        int high = container.length - 1;

        while (low < high) {
            int mid = (low + high) / 2;

            if (container[mid] == item) {
                return mid;
            } else if (container[mid] > item) {
                high = mid - 1;
            } else low = mid + 1;
        }
        return -1;

    }
}
