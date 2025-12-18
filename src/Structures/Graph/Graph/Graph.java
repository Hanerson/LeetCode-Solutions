package Structures.Graph.Graph;

import java.util.ArrayList;
import java.util.List;


public class Graph {
    private final int V;
    private int E;
    private final ArrayList<ArrayList<Edge>> graph;

    public Graph(int v){
        this.V = v;
        this.E = 0;
        this.graph = new ArrayList<>(v);

        for(int i = 0; i < v; i++){
            graph.add(new ArrayList<>());
        }
    }

    /** 加权边 */
    public void addEdge(int u, int v, int w){
        graph.get(u).add(new Edge(v, w));
        this.E++;
    }

    /** 无权边（默认权重 1） */
    public void addEdge(int u, int v){
        graph.get(u).add(new Edge(v, 1));
        this.E++;
    }

    /** 批量加边 {u, v, w} 或 {u, v} */
    public void addEdge(List<int[]> edges){
        for(int[] e : edges){
            if(e.length == 3) addEdge(e[0], e[1], e[2]);
            else addEdge(e[0], e[1]);
        }
    }

    /** 判断 u→v 是否存在边 */
    public boolean containsEdge(int u, int v){
        for (Edge e : graph.get(u)) {
            if (e.to == v) return true;
        }
        return false;
    }

    public int getV(){ return V; }
    public int getE(){ return E; }

    /** 返回可遍历邻居的 Iterable，而不暴露内部结构 */
    public Iterable<Edge> adj(int u){
        return graph.get(u);
    }
}


class Edge {
    public final int to;
    public final int weight;

    public Edge(int to, int weight){
        this.to = to;
        this.weight = weight;
    }
}
