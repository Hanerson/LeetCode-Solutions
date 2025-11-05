package Algorithm.BackTrack;

import java.util.List;

/**
 * another method of dp is shown in package .Algorithm.DynamicProgramming
 * */

public class MinimumTotal {
    public int minimumTotal_backTrack(List<List<Integer>> triangle) {
        return backTrack(triangle, 0,0,triangle.get(0).get(0));
    }

    public int backTrack(List<List<Integer>> triangle, int x, int y,int curr){
        if(x==triangle.size()-1) return curr;
        else{
            return Math.min(backTrack(triangle, x+1, y, curr+triangle.get(x+1).get(y)), backTrack(triangle,x+1, y+1, curr+triangle.get(x+1).get(y+1)));
        }
    }
}
