package Daily;

public class NumberOfSameFreqSubMat_3212 {
    public int numberOfSubmatrices(char[][] grid) {
        int[][] preX = initPreSum(grid, 'X'), preY = initPreSum(grid, 'Y');

        int count = 0, m = grid.length, n = grid[0].length;

        for(int i = 1; i <= m; i ++){
            for(int j = 1; j <= n; j ++){
                if(preX[i][j] == preY[i][j] && preX[i][j] != 0){
                    count ++;
                }
            }
        }

        return count;
    }

    private int[][] initPreSum(char[][] grid, char c){
        int m = grid.length, n = grid[0].length;

        int[][] prefix = new int[m + 1][n + 1];

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                prefix[i][j] = ((grid[i - 1][j - 1] == c) ? 1 : 0) + prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1];
            }
        }

        return prefix;
    }
}
