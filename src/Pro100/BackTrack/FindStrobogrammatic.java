package Pro100.BackTrack;

import java.util.*;

public class FindStrobogrammatic {

    public List<String> findStrobogrammatic(int n) {
        return dfs(n, n);
    }

    private List<String> dfs(int n, int total) {
        // base case
        if (n == 0) return Arrays.asList("");
        if (n == 1) return Arrays.asList("0", "1", "8");

        List<String> sub = dfs(n - 2, total);
        List<String> res = new ArrayList<>();

        for (String s : sub) {
            if (n != total) {
                res.add("0" + s + "0"); // 不能作为最外层
            }
            res.add("1" + s + "1");
            res.add("6" + s + "9");
            res.add("9" + s + "6");
            res.add("8" + s + "8");
        }

        return res;
    }
}