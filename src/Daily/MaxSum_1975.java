package Daily;

public class MaxSum_1975 {
    public long maxMatrixSum(int[][] matrix) {
        int countOfNeg = 0;
        int minAbs = Integer.MAX_VALUE;
        long sum = 0;
        for(int[] mat : matrix){
            for(int num : mat){
                if(num > 0){
                    sum += num;
                }else if(num < 0){
                    countOfNeg++;
                    sum -= num;
                }
                if(Math.abs(num) < minAbs) minAbs = Math.abs(num);
            }
        }
        return (countOfNeg % 2 == 0) ? (sum) : sum - 2L * minAbs;
    }

    public static void main(String[] args) {
        MaxSum_1975 m = new MaxSum_1975();

        int[][] mat =  new int[][]{
                {1, 2, 3}, {-1, -2, -3}, {1, 2, 3}
        };

        System.out.println(m.maxMatrixSum(mat));
    }
}
