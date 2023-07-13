package takeuforward.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lec14NQueens {
    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char [][] board = new char[n][n];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                board[i][j] = '.';
            }
        }
        solve(0,board,ans,n);
        return ans;
    }

    private static void solve(int col, char[][] board, List<List<String>> ans, int n) {
        if (col == n) {

            ans.add(construct(board));
            return;
        }

        for(int row = 0; row < n; row++) {
            if (isSafe(row, col, board, n)) {
                board[row][col] = 'Q';
                solve(col + 1, board, ans, n);
                board[row][col] = '.';
            }
        }

    }

    private static boolean isSafe(int row, int col, char[][] board, int n) {
        int originRow = row;
        int originCol = col;

        // 1st column - do not check
        if (col == 0) return true;

        // check left
        while (col >= 0) {
            if (board[row][col] == 'Q') return false;
            col--;
        }

        // check upper diagonal
        col = originCol;
        while(row >=0 && col >=0) {

            if (board[row][col] == 'Q') return false;
            row--;
            col--;
        }

        // last row - do not check under diagonal
        if (row == n-1) return true;

        // check under diagonal
        row = originRow;
        col = originCol;
        while (row < n && col >= 0) {
            if (board[row][col] == 'Q') return false;
            row++;
            col--;
        }
        return true;
    }

    static List<String> construct(char[][] board) {

        List<String> internal = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String row = new String(board[i]);
            internal.add(row);
        }
        return internal;
    }
}
