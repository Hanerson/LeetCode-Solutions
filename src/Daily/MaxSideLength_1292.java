package Daily;

public class MaxSideLength_1292 {

    int[][] prefixSum;

    public int maxSideLength(int[][] mat, int threshold) {

        int m = mat.length, n = mat[0].length;

        prefixSum = new int[m + 1][n + 1];

        // 构建二维前缀和
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                prefixSum[i][j] = mat[i - 1][j - 1]
                        + prefixSum[i - 1][j]
                        + prefixSum[i][j - 1]
                        - prefixSum[i - 1][j - 1];
            }
        }

        int left = 0, right = Math.min(m, n);

        // 二分答案
        while(left < right){

            int mid = left + (right - left + 1) / 2;

            if(check(mat, mid, threshold)){
                left = mid;
            }else{
                right = mid - 1;
            }
        }

        return left;
    }

    private boolean check(int[][] mat, int length, int threshold){

        for(int i = 1; i <= mat.length - length + 1; i++){
            for(int j = 1; j <= mat[0].length - length + 1; j++){

                int sum =
                        prefixSum[i + length - 1][j + length - 1]
                                - prefixSum[i - 1][j + length - 1]
                                - prefixSum[i + length - 1][j - 1]
                                + prefixSum[i - 1][j - 1];

                if(sum <= threshold){
                    return true;
                }
            }
        }

        return false;
    }
}