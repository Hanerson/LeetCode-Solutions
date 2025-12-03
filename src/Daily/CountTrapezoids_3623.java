package Daily;

import java.util.*;

public class CountTrapezoids_3623 {
    static final int MOD = 10000007;

    public int countTrapezoids(int[][] points){
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> keys = new ArrayList<>();

        for(int[] point : points){
            if(map.containsKey(point[1])){
                map.put(point[1], map.get(point[1])+1);
            }else{
                map.put(point[1], 1);
                keys.add(point[1]);
            }
        }

        int sum = 0;

        for(int k1 : keys){
            for(int k2 : keys){
                if(k1 == k2) continue;

                sum += comb(map.get(k1)) *  comb(map.get(k2));
                sum %= MOD;
            }
        }
        return sum/2;
    }

    private int comb(int k){
        return k * (k - 1)/2;
    }
}
