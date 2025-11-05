package Algorithm.DynamicProgramming;

public class MaxProduct {
    public int maxProduct(int[] nums){
        int[] dp = new int[nums.length], dp1 =  new int[nums.length];
        dp[0] = nums[0];
        dp1[0] = nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++){
            dp[i] = Math.max(Math.max(nums[i] * dp[i-1], nums[i] * dp1[i-1]), nums[i]);
            dp1[i] = Math.min(Math.min(nums[i] * dp1[i-1],nums[i] * dp[i-1]), nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args){
        MaxProduct m = new MaxProduct();
        System.out.println(m.maxProduct(new int[]{0,2}));
    }
}
