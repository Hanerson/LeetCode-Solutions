package Basic50;

public class IsMonotonic_896 {
    public boolean isMonotonic(int[] nums) {
        if(nums.length == 1) return true;

        int prevSyn = nums[1] - nums[0];

        for(int i = 1; i < nums.length; i++){
            if(prevSyn * (nums[i] - nums[i - 1]) < 0) return false;
            prevSyn = nums[i] - nums[i - 1];
        }

        return true;
    }
}
