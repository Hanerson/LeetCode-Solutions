package Pro100.BackTrack;

import java.util.*;

public class GetFactors {

    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(n, 2, new ArrayList<>(), ans);
        return ans;
    }

    private void dfs(int n, int start, List<Integer> path, List<List<Integer>> ans) {
        if (n == 1) {
            if (!path.isEmpty() && path.size() != 1) {
                ans.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = start; i <= n; i++) {
            if (n % i == 0) {
                path.add(i);
                dfs(n / i, i, path, ans);
                path.remove(path.size() - 1);
            }
        }
    }
}