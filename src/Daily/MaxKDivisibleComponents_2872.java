package Daily;

import java.util.ArrayList;
import java.util.List;

public class MaxKDivisibleComponents_2872 {
    private int k;
    private int maxBlocks = 0;

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        this.k = k;
        List<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for(int[] e : edges){
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        dfs(0, -1, values, graph);
        return maxBlocks;
    }

    private long dfs(int u, int parent, int[] values, List<Integer>[] graph){
        long sum = values[u];
        for(int v : graph[u]){
            if(v == parent) continue;
            long childSum = dfs(v, u, values, graph);
            sum += childSum;
        }
        if(sum % k == 0){
            maxBlocks++;
            return 0;
        }
        return sum;
    }
}
