package Daily;

import java.util.Arrays;

public class LargestSubMat_1727 {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        int[][] dp =new int[m][n];

        for(int pos = 0; pos < n; pos ++){
            dp[0][pos] = matrix[0][pos];
        }

        for(int i = 1; i < m; i++){
            for(int j = 0; j < n; j ++){
                if(matrix[i][j] == 1){
                    dp[i][j] = dp[i - 1][j] + 1;
                }else{
                    dp[i][j] = 0;
                }
            }
        }

        int maxArea = 0;

        for(int[] num : dp){
            Arrays.sort(num);

            for(int pos = num.length - 1; pos >= 0; pos --){
                int len = num.length - pos;

                maxArea = Math.max(maxArea, len * num[pos]);
            }
        }

        return maxArea;
    }
}
