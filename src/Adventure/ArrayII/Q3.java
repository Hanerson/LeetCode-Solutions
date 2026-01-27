package Adventure.ArrayII;

import java.util.*;

public class Q3 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        int[] bucket = new int[nums.length + 1];

        for(int num : nums){
            bucket[num]++;
        }

        for(int i = 1; i <= bucket.length; i++){
            if(bucket[i] == 0) ans.add(i);
        }

        return ans;
    }
}
