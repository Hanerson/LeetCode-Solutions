package Structures.BinaryTree;

import Structures.BinaryTree.Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class HasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum){
        if(root.left == null && root.right == null && root.val == targetSum) return true;

        int temp = targetSum - root.val;

        if(root.left != null && root.right != null) return hasPathSum(root.left , temp) || hasPathSum(root.right, temp);

        if(root.left != null) return hasPathSum(root.left, temp);
        if(root.right != null) return hasPathSum(root.right, temp);

        return false;
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        if(root == null) return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        dfs(res, root, targetSum, new ArrayList<>(), 0);
        return res;
    }

    public void dfs (List<List<Integer>> res, TreeNode root, int targetSum, List<Integer> currPath, int currSum){
        currSum += root.val;
        currPath.add(root.val);

        if(root.left == null && root.right ==null){
            if(currSum == targetSum) res.add(new ArrayList<>(currPath));
            return;
        }

        if(root.left != null) dfs(res, root.left, targetSum, currPath, currSum);
        if(root.right != null) dfs(res, root.right, targetSum, currPath, currSum);

        currPath.remove(currPath.size()-1);
    }
}
