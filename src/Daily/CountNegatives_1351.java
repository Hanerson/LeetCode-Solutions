package Daily;

public class CountNegatives_1351 {
    public int countNegatives(int[][] grid) {
        int ans = 0;

        for (int[] row : grid) {
            int count = 0;
            for (int j = row.length - 1; j >= 0; j--) {
                if (row[j] < 0) {
                    count++;
                } else {
                    break;
                }
            }
            ans += count;
        }
        return ans;
    }

    public int countNegatives2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int row = 0, col = n - 1;
        int ans = 0;

        while (row < m && col >= 0) {
            if (grid[row][col] < 0) {
                ans += (m - row);
                col--;
            } else {
                row++;
            }
        }
        return ans;
    }

}
