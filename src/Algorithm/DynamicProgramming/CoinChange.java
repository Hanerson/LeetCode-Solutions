package Algorithm.DynamicProgramming;

class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        for(int i = 0; i <= amount ; i++){
            dp[i] = amount+1;
        }
        dp[0] = 0;
        for(int i = 0; i<=amount; i++){
            for(int coin : coins){
                if(i-coin >= 0) dp[i] = Math.min(dp[i], dp[i-coin]+1);
            }
        }
        return (dp[amount]==amount+1)? -1 : dp[amount];
    }

    public static void main(String[] args){
        CoinChange sol = new CoinChange();
        int[] coins = new int[]{
                1,2,5,10,20,50,100
        };

        System.out.println(sol.coinChange(coins,1324));
    }
}