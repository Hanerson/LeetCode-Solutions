package Daily;

import java.util.Arrays;

public class ContainsCycle_1559_UnionFind {
    int[] parent;

    public boolean containsCycle(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        init(rows * cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int currVec = i * cols + j;
                char currChar = grid[i][j];
                if (j + 1 < cols && grid[i][j + 1] == currChar) {
                    int rightVec = i * cols + (j + 1);
                    if (find(rightVec) == find(currVec)) {
                        return true;
                    }
                    union(rightVec, currVec);
                }

                if (i + 1 < rows && grid[i + 1][j] == currChar) {
                    int downVec = (i + 1) * cols + j;
                    if (find(downVec) == find(currVec)) {
                        return true;
                    }
                    union(downVec, currVec);
                }
            }
        }
        return false;
    }
    public void init(int size){
        parent = new int[size];
        Arrays.fill(parent,-1);
    }

    public int find(int target){
        if(parent[target] < 0) return target;
        return parent[target] = find(parent[target]);
    }

    public void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);

        if(rootA == rootB) return;

        if (parent[rootA] < parent[rootB]) {
            parent[rootB] = rootA;
        } else {
            if (parent[rootA] == parent[rootB]) {
                parent[rootB]--;
            }
            parent[rootA] = rootB;
        }
    }
}
