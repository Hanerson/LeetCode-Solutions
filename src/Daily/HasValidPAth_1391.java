package Daily;
import java.util.*;

public class HasValidPAth_1391 {
    public boolean hasValidPath(int[][] grid) {
        int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        int[][] type = {
                {},
                {0, 1},    // 1：左右
                {2, 3},    // 2：上下
                {0, 3},    // 3：左下
                {1, 3},    // 4：右下
                {0, 2},    // 5：左上
                {1, 2}     // 6：右上
        };

        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            if (x == m - 1 && y == n - 1) return true;

            for (int d : type[grid[x][y]]) {
                int nx = x + dirs[d][0];
                int ny = y + dirs[d][1];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n || visited[nx][ny]) continue;

                int reverseDir = d ^ 1;
                if (contains(type[grid[nx][ny]], reverseDir)) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        return false;
    }
    private boolean contains(int[] arr, int target) {
        for (int num : arr) {
            if (num == target) return true;
        }
        return false;
    }
}