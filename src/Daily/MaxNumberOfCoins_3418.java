package Daily;

public class MaxNumberOfCoins_3418 {
    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;
        final int INF = Integer.MIN_VALUE / 2; // 防止溢出

        // dp[i][j][k]：走到(i,j)，用了k次感化的最大金币
        int[][][] dp = new int[m][n][3];

        // 1. 初始化所有状态为不可达
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][0] = INF;
                dp[i][j][1] = INF;
                dp[i][j][2] = INF;
            }
        }

        // 2. 初始化起点 (0,0)
        int first = coins[0][0];
        if (first >= 0) {
            dp[0][0][0] = first;
        } else {
            dp[0][0][0] = first;   // 不感化
            dp[0][0][1] = 0;       // 感化
        }

        for (int i = 1; i < m; i++) {
            int curr = coins[i][0];
            for (int k = 0; k < 3; k++) {
                if (dp[i-1][0][k] == INF) continue;

                if (curr >= 0) {
                    dp[i][0][k] = Math.max(dp[i][0][k], dp[i-1][0][k] + curr);
                } else {
                    // 不感化
                    dp[i][0][k] = Math.max(dp[i][0][k], dp[i-1][0][k] + curr);
                    // 感化
                    if (k < 2) {
                        dp[i][0][k+1] = Math.max(dp[i][0][k+1], dp[i-1][0][k]);
                    }
                }
            }
        }

        for (int j = 1; j < n; j++) {
            int curr = coins[0][j];
            for (int k = 0; k < 3; k++) {
                if (dp[0][j-1][k] == INF) continue;

                if (curr >= 0) {
                    dp[0][j][k] = Math.max(dp[0][j][k], dp[0][j-1][k] + curr);
                } else {
                    // 不感化
                    dp[0][j][k] = Math.max(dp[0][j][k], dp[0][j-1][k] + curr);
                    // 感化
                    if (k < 2) {
                        dp[0][j][k+1] = Math.max(dp[0][j][k+1], dp[0][j-1][k]);
                    }
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int curr = coins[i][j];
                for (int k = 0; k < 3; k++) {
                    // 来自上边
                    if (dp[i-1][j][k] != INF) {
                        update(dp, i, j, k, curr, dp[i-1][j][k]);
                    }
                    // 来自左边
                    if (dp[i][j-1][k] != INF) {
                        update(dp, i, j, k, curr, dp[i][j-1][k]);
                    }
                }
            }
        }

        // 取终点 0/1/2 次感化的最大值
        int res = dp[m-1][n-1][0];
        res = Math.max(res, dp[m-1][n-1][1]);
        res = Math.max(res, dp[m-1][n-1][2]);
        return res;
    }

    // 工具方法：处理当前格子的两种选择（感化/不感化）
    private void update(int[][][] dp, int i, int j, int k, int curr, int prev) {
        if (curr >= 0) {
            dp[i][j][k] = Math.max(dp[i][j][k], prev + curr);
        } else {
            // 不感化
            dp[i][j][k] = Math.max(dp[i][j][k], prev + curr);
            // 感化
            if (k < 2) {
                dp[i][j][k+1] = Math.max(dp[i][j][k+1], prev);
            }
        }
    }
}