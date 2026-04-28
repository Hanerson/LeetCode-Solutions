package Daily;

import java.util.*;

public class MinHammingDistance_1722 {

    int[] parent;
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        this.parent = new int[source.length];
        Arrays.fill(parent, -1);

        for(int[] pair : allowedSwaps){
            union(pair[0], pair[1]);
        }

        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();

        for(int i = 0; i < target.length; i ++){
            int blockId = find(i);

            HashMap<Integer, Integer> temp = map.getOrDefault(blockId, new HashMap<>());
            temp.put(target[i], temp.getOrDefault(target[i], 0) + 1);
            map.put(blockId, temp);
        }

        int count = 0;

        for(int i = 0; i < source.length; i ++){
            int key = find(i);

            if(map.containsKey(key)){
                HashMap<Integer, Integer> temp = map.get(key);

                if(!temp.containsKey(source[i]) || temp.get(source[i]) <= 0){
                    count ++;
                }else{
                    temp.put(source[i], temp.get(source[i]) - 1);
                }
            }
        }

        return count;
    }

    private int find(int target){
        if(parent[target] == -1){
            return target;
        }

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
