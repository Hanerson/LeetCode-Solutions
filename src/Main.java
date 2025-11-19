import java.util.*;

public class Main{

    static int n;
    static int[] dp;
    static int[] subSize;
    static List<List<Integer>> graph;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        dp = new int[n];
        subSize = new int[n];
        graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        dfs_dp(0, -1);
        dfs_size(0, -1);

        for (int i = 0; i < n; i++) {
            System.out.print(dp[i] + " ");
        }
    }

    private static void dfs_dp(int u, int parent) {
        subSize[u] = 1;
        for (int v : graph.get(u)) {
            if (v == parent) continue;
            dfs_dp(v, u);
            subSize[u] += subSize[v];
            dp[u] += dp[v] + subSize[v];
        }
    }

    private static void dfs_size(int u, int parent) {
        for (int v : graph.get(u)) {
            if (v == parent) continue;
            dp[v] = dp[u] + n - 2 * subSize[v];
            dfs_size(v, u);
        }
    }
}