package Daily;
import java.util.*;

public class SortMat_3446 {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        for (int j = 1; j < n; j++) {
            List<Integer> list = new ArrayList<>();
            int x = 0, y = j;
            while (x < n && y < n) {
                list.add(grid[x][y]);
                x++;
                y++;
            }
            Collections.sort(list);

            x = 0;
            y = j;
            for (int num : list) {
                grid[x][y] = num;
                x++;
                y++;
            }
        }

        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            int x = i, y = 0;
            while (x < n && y < n) {
                list.add(grid[x][y]);
                x++;
                y++;
            }
            list.sort((a, b) -> b - a);

            x = i;
            y = 0;
            for (int num : list) {
                grid[x][y] = num;
                x++;
                y++;
            }
        }

        return grid;
    }
}
