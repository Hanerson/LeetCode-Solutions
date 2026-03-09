package Daily;

import java.util.*;

public class SpiltArray_410 {
    public int splitArray(int[] nums, int k) {
        int min = 0, max = 0;

        for(int num : nums){
            max += num;
            min = Math.max(min, num);
        }
        while(min <= max){
            int mid = (max - min) / 2 + min;

            if(checkIsPossible(mid, nums, k)){
                max = mid - 1;
            }else{
                min = mid + 1;
            }
        }
        return min;
    }
    private boolean checkIsPossible(int mid, int[] nums, int k){
        int count = 1, currSum = 0;

        for(int num : nums){
            if(currSum + num > mid){
                count ++;
                currSum = num;
                if(count > k) return false;
            }else{
                currSum += num;
            }
        }
        return true;
    }

    //another version of dynamic programming

    public int spiltArrayDP(int[] nums, int m){
        int n = nums.length;
        int[][] f = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(f[i], Integer.MAX_VALUE);
        }
        int[] sub = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sub[i + 1] = sub[i] + nums[i];
        }
        f[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, m); j++) {
                for (int k = 0; k < i; k++) {
                    f[i][j] = Math.min(f[i][j], Math.max(f[k][j - 1], sub[i] - sub[k]));
                }
            }
        }
        return f[n][m];
    }
}
