package Daily;

import java.util.*;

public class FindXSum_3318 {

    //first method for small scale of test cases, bucketSort
    public int[] findXSumA(int[] nums, int k, int x) {
        int[] ans = new int[nums.length - k + 1];

        for(int i = 0; i <= nums.length - k; i++){
            ans[i] = findAtomicXSum(nums, k, x, i);
        }

        return ans;
    }

    private int findAtomicXSum(int[] nums, int k, int x, int pos){
        ArrayList<Integer>[] buckets = new ArrayList[k + 1];

        for(int i = 0; i <= k; i++){
            buckets[i] = new ArrayList<>();
        }

        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int i = pos; i < pos + k; i ++){
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        for(int key : freq.keySet()){
            int f = freq.get(key);
            buckets[f].add(key);
        }

        int count = 0, sum = 0;
        for(int i = k; i >= 1; i--){
            buckets[i].sort((a, b) -> (b - a));
            for(int num : buckets[i]){
                count ++;
                sum += num * i;

                if(count == x) return sum;
            }
        }

        return sum;
    }

    //notice: a better solution is presented in the enhanced version of test cases which gains a larger scale
    //get to read at problem 3321
}
