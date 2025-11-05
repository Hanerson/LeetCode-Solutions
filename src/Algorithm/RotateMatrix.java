package Algorithm;

import java.util.ArrayList;
import java.util.List;

public class RotateMatrix {

    public List<Integer> spiralOrder_classic(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        int left=0,right=n-1,top=0,bottom=m-1;
        while(ans.size()<m*n){
            for (int i = left; i <= right && ans.size() < m * n; i++) {
                ans.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom && ans.size() < m * n; i++) {
                ans.add(matrix[i][right]);
            }
            right--;
            for (int i = right; i >= left && ans.size() < m * n; i--) {
                ans.add(matrix[bottom][i]);
            }
            bottom--;
            for (int i = bottom; i >= top && ans.size() < m * n; i--) {
                ans.add(matrix[i][left]);
            }
            left++;
        }
        return ans;
    }

    public List<Integer> spiralOrder_dir(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> ans = new ArrayList<>();

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        boolean[][] visited = new boolean[m][n];
        int x=0,y=0,dir=0;

        for (int step = 0; step < m * n; step++) {
            ans.add(matrix[x][y]);
            visited[x][y] = true;

            int nx = x + dx[dir], ny = y + dy[dir];
            // 如果下一步越界或已访问，则顺时针换方向
            if (nx < 0 || nx >= m || ny < 0 || ny >= n || visited[nx][ny]) {
                dir = (dir + 1) % 4; // 右->下->左->上->右 ...
                nx = x + dx[dir];
                ny = y + dy[dir];
            }
            x = nx;
            y = ny;
        }
        return ans;
    }

    public List<Integer> spiralOrder_byCircle(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int layers = (Math.min(m, n) + 1) / 2;

        for (int layer = 0; layer < layers; layer++) {
            int left = layer, right = n - 1 - layer;
            int top = layer, bottom = m - 1 - layer;

            for (int i = left; i <= right; i++) ans.add(matrix[top][i]);
            for (int i = top + 1; i <= bottom; i++) ans.add(matrix[i][right]);
            if (top < bottom)
                for (int i = right - 1; i >= left; i--) ans.add(matrix[bottom][i]);
            if (left < right)
                for (int i = bottom - 1; i > top; i--) ans.add(matrix[i][left]);
        }
        return ans;
    }

    public List<Integer> spiralOrder_recursion(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        spiral(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1, ans);
        return ans;
    }

    private void spiral(int[][] mat, int top, int left, int bottom, int right, List<Integer> ans) {
        if (top > bottom || left > right) return;

        for (int i = left; i <= right; i++) ans.add(mat[top][i]);
        for (int i = top + 1; i <= bottom; i++) ans.add(mat[i][right]);
        if (top < bottom)
            for (int i = right - 1; i >= left; i--) ans.add(mat[bottom][i]);
        if (left < right)
            for (int i = bottom - 1; i > top; i--) ans.add(mat[i][left]);

        spiral(mat, top + 1, left + 1, bottom - 1, right - 1, ans);
    }

    public List<Integer> spiralOrder_centerCoil(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        int total = m * n;

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        // 起点（奇数维是中心，偶数维取左上偏中心）
        int x = (m - 1) / 2;
        int y = (n - 1) / 2;
        ans.add(matrix[x][y]);

        int dir = 0;      // 初始向右
        int stepLen = 1;  // 当前步长（走两次方向后+1）

        while (ans.size() < total) {
            for (int rep = 0; rep < 2; rep++) {
                for (int s = 0; s < stepLen; s++) {
                    if (ans.size() >= total) break;
                    x += dx[dir];
                    y += dy[dir];
                    if (x >= 0 && x < m && y >= 0 && y < n) {
                        ans.add(matrix[x][y]);
                    }
                }
                dir = (dir + 1) % 4;
            }
            stepLen++;
        }
        return ans;
    }




    public static void main(String[] args){
        RotateMatrix rotateMatrix = new RotateMatrix();

        int[][] arr = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};

        for (int[] nums : arr) {
            for (int anInt : nums) {
                System.out.printf("%d\t",anInt);
            }
            System.out.print("\n");
        }

        System.out.print("\n");

        System.out.println(rotateMatrix.spiralOrder_classic(arr));
        System.out.println(rotateMatrix.spiralOrder_dir(arr));
        System.out.println(rotateMatrix.spiralOrder_byCircle(arr));
        System.out.println(rotateMatrix.spiralOrder_recursion(arr));
        if(arr.length==arr[0].length){
            System.out.println("the following is another order -- from center-coil");
            System.out.println(rotateMatrix.spiralOrder_centerCoil(arr));
        }
    }
}
