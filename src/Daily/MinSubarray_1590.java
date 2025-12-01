package Daily;

import java.util.HashMap;
import java.util.Map;

public class MinSubarray_1590 {

    /**
     * 下面的方法时间复杂度近似于O(N^2)
     * */

    public int minSubarray(int[] nums, int p) {
        int len = nums.length;
        long[] prefix =  new long[len + 1];

        prefix[0] = 0;
        for(int i = 1; i <= len; i++){
            prefix[i] = prefix[i-1] + nums[i-1];
        }

        long leak = prefix[len] % p;
        if(leak == 0) return 0;
        if(prefix[len] < p) return -1;
        int minLen = Integer.MAX_VALUE;

        for(int i = 0; i <= len; i++){
            for(int j = i; j <= len; j++){
                if((prefix[j] - prefix[i]) % p == leak){
                    minLen = Math.min(minLen, j - i);
                }
            }
        }
        return (minLen == Integer.MAX_VALUE || minLen == len) ? -1 : minLen;
    }

    public int minSubarray_better(int[] nums, int p) {
        int n = nums.length;
        // prefix[i] 表示 nums 前 i 个元素的和
        // 使用 long 防止整型溢出
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        // 总和的余数
        int rem = (int)(prefix[n] % p);
        if (rem == 0) {
            return 0;
        }

        // 记录 {前缀和余数 : 该余数最后出现的索引}
        Map<Integer, Integer> modPos = new HashMap<>();
        int ans = n;

        for (int i = 0; i < n + 1; i++) {
            // 当前前缀和余数
            int curMod = (int)(prefix[i] % p);
            // 目标前缀和余数
            // 负数取模结果为负，需 +p 修正
            int target = (curMod - rem + p) % p;

            // 说明 prefix[j]...prefix[i] 中间的子数组符合条件
            if (modPos.containsKey(target)) {
                ans = Math.min(ans, i - modPos.get(target));
            }

            // 更新当前余数的索引
            modPos.put(curMod, i);
        }

        return ans < n ? ans : -1;
    }
}
