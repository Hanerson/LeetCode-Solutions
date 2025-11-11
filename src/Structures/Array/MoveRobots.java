package Structures.Array;

import java.util.Arrays;

public class MoveRobots {

    private static final int MOD = 1000000007;

    public int sumDistance(int[] nums, String s, int d) {
        int pos = 0;
        while(pos < nums.length){
            nums[pos] += (s.charAt(pos) == 'L') ? -d : d;
            pos++;
        }
        return calculateDistance(nums);
    }

    public int calculateDistance(int[] points) {
        int n = points.length;
        if (n < 2) return 0;

        Arrays.sort(points);
        long prefixSum = 0;
        long total = 0;

        for (int i = 0; i < n; i++) {
            total += (long) points[i] * i - prefixSum;
            prefixSum += points[i];
        }
        while(total < 0) total += MOD;
        return (int)(total % MOD);
    }
}
