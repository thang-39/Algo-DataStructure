package takeuforward.recursion;

import java.util.Arrays;

public class Lec04ReverseArray {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(reverseArray1(new int[]{1, 2, 3, 4})));
//        System.out.println(Arrays.toString(reverseArray1(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(reverseArray2(new int[]{1, 2, 3, 4},0,3)));
        System.out.println(Arrays.toString(reverseArray2(new int[]{1, 2, 3, 4, 5},0,4)));

        int[] arr = new int[] {1,2,3,4,5};
        reverseArray3(arr,0);
        System.out.println(Arrays.toString(arr));

    }


    // parameterize
    public static void reverseArray3(int[] arr, int i ) {
        if (i >= arr.length/2) return;
        int temp = arr[i];
        arr[i] = arr[arr.length - 1 -i];
        arr[arr.length - 1 -i] = temp;
        reverseArray3(arr, i+1);
    }

    // recursion with 2 pointers
    public static int[] reverseArray2(int[] arr, int l, int r) {
        if (l >= r) return arr;
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
        return reverseArray2(arr, l+1, r-1);
    }

    // while loop
    public static int[] reverseArray1(int[] arr) {
        int low = 0;
        int high = arr.length-1;
        int temp;
        while(low < high) {
            temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
        return arr;
    }
}
