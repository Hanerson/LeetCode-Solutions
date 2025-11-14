package Structures.Array;

public class PossibleToStamp_2132 {

    public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
        int m = grid.length, n = grid[0].length;

        // 构造 m+2 × n+2 的安全边界前缀和、差分数组
        int[][] prefix = buildPrefix(grid, m, n);
        int[][] diff = new int[m + 2][n + 2];

        // 1. 枚举可能放置邮票的位置
        for (int i = 1; i + stampHeight - 1 <= m; i++) {
            for (int j = 1; j + stampWidth - 1 <= n; j++) {

                int x2 = i + stampHeight - 1;
                int y2 = j + stampWidth - 1;

                // 如果区域无障碍，则在差分数组中做一个 stamp 标记
                if (rectSum(prefix, i, j, x2, y2) == 0) {
                    addStamp(diff, i, j, x2, y2);
                }
            }
        }

        // 2. 用差分数组恢复覆盖矩阵并检查是否覆盖全部空格
        return checkCoverage(diff, grid, m, n);
    }

    // ------------ 前缀和 ------------

    private int[][] buildPrefix(int[][] grid, int m, int n) {
        int[][] prefix = new int[m + 2][n + 2];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefix[i][j] = prefix[i - 1][j]
                        + prefix[i][j - 1]
                        - prefix[i - 1][j - 1]
                        + grid[i - 1][j - 1];
            }
        }
        return prefix;
    }

    // 查询 prefix 中 (x1,y1) ~ (x2,y2) 的区域和
    private int rectSum(int[][] pre, int x1, int y1, int x2, int y2) {
        return pre[x2][y2]
                - pre[x2][y1 - 1]
                - pre[x1 - 1][y2]
                + pre[x1 - 1][y1 - 1];
    }


    // ------------ 二维差分 ------------

    // 添加一个 stamp 到二维差分数组 diff
    private void addStamp(int[][] diff, int x1, int y1, int x2, int y2) {
        diff[x1][y1] += 1;
        diff[x1][y2 + 1] -= 1;
        diff[x2 + 1][y1] -= 1;
        diff[x2 + 1][y2 + 1] += 1;
    }

    // 恢复覆盖矩阵并检查所有空格是否被覆盖
    private boolean checkCoverage(int[][] diff, int[][] grid, int m, int n) {
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                diff[i][j] += diff[i - 1][j]
                        + diff[i][j - 1]
                        - diff[i - 1][j - 1];

                // 如果 grid 空格没有被任何 stamp 覆盖 → false
                if (diff[i][j] == 0 && grid[i - 1][j - 1] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
