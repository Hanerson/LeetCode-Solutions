package Daily;

public class NumberOfStableArrays_3129 {
    public int numberOfStableArrays(int zero, int one, int limit) {
        final long MOD = 1000000007;
        // dp[i][j][k] 表示使用 i 个 0 和 j 个 1，且以数字 k (0 或 1) 结尾的稳定数组的数量
        // 稳定数组定义：连续相同数字的长度不超过 limit
        long[][][] dp = new long[zero + 1][one + 1][2];
        
        // 初始化：只使用 0 的情况（全部由 0 组成的数组）
        // 当 0 的个数不超过 limit 时，只有一种排列方式，所以设置为 1
        for (int i = 0; i <= Math.min(zero, limit); i++) {
            dp[i][0][0] = 1;
        }
        // 初始化：只使用 1 的情况（全部由 1 组成的数组）
        // 当 1 的个数不超过 limit 时，只有一种排列方式，所以设置为 1
        for (int j = 0; j <= Math.min(one, limit); j++) {
            dp[0][j][1] = 1;
        }
        
        // 动态规划填表过程
        for (int i = 1; i <= zero; i++) {
            for (int j = 1; j <= one; j++) {
                // 计算以 0 结尾的稳定数组数量
                if (i > limit) {
                    // 当 0 的个数超过 limit 时，需要排除不合法的情况
                    // 总方案数 = 前一个状态的所有方案数 - 会导致连续 limit+1 个 0 的方案数
                    // dp[i-1][j][0] + dp[i-1][j][1]: 在之前任意序列后加一个 0
                    // dp[i-limit-1][j][1]: 减去以 1 结尾且有 limit 个 0 的状态（再加 0 会超限）
                    dp[i][j][0] = dp[i - 1][j][0] + dp[i - 1][j][1] - dp[i - limit - 1][j][1];
                } else {
                    // 当 0 的个数不超过 limit 时，可以直接在前序状态后添加 0
                    dp[i][j][0] = dp[i - 1][j][0] + dp[i - 1][j][1];
                }
                // 处理负数取模，确保结果在 [0, MOD) 范围内
                dp[i][j][0] = (dp[i][j][0] % MOD + MOD) % MOD;
                
                // 计算以 1 结尾的稳定数组数量（逻辑同上，只是针对 1）
                if (j > limit) {
                    // 当 1 的个数超过 limit 时，需要排除不合法的情况
                    // dp[i][j-1][1] + dp[i][j-1][0]: 在之前任意序列后加一个 1
                    // dp[i][j-limit-1][0]: 减去以 0 结尾且有 limit 个 1 的状态（再加 1 会超限）
                    dp[i][j][1] = dp[i][j - 1][1] + dp[i][j - 1][0] - dp[i][j - limit - 1][0];
                } else {
                    // 当 1 的个数不超过 limit 时，可以直接在前序状态后添加 1
                    dp[i][j][1] = dp[i][j - 1][1] + dp[i][j - 1][0];
                }
                // 处理负数取模，确保结果在 [0, MOD) 范围内
                dp[i][j][1] = (dp[i][j][1] % MOD + MOD) % MOD;
            }
        }
        // 返回最终结果：以 0 结尾和以 1 结尾的稳定数组总数之和
        return (int) ((dp[zero][one][0] + dp[zero][one][1]) % MOD);
    }
}
