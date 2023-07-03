package hackerRank;

import java.util.List;

public class DiagonalDifference {
    public static void main(String[] args) {
        List<Integer> r0 = List.of(11,2,4);
        List<Integer> r1 = List.of(4,5,6);
        List<Integer> r2 = List.of(10,8,-12);

        List<List<Integer>> arr = List.of(r0, r1, r2);
        System.out.println(diagonalDifference(arr));
    }


    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here

        int row = 0;
        int col = arr.size() -1;

        int left = 0;
        int right = 0;

        for (int i = 0; i < arr.size(); i++) {
            left += arr.get(i).get(i);
        }

        while (row < arr.size() && col >= 0) {
            right += arr.get(row).get(col);
            row++;
            col--;
        }



//        while (row1 < arr.size() && row2 >= 0) {
//            for (int i = 0; i < arr.size(); i++) {
//                left += arr.get(row1).get(i);
//            }
//            row1++;
//
//            for (int i = arr.size() - 1; i >= 0; i--) {
//                right += arr.get(row2).get(i);
//            }
//            row2--;
//        }

        return Math.abs(left - right);

    }
}
