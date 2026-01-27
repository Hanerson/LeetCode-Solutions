package Daily;

public class GetMaximumGold_1219 {
    private final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int getMaximumGold(int[][] grid) {
        int ans = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] != 0) {
                    ans = Math.max(dfs(grid, visited, i, j), ans);
                }
            }
        }
        return ans;
    }

    private int dfs(int[][] grid, boolean[][] visited, int x, int y){
        if(x < 0 || x == grid.length || y < 0 || y == grid[0].length || grid[x][y] == 0 || visited[x][y]) return 0;
        int temp = grid[x][y];
        visited[x][y] = true;
        int max = 0;

        for(int cnt = 0; cnt < 4; cnt ++){
            max = Math.max(max, dfs(grid, visited, x + dirs[cnt][0], y + dirs[cnt][1]));
        }

        visited[x][y] = false;

        return temp + max;
    }
}
