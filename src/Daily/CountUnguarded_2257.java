package Daily;

public class CountUnguarded_2257 {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];

        for (int[] g : guards) grid[g[0]][g[1]] = 1;
        for (int[] w : walls)  grid[w[0]][w[1]] = 2;

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int[] g : guards) {
            for (int[] d : directions) {
                int r = g[0] + d[0];
                int c = g[1] + d[1];

                while (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] != 1 && grid[r][c] != 2) {
                    grid[r][c] = 3; // Mark as guarded
                    r += d[0];
                    c += d[1];
                }
            }
        }

        // Count cells that remain 0
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) count++;
            }
        }
        return count;
    }
}
