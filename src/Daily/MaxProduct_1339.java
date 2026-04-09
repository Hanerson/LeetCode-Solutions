package Daily;

import java.util.ArrayList;
import java.util.List;

public class MaxProduct_1339 {
    private static final int MOD = 1_000_000_007;
    private long ans = 0;

    public int maxProduct(TreeNode root) {
        int total = dfs1(root);
        dfs2(root, total);
        return (int) (ans % MOD);
    }

    private int dfs1(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.val + dfs1(node.left) + dfs1(node.right);
    }

    private int dfs2(TreeNode node, int total) {
        if (node == null) {
            return 0;
        }
        int s = node.val + dfs2(node.left, total) + dfs2(node.right, total);
        ans = Math.max(ans, (long) s * (total - s));
        return s;
    }
}
