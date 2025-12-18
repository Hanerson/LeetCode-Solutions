package Daily;

import java.util.HashSet;

public class GetNumbers_3289 {
    public int[] GetSneakyNumbers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        int count = 0;
        int[] ans = new int[2];

        for(int num : nums){
            if(set.contains(num)){
                ans[count] = num;
                count ++;
            }else set.add(num);
        }

        return ans;
    }
}
