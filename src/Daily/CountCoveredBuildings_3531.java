package Daily;

import java.util.Arrays;
import java.util.HashMap;

public class CountCoveredBuildings_3531 {

    /**
     * 这一种方法是按照类似于围棋的计算方法来判断是否被覆盖的
     * */

    public int countCoveredBuildings(int n, int[][] buildings) {
        HashMap<Long, Integer> map = new HashMap<>();

        int count = 0;
        for (int[] point : buildings) {
            count += getCovered(map, point);
        }

        return count;
    }

    private int getCovered(HashMap<Long, Integer> map, int[] point) {
        int x = point[0], y = point[1];

        long[] keys = new long[4];

        keys[0] = (((long)(x + 1)) << 32) | (y & 0xffffffffL);
        keys[1] = (((long)(x - 1)) << 32) | (y & 0xffffffffL);
        keys[2] = (((long)x) << 32) | ((y + 1) & 0xffffffffL);
        keys[3] = (((long)x) << 32) | ((y - 1) & 0xffffffffL);

        int alive = 4;
        int count = 0;

        for (long key : keys) {
            if (map.containsKey(key)) {
                alive--;
                int newVal = map.get(key) - 1;
                map.put(key, newVal);
                if (newVal == 0) count++;
            }
        }

        long selfKey = (((long)x) << 32) | (y & 0xffffffffL);
        map.put(selfKey, alive);

        return count + (alive == 0 ? 1 : 0);
    }


    /**
     * 这一种方法是按照只要某一个方向有建筑，则该方向就被认为堵死
     * */

    public int countCoveredBuildings2(int n, int[][] buildings) {
        int[] maxRow = new int[n + 1];
        int[] minRow = new int[n + 1];
        int[] maxCol = new int[n + 1];
        int[] minCol = new int[n + 1];

        Arrays.fill(minRow, n + 1);
        Arrays.fill(minCol, n + 1);

        for (int[] p : buildings) {
            int x = p[0], y = p[1];
            maxRow[y] = Math.max(maxRow[y], x);
            minRow[y] = Math.min(minRow[y], x);
            maxCol[x] = Math.max(maxCol[x], y);
            minCol[x] = Math.min(minCol[x], y);
        }

        int res = 0;
        for (int[] p : buildings) {
            int x = p[0], y = p[1];
            if (x > minRow[y] && x < maxRow[y] &&
                    y > minCol[x] && y < maxCol[x]) {
                res++;
            }
        }

        return res;
    }
}

