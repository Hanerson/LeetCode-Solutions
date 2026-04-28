package Daily;

import java.util.*;

public class Distance_2615_bruteForce {

    HashMap<Integer, List<Integer>> map = new HashMap<>();
    public long[] distance(int[] nums) {
        mapInit(nums);

        long[] ans = new long[nums.length];

        for(int i = 0; i < nums.length; i ++){
            ans[i] = getDistance(i, nums);
        }

        return ans;
    }

    private long getDistance(int index, int[] nums){
        long ans = 0;

        /*for(int i = 0; i < nums.length; i ++){
            if(i == index) continue;

            if(nums[i] == nums[index]){
                ans += Math.abs(i - index);
            }
        }*/

        List<Integer> list = map.get(nums[index]);

        for(int idx : list){
            ans += Math.abs(idx - index);
        }

        return ans;
    }
    private void mapInit(int[] nums){
        for(int i = 0; i < nums.length; i ++){
            if(map.containsKey(nums[i])){
                map.get(nums[i]).add(i);
            }else{
                List<Integer> temp = new ArrayList<>();

                temp.add(i);
                map.put(nums[i], temp);
            }
        }
    }
}
