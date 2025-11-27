package Daily;

import java.util.Arrays;

public class NumOfPossiblePaths_2435 {
    private final int MOD = 1000000007;

    public int numberOfPaths(int[][] grid, int k){
        int m = grid.length, n = grid[0].length;
        int[][][] dp = new int[m][n][k];


        dp[0][0][grid[0][0] % k] = 1;

        for (int j = 1; j < n; j++) {
            for (int r = 0; r < k; r++) {
                int val = (r - grid[0][j] % k + k) % k;
                if(dp[0][j-1][val] != 0){
                    dp[0][j][r] ++;
                    dp[0][j][r] %= MOD;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int r = 0; r < k; r++) {
                int val = (r - grid[i][0] % k + k) % k;
                if(dp[i-1][0][val] != 0){
                    dp[i][0][r] ++;
                    dp[i][0][r] %= MOD;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                for (int r = 0; r < k; r++) {
                    int prev = (r - grid[i][j] % k + k) % k;
                    int sum = dp[i-1][j][prev] + dp[i][j-1][prev];
                    dp[i][j][r] += sum;
                    dp[i][j][r] %= MOD;
                }
            }
        }

        return dp[m-1][n-1][0] % MOD;
    }

    public static void main(String[] args) {
        NumOfPossiblePaths_2435 sol = new NumOfPossiblePaths_2435();
        int[][] grid = new int[][]{
                {5,2,4},{3,0,5},{0,7,2}
        };
        System.out.println(sol.numberOfPaths(grid, 3));
    }
}
