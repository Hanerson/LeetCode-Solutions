package Structures.Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MaxBalancedSubarray_3755 {

    //O(n^2)
    public int maxBalancedSubarray(int[] nums) {
        int n = nums.length;

        int[] preXOR = new int[n + 1];
        preXOR[0] = 0;
        for (int i = 1; i <= n; i++) {
            preXOR[i] = preXOR[i - 1] ^ nums[i - 1];
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + (nums[i - 1] % 2 == 0 ? 1 : -1);
        }

        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (dp[j] - dp[i] == 0 && (preXOR[j] ^ preXOR[i]) == 0) {
                    maxLen = Math.max(maxLen, j - i);
                }
            }
        }

        return maxLen;
    }

    //O(n)

    public int maxBalancedSubarray_hash(int[] nums) {
        int n = nums.length;

        // 前缀 XOR：preXOR[0] = 0
        int[] preXOR = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preXOR[i] = preXOR[i - 1] ^ nums[i - 1];
        }

        // key: (奇数 - 偶数) 或 (偶数 - 奇数)，按你喜欢
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        int maxLen = 0;
        int balance = 0;

        // 空前缀的 balance = 0 出现一次
        map.put(0, new ArrayList<>());
        map.get(0).add(0);

        for (int i = 1; i <= n; i++) {
            balance += (nums[i - 1] % 2 == 0 ? 1 : -1);  // 偶数+1，奇数-1

            if (map.containsKey(balance)) {
                // 遍历之前所有相同 balance 的位置
                for (int idx : map.get(balance)) {

                    // 区间 XOR 判断：nums[idx..i-1] 的 XOR 是否为 0
                    if ((preXOR[i] ^ preXOR[idx]) == 0) {
                        maxLen = Math.max(maxLen, i - idx);
                    }
                }
            }

            // 追加当前位置
            map.computeIfAbsent(balance, k -> new ArrayList<>()).add(i);
        }

        return maxLen;
    }

    public int maxBalancedSubarray_superHash(int[] nums) {
        int n = nums.length;

        int[] preXOR = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preXOR[i] = preXOR[i - 1] ^ nums[i - 1];
        }

        int countOfOdd = 0;

        // key = (countOfOdd, preXOR) 的压缩
        HashMap<Long, Integer> map = new HashMap<>();

        long startKey = (((long)0) << 32) ^ (long)preXOR[0];
        map.put(startKey, 0);

        int maxLen = 0;

        for (int i = 1; i <= n; i++) {

            countOfOdd += (nums[i - 1] % 2 == 0 ? -1 : 1);

            long key = (((long)countOfOdd) << 32) ^ (preXOR[i] & 0xffffffffL);

            if (map.containsKey(key)) {
                maxLen = Math.max(maxLen, i - map.get(key));
            } else {
                map.put(key, i);
            }
        }

        return maxLen;
    }



}
