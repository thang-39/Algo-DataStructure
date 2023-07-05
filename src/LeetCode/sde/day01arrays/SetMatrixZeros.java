package LeetCode.sde.day01arrays;

import java.util.*;

public class SetMatrixZeros {

    public static void main(String[] args) {

        int[][] matrix = new int[][]{
                new int[]{0,1,2,0},
                new int[]{3,4,5,2},
                new int[]{1,3,1,5}
        };

        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));

    }
    public static void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for (int row : rows) {
            Arrays.fill(matrix[row],0);
        }

        for (int i = 0; i < matrix.length; i++) {
            if (rows.contains(i)) continue;
            for (int col : cols) {
                matrix[i][col] = 0;
            }
        }


    }
    public static void setZeroes1(int[][] matrix) {

        Map<int[], Integer> store = new HashMap<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    store.put(new int[]{i,j},i);
                }
            }
        }

        System.out.println(store);

        for (int row : store.values()) {
            Arrays.fill(matrix[row],0);
        }


        for (int i = 0; i < matrix.length; i++) {
            if (store.containsValue(i)) continue;
            for (int[] coordinate : store.keySet()) {
                matrix[i][coordinate[1]] = 0;
            }
        }
    }
}
