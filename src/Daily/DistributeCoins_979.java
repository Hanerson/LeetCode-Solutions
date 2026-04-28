package Daily;

public class DistributeCoins_979 {
    //思路是从叶子节点开始，如果叶子节点缺少就从父节点借一个（count ++），此时注意父节点可以有负数个，如果多了就全部传递给父节点
    int currCount;
    public int distributeCoins(TreeNode root) {
        currCount = 0;
        dfs(root);

        return currCount;
    }

    private int dfs(TreeNode root){
        if(root == null) return 0;

        // 左右展开之后，我希望左右子树给我传递什么信息？
        // 传递盈亏情况
        int leftCount = dfs(root.left);
        int rightCount = dfs(root.right);

        currCount += Math.abs(leftCount) + Math.abs(rightCount);

        return root.val + leftCount + rightCount - 1;// root留一个
    }
}
