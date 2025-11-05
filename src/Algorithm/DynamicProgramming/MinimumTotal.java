package Algorithm.DynamicProgramming;

import java.util.List;

public class MinimumTotal {
    public int minimumTotal_dp(List<List<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty()) {
            return 0;
        }
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                int currentVal = triangle.get(i).get(j);
                if (j == 0) {
                    dp[i][j] = dp[i-1][j] + currentVal;
                } else if (j == i) {
                    dp[i][j] = dp[i-1][j-1] + currentVal;
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]) + currentVal;
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            min = Math.min(min, dp[n-1][j]);
        }

        return min;
    }
}

