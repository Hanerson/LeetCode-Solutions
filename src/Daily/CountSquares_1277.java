package Daily;

public class CountSquares_1277 {


    /**
     * this method has a high level of time complexity
     * */
    public int countSquares_slower(int[][] matrix) {
        int m =  matrix.length, n = matrix[0].length;

        int[][] dp = new int[m][n];

        for(int i = 0; i < m; i++){
            dp[i][0] = matrix[i][0];
        }

        for(int i = 0; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = (matrix[i][j] == 1) ? dp[i][j - 1] + 1: 0;
            }
        }

        int count = 0;

        for(int len = 1; len <= Math.min(m ,n); len++){
            for(int i = len - 1; i < m; i++){
                for(int j = len - 1; j < n; j++){
                    if(dp[i][j] >= len){
                        boolean canDo = true;

                        for(int checkRow = i; checkRow >= i - len + 1; checkRow --){
                            if(dp[checkRow][j] < len){
                                canDo = false;
                                break;
                            }
                        }

                        count += canDo ? 1 : 0;
                    }
                }
            }
        }

        return count;
    }


    /**
     * we can realize another method which compute faster: dp[i][j] stands for the max length of possible square
     * */

    public int countSquares(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int count = 0;

        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
            count += dp[0][j];
        }

        for (int i = 1; i < m; i++) {
            dp[i][0] = matrix[i][0];
            count += dp[i][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    count += dp[i][j];
                }
            }
        }

        return count;
    }
}
