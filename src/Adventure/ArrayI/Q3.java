package Adventure.ArrayI;

public class Q3 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int curr = 0;
        int max = 0;
        for(int num : nums){
            if(num == 1){
                curr++;
                max = Math.max(max, curr);
            }else{
                curr = 0;
            }
        }

        return max;
    }
}
