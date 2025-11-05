package Structures.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class OrangeRotting {
    public int orangesRotting(int[][] grid) {
        if (grid.length == 0) return 0;
        int row = grid.length, col = grid[0].length, fresh = 0;
        Queue<int[]> rot = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                switch (grid[i][j]) {
                    case 1: fresh++; break;
                    case 2: rot.offer(new int[]{i, j}); break;
                    default: break;
                }
            }
        }

        int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
        int count = 0;

        while (!rot.isEmpty() && fresh != 0) {
            int k = rot.size();
            for (int g = 0; g < k; g++) {
                int[] cur = rot.poll();
                int i = cur[0], j = cur[1];
                for (int dir = 0; dir < 4; dir++) {
                    int x = i + dx[dir];
                    int y = j + dy[dir];
                    if (x >= 0 && x < row && y >= 0 && y < col && grid[x][y] == 1) {
                        fresh--;
                        grid[x][y] = 2;
                        rot.offer(new int[]{x, y});
                    }
                }
            }
            count++;
        }

        return (fresh == 0) ? count : -1;
    }
}
