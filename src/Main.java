import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] edges = new int[m][2];
        for (int i = 0; i < m; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }

        boolean flag = containsCycle(n, edges);

        System.out.println(flag ? "YES" : "NO");
    }

    private static boolean containsCycle(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && dfsHasCycle(adj, visited, i, -1)) {
                return true;
            }
        }
        return false;
    }

    private static boolean dfsHasCycle(List<List<Integer>> adj, boolean[] visited, int curr, int parent) {
        visited[curr] = true;
        for (int neighbor : adj.get(curr)) {
            if (!visited[neighbor]) {
                if (dfsHasCycle(adj, visited, neighbor, curr)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }
}