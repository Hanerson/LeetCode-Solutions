package Daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LastDayToCross_1970 {
    public int latestDayToCross(int row, int col, int[][] cells) {
        int[][] matrix = new int[row + 1][col + 1];
        for(int[] ints : matrix){
            Arrays.fill(ints, 0);
        }

        int count = 0;

        for(int[] cell : cells){
            matrix[cell[0]][cell[1]] = 1;
            if(!dfs(matrix, 1, col, 0)) return count;
            count ++;
        }

        return count;
    }

    private boolean dfs(int[][] matrix, int left, int right, int depth){
        if(depth == matrix.length - 1) return true;
        if(left > right) return false;

        List<Integer> division = new ArrayList<>();
        for(int i = left + 1; i < right; i++){
            if(matrix[depth + 1][i] == 1){
                division.add(i);
            }
        }

        List<int[]> available = new ArrayList<>();
        for(int i = 0; i < division.size() - 1; i++){
            available.add(new int[]{division.get(i) + 1, division.get(i + 1) - 1});
        }

        if(matrix[depth + 1][left] == 0){
            int leftDivision = left - 1;
            while(leftDivision > 0 && matrix[depth + 1][leftDivision] == 0){
                leftDivision--;
            }
            available.add(new int[]{leftDivision + 1, division.get(0) - 1});
        }

        if(matrix[depth + 1][right] == 0){
            int rightDivision = right + 1;
            while(rightDivision < matrix[0].length &&  matrix[depth + 1][rightDivision] == 0){
                rightDivision++;
            }
            available.add(new int[]{division.get(division.size() - 1) + 1, rightDivision - 1});
        }

        boolean result = false;

        for(int[] area : available){
            result |= dfs(matrix, area[0], area[1], depth + 1);
        }

        return result;
    }
}
