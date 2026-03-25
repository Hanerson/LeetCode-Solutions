package Daily;

public class MaxPathProduct_1594 {
    private static final int MOD = 1000000007; // 10^9+7 常量定义

    public int maxProductPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long[][][] dp = new long[m][n][2];

        dp[0][0][0] = grid[0][0];
        dp[0][0][1] = grid[0][0];

        for (int i = 1; i < m; i++) {
            long val = dp[i-1][0][0] * grid[i][0];
            dp[i][0][0] = val;
            dp[i][0][1] = val;
        }

        for (int j = 1; j < n; j++) {
            long val = dp[0][j-1][0] * grid[0][j];
            dp[0][j][0] = val;
            dp[0][j][1] = val;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                long curr = grid[i][j];
                long a = dp[i][j-1][0] * curr;
                long b = dp[i][j-1][1] * curr;
                long c = dp[i-1][j][0] * curr;
                long d = dp[i-1][j][1] * curr;

                dp[i][j][0] = Math.max(Math.max(a, b), Math.max(c, d));
                dp[i][j][1] = Math.min(Math.min(a, b), Math.min(c, d));
            }
        }
        long maxProduct = dp[m-1][n-1][0];
        return maxProduct < 0 ? -1 : (int) (maxProduct % MOD);
    }
}