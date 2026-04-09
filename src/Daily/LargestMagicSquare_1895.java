package Daily;

public class LargestMagicSquare_1895 {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ans = 1;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int maxLen = Math.min(m - i, n - j);

                for(int len = maxLen; len > ans; len--){
                    if(checkIsMagicSquare(i, j, len, grid)){
                        ans = len;
                        break;
                    }
                }
            }
        }

        return ans;
    }

    private boolean checkIsMagicSquare(int x, int y, int len, int[][] grid){
        int diag1 = 0, diag2 = 0;

        for(int i = 0; i < len; i++){
            diag1 += grid[x + i][y + i];
            diag2 += grid[x + i][y + len - 1 - i];
        }

        if(diag1 != diag2) return false;

        int target = diag1;

        for(int i = 0; i < len; i++){
            int rowSum = 0, colSum = 0;
            for(int j = 0; j < len; j++){
                rowSum += grid[x + i][y + j];
                colSum += grid[x + j][y + i];
            }
            if(rowSum != target || colSum != target) return false;
        }

        return true;
    }
}