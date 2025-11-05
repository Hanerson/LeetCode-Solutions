package Algorithm.BackTrack;

import java.util.ArrayList;
import java.util.List;

class NQueens {

    public List<List<String>> solveNQueens(int n) {
        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2*n];
        boolean[] diag2 = new boolean[2*n];

        char[][] board = InitBoard(n);

        List<List<String>> res = new ArrayList<>();

        backTrack(0,board,cols,diag1,diag2,res);

        return res;
    }
    public char[][] InitBoard(int n){
        char[][] board = new char[n][n];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                board[i][j] = '.';
            }
        }
        return board;
    }

    public boolean canPlace(char[][] board, boolean[] cols, boolean[] diag1, boolean[] diag2, int row, int col) {
        int n = board.length;
        return !cols[col] && !diag1[row + col] && !diag2[row - col + (n - 1)];
    }
    public void backTrack(
            int row, char[][] board,
            boolean[] cols, boolean[] diag1, boolean[] diag2,
            List<List<String>> res
    ) {
        int n = board.length;
        if (row == n) {
            res.add(convertBoard(board));
            return;
        }
        for (int col = 0; col < n; col++) {
            int d1 = row + col;
            int d2 = row - col + n - 1;

            if (canPlace(board, cols, diag1, diag2, row,col)) {

                board[row][col] = 'Q';
                cols[col] = true;
                diag1[d1] = true;
                diag2[d2] = true;

                backTrack(row + 1, board, cols, diag1, diag2, res);

                board[row][col] = '.';
                cols[col] = false;
                diag1[d1] = false;
                diag2[d2] = false;
            }
        }
    }
    public List<String> convertBoard(char[][] board){
        List<String> res = new ArrayList<>();
        for (char[] chars : board){
            res.add(new String(chars));
        }
        return res;
    }
    public static void main(String[] args){
        NQueens solution = new NQueens();
        System.out.print(solution.solveNQueens(8));
    }
}
