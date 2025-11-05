package Structures.BinaryTree;

import Structures.BinaryTree.Utils.TreeNode;

public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return true;
        TreeNode A = root.left;
        TreeNode B = root.right;

        return check(A, B);
    }

    public boolean check(TreeNode A, TreeNode B){
        if(A == null && B == null) return true;
        if(A == null || B == null) return false;
        if(A.val != B.val) return false;

        return check(A.left, B.right) && check(A.right, B.left);
    }
}
