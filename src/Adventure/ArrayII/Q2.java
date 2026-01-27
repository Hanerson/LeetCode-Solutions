package Adventure.ArrayII;

import java.util.Arrays;
import java.util.HashMap;

public class Q2 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();

        int[] copy = nums.clone();
        Arrays.sort(copy);

        for(int i = copy.length - 1; i >= 0; i--){
            map.put(copy[i],i);
        }

        for(int i = 0; i < nums.length; i++){
            nums[i] = map.get(nums[i]);
        }

        return nums;
    }
}
