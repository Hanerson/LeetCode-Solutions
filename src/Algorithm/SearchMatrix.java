package Algorithm;

public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length,n = matrix[0].length,low = 0,high = m * n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int x = mid / n;
            int y = mid % n;

            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
    public static void main(String[] args){};
}
