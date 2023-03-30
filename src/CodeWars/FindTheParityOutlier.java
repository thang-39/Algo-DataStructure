package CodeWars;

import java.util.Arrays;

public class FindTheParityOutlier {
    public static void main(String[] args) {
        System.out.println(find(new int[]{5,3,9,-10,}));
    }

    public static int find(int[] integers) {
        // Since we are warned the array may be very large, we should avoid counting values any more than we need to.

        // We only need the first 3 integers to determine whether we are chasing odds or evens.
        // So, take the first 3 integers and compute the value of Math.abs(i) % 2 on each of them.
        // It will be 0 for even numbers and 1 for odd numbers.
        // Now, add them. If sum is 0 or 1, then we are chasing odds. If sum is 2 or 3, then we are chasing evens.
        int sum = Arrays.stream(integers).limit(3).map(i -> Math.abs(i) % 2).sum();
        System.out.println(sum);
        // if sum = 0 or 1 - we will find odd number
        // otherwise, we will find even number
        int mod = (sum == 0 || sum == 1) ? 1 : 0;

        return Arrays.stream(integers).parallel() // call parallel to get as much bang for the buck on a "large" array
                .filter(n -> Math.abs(n) % 2 == mod).findFirst().getAsInt();
    }

    static int find1(int[] integers) {

        int countEven = 0;
        int countOdd = 0;

        for (int i = 0; i < 3; i++) {
            if (integers[i] % 2 == 0) {
                countEven++;
            } else {
                countOdd++;
            }
        }

        int result = 0;

        for (int i = 0; i < integers.length; i++) {
            if (countEven > countOdd) {
                if (integers[i] % 2 != 0) {
                    result = integers[i];
                    break;
                }
            } else {
                if (integers[i] % 2 == 0) {
                    result = integers[i];
                    break;
                }
            }
        }
        System.out.println(result);
        return result;

    }
}
