package Pro100.AreaSet;
import java.util.*;

public class MissingAreasSets {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> ans = new ArrayList<>();

        if(upper == lower && nums.length == 1) return ans;
        if(upper == lower){
            List<Integer> ohmygod = new ArrayList<>();

            ohmygod.add(lower);
            ohmygod.add(upper);

            ans.add(ohmygod);
            return ans;
        }

        if(nums.length == 0){
            List<Integer> list = new ArrayList<>();

            list.add(lower);
            list.add(upper);

            ans.add(list);
            return ans;
        }

        if(lower < nums[0]){
            List<Integer> list0 = new ArrayList<>();

            list0.add(lower);
            list0.add(nums[0] - 1);

            ans.add(list0);
        }

        for(int i = 1; i < nums.length; i++){
            if(nums[i] - 1 >= nums[i - 1] + 1){
                List<Integer> tempList = new ArrayList<>();

                tempList.add(nums[i - 1] + 1);
                tempList.add(nums[i] - 1);

                ans.add(tempList);
            }
        }

        if(upper > nums[nums.length - 1]){
            List<Integer> list1 = new ArrayList<>();

            list1.add(nums[nums.length - 1] + 1);
            list1.add(upper);

            ans.add(list1);
        }

        return ans;
    }
}
