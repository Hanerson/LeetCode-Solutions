package Algorithm;

//Kadane 算法
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int currSum = nums[0];
        int max = nums[0];
        for(int num : nums){
            currSum += num;
            currSum = Math.max(num, currSum+num);
            max = Math.max(max, currSum);
        }
        return max;
    }
    public static void main(String[] args){
        MaxSubArray maxSubArray = new MaxSubArray();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray.maxSubArray(nums));
    }
}
