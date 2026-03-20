package Daily;

import java.util.*;

public class MInDiffAbs_3567 {
    //first method for direct calculate
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;

        int[][] ans = new int[m - k + 1][n - k + 1];

        for(int i = 0; i <= m - k; i++){
            for(int j = 0; j <= n - k; j++){
                ans[i][j] = calculate(grid, k ,i, j);
            }
        }

        return ans;
    }

    private int calculate(int[][] grid, int k, int x ,int y){
        List<Integer> list = new ArrayList<>();

        for(int i = x; i < x + k; i++){
            for(int j = y; j < y + k; j++){
                list.add(grid[i][j]);
            }
        }

        list.sort((a, b) -> a - b);

        int ans = Integer.MAX_VALUE;
        for(int i = 1; i < list.size(); i++){
            ans = Math.min(ans, list.get(i) - list.get(i - 1));
        }

        return ans;
    }
}
