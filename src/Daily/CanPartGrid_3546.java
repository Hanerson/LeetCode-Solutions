package Daily;

public class CanPartGrid_3546 {
    public boolean canPartitionGrid(int[][] grid) {
        long[] rowSum = new long[grid.length];
        long[] colSum = new long[grid[0].length];

        for(int i = 0; i < grid.length; i ++){
            for(int j = 0; j < grid[0].length; j ++){
                int curr = grid[i][j];

                rowSum[i] += curr;
                colSum[j] += curr;
            }
        }

        return check(rowSum) || check(colSum);
    }

    private boolean check(long[] parts){
        long sum = 0;
        for (long x : parts) sum += x;

        if (sum % 2 != 0) return false;

        long cur = 0;
        for (int i = 0; i < parts.length - 1; i++) {
            cur += parts[i];
            if (cur * 2 == sum) return true;
        }

        return false;
    }
}
