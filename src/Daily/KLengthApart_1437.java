package Daily;

public class KLengthApart_1437 {
    public boolean kLengthApart(int[] nums, int k) {
        int apart = k;
        for(int num : nums){
            if(num == 1){
                if(apart < k) return false;
                apart = 0;
            }else{
                apart ++;
            }
        }
        return true;
    }
}
