package Daily;

import java.util.ArrayList;
import java.util.List;

public class ZeroFilledSubarray_2348 {
    public long zeroFilledSubarray(int[] nums) {
        List<Integer> list = new ArrayList<>();

        int currLen = 0;

        for(int num : nums){
            if(num == 0){
                currLen++;
            }else{
                list.add(currLen);
                currLen = 0;
            }
        }

        list.add(currLen);

        long res = 0;

        for(int op : list){
            res += cal(op);
        }

        return res;
    }

    private long cal(int num){
        return (long)num * (num + 1) / 2;
    }
}
