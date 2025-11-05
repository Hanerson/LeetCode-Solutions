package Algorithm.DynamicProgramming;

public class CalculateMinimumHP {
    public int calculateMinimumHP(int[][] dungeon){
        int m = dungeon.length, n = dungeon[0].length;
        int[][] dp = new int[m+1][n+1];
        int[][] dp_minPath = new int[m+1][n+1];
        dp_minPath[0][0] = dungeon[0][0];
        dp[0][0] = (dungeon[0][0] < 0) ? -dungeon[0][0] : 0;
        for(int i = 1; i < n; i++){
            dp_minPath[0][i] = dungeon[0][i] + dp_minPath[0][i-1];
            if(dp_minPath[0][i] < 0){
                dp[0][i] = -dp_minPath[0][i] + dp[0][i-1];
            }else dp[0][i] = dp[0][i-1];
        }

        for(int i = 1; i < m; i++){
            dp_minPath[i][0] = dungeon[i][0] + dp_minPath[i-1][0];
            if(dp_minPath[i][0] < 0){
                dp[i][0] = -dp_minPath[i][0] + dp[0][i-1];
            }else dp[i][0] = dp[i-1][0];
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp_minPath[i][j] = dungeon[i][j] + Math.max(dp_minPath[i-1][j], dp_minPath[i][j-1]);
                if(dp_minPath[i][j] < 0){
                    dp[i][j] = -dp_minPath[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
                }else dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[m][n];
    }
}
