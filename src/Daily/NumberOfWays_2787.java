package Daily;

//dp

import java.util.ArrayList;
import java.util.List;

public class NumberOfWays_2787 {

    private static final int MOD = 1000000007;

    public int numberOfWays(int n, int x) {
        List<Integer> powers = new ArrayList<>();

        for(int i = 1; i <= n; i++){
            if(Math.pow(i, x) <= n){
                powers.add((int)Math.pow(i, x));
            }
        }

        int len = powers.size();

        int[][] dp = new int[len + 1][n + 1];
        dp[0][0] = 1;

        for(int i = 1; i <= len; i++){
            for(int j = 0; j <= n; j++){
                dp[i][j] = dp[i - 1][j];

                if(j >= powers.get(i - 1)){
                    dp[i][j] = dp[i][j] + dp[i - 1][j - powers.get(i - 1)];
                    dp[i][j] %= MOD;
                }
            }
        }

        return dp[len][n];
    }
}
