package Daily;

import java.util.HashMap;

public class MinDistance_3761 {
    public int minMirrorPairDistance(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int minDis = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i ++){
            if(map.containsKey(nums[i])){
                minDis = Math.min(minDis, Math.abs(i - map.get(nums[i])));
            }
            map.put(reverse(nums[i]), i);
        }

        return minDis == Integer.MAX_VALUE ? -1 : minDis;
    }

    private int reverse(int x){
        String xs = String.valueOf(x);

        StringBuilder sb = new StringBuilder();
        boolean head = true;

        for(int pos = xs.length(); pos >= 0; pos --){
            if(head && xs.charAt(pos) == '0') continue;

            head = false;
            sb.append(xs.charAt(pos));
        }

        return Integer.parseInt(sb.toString());
    }
}
