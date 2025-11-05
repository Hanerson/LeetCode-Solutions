package Algorithm.DynamicProgramming;

public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0){
                    dp[i][j] = 1;
                }
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0]==1) return 0;
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid.length; i++){
            for (int j = 0; j < obstacleGrid[0].length; j++){
                if(i==0 && j==0){
                    dp[i][j] = 1;
                    continue;
                }
                if(i==0 || j==0){
                    if(obstacleGrid[i][j]==1){
                        dp[i][j]=0;
                    }else{
                        if(i==0){
                            dp[i][j]=dp[i][j-1];
                        }else{
                            dp[i][j]=dp[i-1][j];
                        }
                    }
                }else{
                    if(obstacleGrid[i][j]==1){
                        dp[i][j]=0;
                    }else{
                        dp[i][j]=dp[i-1][j]+dp[i][j-1];
                    }
                }
            }
        }
        return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}
