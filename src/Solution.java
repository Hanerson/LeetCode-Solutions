import java.util.Arrays;

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for(int i = nums.length-1;i>=0;i--){
            sum+=nums[i];
            if(sum>=target){
                return nums.length - i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {12,28,83,4,25,26,25,2,25,25,25,12};
        System.out.println(s.minSubArrayLen(213,arr));
    }
}