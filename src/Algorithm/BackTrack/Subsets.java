package Algorithm.BackTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets{
    public List<List<Integer>> generate(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(res, nums, 0, new ArrayList<>());
        return res;
    }

    public void backtrack(List<List<Integer>> res, int[] nums, int depth, List<Integer> curr){
        if(depth == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }

        int count = 0;
        while(depth + count < nums.length && nums[depth] == nums[depth+count]){
            count ++;
        }

        backtrack(res,nums,depth+count,curr);

        for(int i = 1;i <= count; i++){
            curr.add(nums[depth]);
            backtrack(res,nums,depth+count,curr);
        }

        for(int i = 1;i <= count;i++){
            curr.remove(curr.size()-1);
        }
    }

    public static void main(String[] args){
        Subsets s = new Subsets();
        System.out.println(s.generate(new int[]{1,2,2}));
    }
}
