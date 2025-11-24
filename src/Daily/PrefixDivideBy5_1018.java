package Daily;

import java.util.ArrayList;
import java.util.List;

public class PrefixDivideBy5_1018 {
    public List<Boolean> prefixDivideBy5(int[] nums){
        List<Boolean> res = new ArrayList<>();
        int curr = 0;
        for(int num : nums){
            curr = (curr * 2 + num) % 5;
            if(curr == 0){
                res.add(true);
            }else res.add(false);
        }
        return res;
    }
}
