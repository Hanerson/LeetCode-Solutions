package Daily;

import java.util.HashMap;

/**
 * a trial for voting alg
 * */

public class RepeatNTimes_961 {
    public int repeatedNTimes(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int mayor = 0;
        int maxCount = 0;
        for(int num : nums){
            if(!map.containsKey(num)){
                map.put(num, 1);
            }else{
                map.put(num, map.get(num) + 1);
                if(map.get(num) > maxCount){
                    maxCount = map.get(num);
                    mayor = num;
                }
            }
        }
        return mayor;
    }
}
