package Algorithm.DynamicProgramming;

public class CanPartition {
    public boolean canPartition(int[] nums){
        int sum = 0;
        for (int num : nums) sum += num;
        if(sum % 2 == 1) return false;
        int target = sum / 2;

        boolean[][]  dp = new boolean[nums.length+1][target+1];

        dp[0][0] = true;

        for(int i = 1; i <= nums.length; i++){
            for(int j = 0; j <= target; j++){

                dp[i][j] = dp[i-1][j];

                if(j>=nums[i-1]) dp[i][j] = dp[i][j] || dp[i-1][j-nums[i-1]];
            }
        }

        return dp[nums.length][target];
    }

    public static void main(String[] args){
        CanPartition cp = new CanPartition();
        System.out.println(cp.canPartition(new int[]{2,3,5}));
    }
}
