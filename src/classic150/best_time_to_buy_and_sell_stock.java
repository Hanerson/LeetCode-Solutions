package classic150;

import java.util.Arrays;

public class best_time_to_buy_and_sell_stock {
    //only do once
    public int maxProfitI(int[] prices){
        if(prices.length == 1) return 0;
        int max = 0;
        int[] dp = new int[prices.length+1];
        dp[0] = Integer.MAX_VALUE;
        for(int i = 1; i < dp.length; i++){
            dp[i] = Math.min(dp[i-1], prices[i-1]);
            max = Math.max(max, prices[i-1]-dp[i-1]);
        }
        return max;
    }

    //can do infinite times
    public int maxProfitII(int[] prices){
        int slow = 0, fast = 1;
        int profit = 0;
        while(fast <  prices.length){
            if(prices[fast] < prices[fast - 1]) {
                profit += profit;
                slow = fast;
            }
            fast ++;
        }
        if(profit > 0) profit += - prices[slow] +  prices[fast-1];
        return  profit;
    }

    //can only do for two times
    public int maxProfitIII(int[] prices){
        int fstBuy = Integer.MIN_VALUE, fstSell = 0;
        int secBuy = Integer.MIN_VALUE, secSell = 0;
        for(int p : prices) {
            fstBuy = Math.max(fstBuy, -p);
            fstSell = Math.max(fstSell, fstBuy + p);
            secBuy = Math.max(secBuy, fstSell - p);
            secSell = Math.max(secSell, secBuy + p);
        }
        return secSell;
    }

    //can do for k times
    public int maxProfitIV(int k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        k = Math.min(k, n / 2);
        int[][] buy = new int[n][k + 1];
        int[][] sell = new int[n][k + 1];

        buy[0][0] = -prices[0];
        sell[0][0] = 0;
        for (int i = 1; i <= k; ++i) {
            buy[0][i] = sell[0][i] = Integer.MIN_VALUE / 2;
        }

        for (int i = 1; i < n; ++i) {
            buy[i][0] = Math.max(buy[i - 1][0], sell[i - 1][0] - prices[i]);
            for (int j = 1; j <= k; ++j) {
                buy[i][j] = Math.max(buy[i - 1][j], sell[i - 1][j] - prices[i]);
                sell[i][j] = Math.max(sell[i - 1][j], buy[i - 1][j - 1] + prices[i]);
            }
        }

        return Arrays.stream(sell[n - 1]).max().getAsInt();
    }
}
