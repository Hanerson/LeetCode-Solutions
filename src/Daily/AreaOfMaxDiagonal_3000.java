package Daily;

public class AreaOfMaxDiagonal_3000 {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int max = Integer.MIN_VALUE;
        long lengthMax = 0;
        for(int[] mat : dimensions){
            long temp = (long) mat[0] * mat[0] + (long) mat[1] * mat[1];
            if(temp >= lengthMax){
                if(temp == lengthMax) max = Math.max(max, mat[0] * mat[1]);
                else max = mat[0] * mat[1];

                lengthMax = temp;
            }
        }

        return max;
    }
}
