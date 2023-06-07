package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        generate(5);
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> first_row = new ArrayList<>();
        first_row.add(1);
        triangle.add(first_row);

        for (int i = 1; i<numRows; i++) {
            List<Integer> pre_row = triangle.get(i-1);
            List<Integer> row = new ArrayList<>();

            row.add(1);

            for (int j = 1; j < i; j++) {
                row.add(pre_row.get(j-1) + pre_row.get(j));
            }

            row.add(1);
            triangle.add(row);
        }
        System.out.println(triangle);
        return triangle;
    }
}
