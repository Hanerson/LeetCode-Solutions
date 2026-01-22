package Daily;

public class MaxLen_3459 {

    private final int[][] dirs = {
            {1, 1}, {1, -1}, {-1, -1}, {-1, 1}
    };

    private int n, m;
    private int[][] grid;

    public int lenOfVDiagonal(int[][] grid) {
        this.grid = grid;
        this.n = grid.length;
        this.m = grid[0].length;

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dirs[d][0];
                        int ny = j + dirs[d][1];

                        ans = Math.max(ans,
                                1 + dfs(nx, ny, 2, d, false)
                        );
                    }
                }
            }
        }
        return ans;
    }

    private int dfs(int x, int y, int expected, int dir, boolean turned) {
        if (x < 0 || x >= n || y < 0 || y >= m) {
            return 0;
        }

        if (grid[x][y] != expected) {
            return 0;
        }

        int best = 0;
        best = Math.max(best,
                dfs(
                        x + dirs[dir][0],
                        y + dirs[dir][1],
                        expected == 2 ? 0 : 2,
                        dir,
                        turned
                )
        );
        if (!turned) {
            int nextDir = (dir + 1) % 4;
            best = Math.max(best,
                    dfs(
                            x + dirs[nextDir][0],
                            y + dirs[nextDir][1],
                            expected == 2 ? 0 : 2,
                            nextDir,
                            true
                    )
            );
        }

        return best + 1;
    }
}
