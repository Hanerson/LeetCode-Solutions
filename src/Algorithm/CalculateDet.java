package Algorithm;

public class CalculateDet {
    public int calculate(int[][] determinant) {
        if (determinant == null || determinant.length == 0) return 0;
        if (determinant.length == 1) return determinant[0][0];
        if (determinant.length == 2) {
            return determinant[0][0] * determinant[1][1] -
                    determinant[0][1] * determinant[1][0];
        }

        int n = determinant.length;
        int[][][] splits = new int[n][n-1][n-1]; // 每个子矩阵

        // 构造子矩阵
        for (int col = 0; col < n; col++) {
            int subRow = 0;
            for (int row = 1; row < n; row++) {
                int subCol = 0;
                for (int k = 0; k < n; k++) {
                    if (k == col) continue;
                    splits[col][subRow][subCol] = determinant[row][k];
                    subCol++;
                }
                subRow++;
            }
        }

        // 按第一行展开
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int cofactor = (i % 2 == 0 ? 1 : -1) * determinant[0][i];
            sum += cofactor * calculate(splits[i]);
        }
        return sum;
    }
    public static void main(String[] args){
        CalculateDet calculateDet = new CalculateDet();
        int[][] determinant = new int[][]{
                {-2,2,3,0},{0,-1,0,1},{1,3,4,-2},{-1,1,2,3}
        };
        System.out.println(calculateDet.calculate(determinant));
    }
}
