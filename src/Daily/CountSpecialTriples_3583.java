package Daily;

import java.util.*;

public class CountSpecialTriples_3583 {
    static final int MOD = 1000000007;

    public int specialTriplets_undirected(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int count = 0;

        for(int num : nums){
            int cnt = map.getOrDefault(num * 2, 0);

            count += cnt * (cnt + 1) / 2;
            count %= MOD;
        }

        return count;
    }


    /**
     * this is directed method for distinct i j k which statisfy 0 <= i < j < k < n
     * time complexity O(n ^ 2)
     * */
    public int specialTriplets(int[] nums) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                map.get(nums[i]).add(i);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            }
        }

        int count = 0;

        for(int i =  0; i < nums.length; i++){
            int left = 0, right = 0;

            for(int index : map.getOrDefault(nums[i] * 2, new ArrayList<>())){
                if(index < i) left ++;
                if(index > i) right ++;
            }

            count += left * right;
            count %= MOD;
        }
        return count;
    }


    /**
     * this method is faster: use two Hashmaps to record how many times the element has appeared
     * */


    public int specialTriplets_faster(int[] nums) {
        final int MOD = 1000000007;
        Map<Integer, Integer> numCnt = new HashMap<>();
        Map<Integer, Integer> numPartialCnt = new HashMap<>();

        for (int v : nums) {
            numCnt.put(v, numCnt.getOrDefault(v, 0) + 1);
        }

        long ans = 0;
        for (int v : nums) {
            int target = v * 2;
            int lCnt = numPartialCnt.getOrDefault(target, 0);
            numPartialCnt.put(v, numPartialCnt.getOrDefault(v, 0) + 1);
            int rCnt = numCnt.getOrDefault(target, 0) - numPartialCnt.getOrDefault(target, 0);
            ans = (ans + (long) lCnt * rCnt) % MOD;
        }

        return (int) ans;
    }


    public static void main(String[] args) {
        CountSpecialTriples_3583 obj = new CountSpecialTriples_3583();

        System.out.println(obj.specialTriplets(new int[]{6,3,6}));
    }
}
