package Structures.Graph.MST;

import java.util.*;

public class MST {
    List<List<Edge>> graph;
    int N;

    public MST(List<List<Edge>> graph, int N){
        this.graph = graph;
        this.N = N;
    }

    private int prim(){
        boolean[] visited = new boolean[N + 1];
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));

        int start = 1;
        visited[start] = true;

        for(Edge e :  graph.get(start)) pq.offer(e);
        int count = 1;
        int totalWeight = 0;

        while(!pq.isEmpty() && count < N){
            Edge curr =  pq.poll();
            if(visited[curr.to]) continue;

            visited[curr.to] = true;
            totalWeight += curr.weight;
            count++;

            for(Edge e : graph.get(curr.to)){
                if(!visited[e.to]){
                    pq.offer(e);
                }
            }
        }

        return (count == N) ? totalWeight : -1;
    }

    static int[] parent;
    static int[] rank;

    private int kruskal(){
        Edge[] edges = new Edge[N + 1];
        int pos = 0;

        for(List<Edge> Edges: graph){
            for(Edge e: Edges){
                edges[pos] = e;
                pos ++;
            }
        }

        Arrays.sort(edges);

        parent = new int[N + 1];
        rank = new int[N + 1];
        for(int i = 1; i <= N; i++) parent[i] = i;

        int totalWeight = 0;
        int count = 0;

        for(Edge e : edges){
            if(find(e.from) != find(e.to)){
                union(e.from, e.to);
                totalWeight += e.weight;
                count++;
            }
        }

        if(count != N - 1) return -1;
        return totalWeight;
    }

    private static int find(int x){
        if(parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    private static void union(int x, int y){
        int fx = find(x);
        int fy = find(y);
        if(fx == fy) return;
        if(rank[fx] < rank[fy]){
            parent[fx] = fy;
        } else if(rank[fx] > rank[fy]){
            parent[fy] = fx;
        } else {
            parent[fy] = fx;
            rank[fx]++;
        }
    }
}
