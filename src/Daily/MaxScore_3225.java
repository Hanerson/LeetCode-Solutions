package Daily;

import java.util.*;

public class MaxScore_3225 {
    public long maximumScore(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][][] dp = new int[n][m+1][m+1];

        int[][] colSum = new int[n][m+1];
        for(int j = 0; j < n; j++){
            for(int i = 0; i < m; i++){
                colSum[j][i+1] = colSum[j][i] + grid[i][j];
            }
        }

        for(int i = 0; i <= m; i++){
            Arrays.fill(dp[0][i], 0);
        }

        for(int i = 1; i < n; i++){
            for(int a = 0; a <= m; a++){
                for(int b = 0; b <= m; b++){
                    if(dp[i-1][a][b] == 0 && i-1 != 0) continue;

                    for(int c = 0; c <= m; c++){
                        int add = c > b ? colSum[i][c] : 0;
                        dp[i][c][a] = Math.max(dp[i][c][a], dp[i-1][a][b] + add);
                    }
                }
            }
        }

        int ans = 0;
        for(int a = 0; a <= m; a++){
            for(int b = 0; b <= m; b++){
                ans = Math.max(ans, dp[n-1][a][b]);
            }
        }
        return ans;
    }
}
