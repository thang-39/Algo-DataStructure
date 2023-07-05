package udemylearn.recursion;

import java.util.Arrays;

public class Lec07GCD {
    public static void main(String[] args) {
        System.out.println(gcb_recursion(24,11));
        System.out.println(gcb_iteration(24,11));

        System.out.println(find(new int[] {1, 5, -3, 10, 55, 100},10));


    }
    public static int gcb_recursion(int a, int b) {

        // base case
        if (a % b == 0) return b;

        return gcb_recursion(b, a % b);
    }

    public static int gcb_iteration(int a, int b) {

        int temp = 0;

        while(b != 0) {
            temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int find(int[] container, int item) {
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
