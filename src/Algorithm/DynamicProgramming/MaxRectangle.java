package Algorithm.DynamicProgramming;

public class MaxRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = (j == 0) ? 1 : dp[i][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 0) continue;
                int minWidth = dp[i][j];
                for (int k = i; k >= 0; k--) {
                    if (dp[k][j] == 0) break;
                    minWidth = Math.min(minWidth, dp[k][j]);
                    int height = i - k + 1;
                    max = Math.max(max, minWidth * height);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaxRectangle obj = new MaxRectangle();
        System.out.println(obj.maximalRectangle(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}}));
    }
}
