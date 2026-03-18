package Daily;

public class CountSubMats_3070 {
    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;

        int[][] dp = new int[m][n];

        int count = 0;

        dp[0][0] = grid[0][0];
        if(dp[0][0] <= k){
            count ++;
        }else return 0;

        for(int i = 1; i < m; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
            if(dp[i][0] <= k) count ++;
        }

        for(int j = 1; j < n; j++) {
            dp[0][j] = grid[0][j] + dp[0][j - 1];
            if(dp[0][j] <= k) count ++;
        }

        for(int i = 1; i < m; i ++){
            for(int j = 1; j < n; j ++){
                dp[i][j] = grid[i][j] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];

                count += (dp[i][j] <= k) ? 1 : 0;
            }
        }

        return count;
    }

    public static void main(String[] args){
        int[][] grid = new int[][]{
                {7, 2, 9}, {1, 5, 0}, {2, 6, 6}
        };

        CountSubMats_3070 s = new CountSubMats_3070();

        System.out.println(s.countSubmatrices(grid, 20));
    }
}
