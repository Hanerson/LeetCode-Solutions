package Daily;

import java.util.*;

public class MaxLengthIncreasingSubArray_3350 {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int len = nums.size();
        int[] dp = new int[len];
        dp[0] = 1;

        for(int i = 1; i < len; i++){
            if(nums.get(i) > nums.get(i - 1)){
                dp[i] = dp[i - 1] + 1;
            }else{
                dp[i] = 1;
            }
        }

        int low = 1, high = len / 2;

        while(low <= high){
            int mid = (low + high) / 2;

            if(check(dp, mid)){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return high;
    }

    private boolean check(int[] dp, int k){
        for(int i = 0; i + 2 * k - 1 < dp.length; i++){
            if(dp[i + k - 1] >= k && dp[i + 2 * k - 1] >= k){
                return true;
            }
        }
        return false;
    }
}
