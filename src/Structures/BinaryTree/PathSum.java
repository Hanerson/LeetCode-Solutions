package Structures.BinaryTree;

import Structures.BinaryTree.Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSum {
    public int pathSum(TreeNode root, int targetSum) {
        List<TreeNode> list = new ArrayList<>();
        collectNodes(root, list);
        int[] count = new int[1];
        for(TreeNode node: list){
            dfs(node, count, 0,  targetSum);
        }
        return count[0];
    }

    private void collectNodes(TreeNode root, List<TreeNode> list){
        if(root == null) return;
        list.add(root);
        collectNodes(root.left,list);
        collectNodes(root.right,list);
    }

    private void dfs(TreeNode root, int[] count, long currSum, int targetSum) {
        if (root == null) return;

        currSum += root.val;

        if (currSum == targetSum) count[0]++;

        dfs(root.left, count, currSum, targetSum);
        dfs(root.right, count, currSum, targetSum);
    }

}
