package Pro100.Hash;

import java.util.*;

public class MinCommonElement {
    public int smallestCommonElement(int[][] mat) {
        List<HashSet<Integer>> maps = new ArrayList<>();

        for(int i = 0; i < mat.length; i ++){
            maps.add(new HashSet<>());
        }

        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j ++){
                maps.get(i).add(mat[i][j]);
            }
        }

        int minCommon = -1;

        for(int num : mat[0]){
            if(canFind(maps, num)){
                minCommon = num;
                break;
            }
        }

        return minCommon;
    }

    private boolean canFind(List<HashSet<Integer>> maps, int target){
        boolean find = true;
        for (HashSet<Integer> map : maps) if (!map.contains(target)) return false;
        return find;
    }
}
