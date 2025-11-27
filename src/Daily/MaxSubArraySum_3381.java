package Daily;

import java.util.*;

public class MaxSubArraySum_3381 {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long prefixSum = 0;
        long maxSum = Long.MIN_VALUE;
        long[] kSum = new long[k];
        Arrays.fill(kSum, Long.MAX_VALUE / 2);
        kSum[k - 1] = 0;
        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];
            maxSum = Math.max(maxSum, prefixSum - kSum[i % k]);
            kSum[i % k] = Math.min(kSum[i % k], prefixSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MaxSubArraySum_3381 obj = new MaxSubArraySum_3381();
        System.out.println(obj.maxSubarraySum(new int[]{-1,-2,-3,-4,-5}, 4));
    }
}
