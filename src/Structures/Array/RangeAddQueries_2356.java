package Structures.Array;

public class RangeAddQueries_2356 {
    //the folk solution
    public int[][] rangeAddQueries_folk(int n, int[][] queries){
        int[][] ans = new int[n][n];
        for(int[] arr : queries){
            for(int i = arr[0]; i <= arr[2]; i++){
                for(int j =  arr[1]; j <= arr[3]; j++){
                    ans[i][j] ++;
                }
            }
        }
        return ans;
    }

    // two-dimension prefix_sum and difference_array
    public int[][] rangeAddQueries(int n, int[][] queries){
        int[][] diff = new int[n][n];
        int row1, col1, row2, col2;
        for(int[] arr : queries){
            row1 = arr[0];
            col1 = arr[1];
            row2 = arr[2];
            col2 = arr[3];
            diff[row1][col1] += 1;
            if (row2 + 1 < n) diff[row2+1][col1] -= 1;
            if (col2 + 1 < n) diff[row1][col2+1] -= 1;
            if (row2 + 1 < n && col2 + 1 < n) diff[row2+1][col2+1] += 1;
        }

        int[][] ans =  new int[n][n];
        ans[0][0] = diff[0][0];
        for(int i = 1; i < n; i++){
            ans[0][i] = ans[0][i-1] + diff[0][i];
            ans[i][0] = ans[i-1][0] + diff[i][0];
        }

        for(int i = 1; i < n; i++){
            for(int j = 1; j < n; j++){
                ans[i][j] = ans[i-1][j] + ans[i][j-1] -  ans[i-1][j-1] + diff[i][j];
            }
        }

        return ans;
    }
}
