package Structures.BinaryTree;

import Structures.BinaryTree.Utils.TreeNode;

public class InvertTree {
    public TreeNode invertTree(TreeNode root){
        dfs(root);
        return root;
    }

    public void dfs(TreeNode root){
        if(root.left != null && root.right != null){
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        if(root.left != null) dfs(root.left);
        if(root.right != null) dfs(root.right);
    }
}
