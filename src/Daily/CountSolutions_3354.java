package Daily;

public class CountSolutions_3354 {
    public int countValidSelections(int[] nums) {
        int len = nums.length;

        int[] prefix =  new int[len + 1];

        prefix[0] = 0;
        for(int i = 0; i < len; i++){
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int ans = 0;

        for(int i = 0; i < len; i++){
            if(nums[i] == 0){
                if(Math.abs(prefix[i] - (prefix[len] - prefix[i])) == 1) ans += 1;
                else if(prefix[len] == 2 * prefix[i]) ans += 2;
            }
        }

        return ans;
    }
}
