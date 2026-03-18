package Pro100.ArraysAndStrings;

import java.util.*;

public class MaxDistance {
    public int maxDistance(List<List<Integer>> arrays) {
        int min = Integer.MAX_VALUE;
        int index = -1;

        for(int i = 0; i < arrays.size(); i++){
            if(arrays.get(i).get(0) < min){
                index = i;
                min = Math.min(min, arrays.get(i).get(0));
            }
        }

        int maxAbs = Integer.MIN_VALUE;
        int absent = arrays.get(index).get(arrays.get(index).size() - 1);

        for(int i = 0; i < arrays.size(); i ++){
            if(i == index) continue;

            List<Integer> curr = arrays.get(i);

            maxAbs = Math.max(Math.abs(curr.get(curr.size() - 1) - min), maxAbs);


            maxAbs = Math.max(Math.abs(curr.get(0) - absent), maxAbs);
        }

        return maxAbs;
    }
}
