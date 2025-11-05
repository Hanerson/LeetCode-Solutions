package Algorithm;

public class CanJump_Greedy{
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) return false;
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return true;
    }
    public static void main(String[] args){
        CanJump_Greedy canJump = new CanJump_Greedy();
        System.out.println(canJump.canJump(new int[]{3,2,1,0,4}));
    }
}
