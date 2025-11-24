package Daily;

public class MaxSumDivideThree_1262 {
    public int maxSumDivThree(int[] nums) {
        int[] dp = new int[3];
        // 初始化：dp[0] = 0, dp[1] = dp[2] = -∞ 表示不可达
        dp[1] = dp[2] = Integer.MIN_VALUE;

        for (int x : nums) {
            int[] next = dp.clone();
            for (int r = 0; r < 3; r++) {
                if (dp[r] != Integer.MIN_VALUE) {
                    int newR = (r + x) % 3;
                    next[newR] = Math.max(next[newR], dp[r] + x);
                }
            }
            dp = next;
        }

        return dp[0];
    }
}
