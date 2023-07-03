package hackerRank;

import java.util.ArrayList;
import java.util.List;

public class HourClassSum {
    public static void main(String[] args) {

        List<Integer> r0 = List.of(-9, -9, -9,  1, 1, 1);
        List<Integer> r1 = List.of(0, -9,  0,  4, 3, 2);
        List<Integer> r2 = List.of(-9, -9, -9,  1, 2, 3);
        List<Integer> r3 = List.of(0,  0,  8,  6, 6, 0);
        List<Integer> r4 = List.of(0,  0,  0, -2, 0, 0);
        List<Integer> r5 = List.of(0,  0, 1,  2, 4, 0);
        List<List<Integer>> arr = List.of(r0, r1,r2,r3,r4,r5);
        System.out.println(hourglassSum(arr));


    }

    public static int hourglassSum(List<List<Integer>> arr) {
        int row = 0;

        int result = Integer.MIN_VALUE;
        int total;

        while (row < 4) {
            for (int i = 0; i < 6 - 2; i++) {
                total = arr.get(row).get(i) + arr.get(row).get(i+1) + arr.get(row).get(i+2)
                        + arr.get(row + 1).get(i + 1)
                        + arr.get(row + 2).get(i) + arr.get(row+2).get(i+1) + arr.get(row+2).get(i+2);
                result = Math.max(total, result);
            }
            row++;
        }
        return result;
    }
}
