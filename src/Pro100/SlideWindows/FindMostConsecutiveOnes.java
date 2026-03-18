package Pro100.SlideWindows;

public class FindMostConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int zeroCount = 0;

        int slow = 0, fast = 0;
        int maxLen = 0;

        while(fast < nums.length){
            if(nums[fast] == 0){
                zeroCount++;
                while(zeroCount > 1){
                    if(nums[slow] == 0){
                        zeroCount --;
                    }

                    slow ++;
                }
            }
            maxLen = Math.max(maxLen, fast - slow + 1);
            fast ++;
        }

        return maxLen;
    }
}
