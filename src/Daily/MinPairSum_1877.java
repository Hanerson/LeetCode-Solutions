package Daily;

import java.util.Arrays;

public class MinPairSum_1877 {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);

        int min = Integer.MIN_VALUE;

        int head = 0, tail = nums.length - 1;
        while (head < tail) {
            min = Math.max(min, nums[head] + nums[tail]);
            head++;
            tail--;
        }

        return min;
    }
}
