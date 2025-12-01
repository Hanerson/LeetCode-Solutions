package Structures.HighLevelStructures;

import java.util.Arrays;

public class DisjointSet {
    int[] parent;

    public DisjointSet(int size){
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
