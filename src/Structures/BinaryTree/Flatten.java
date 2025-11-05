package Structures.BinaryTree;

import Structures.BinaryTree.Utils.TreeNode;

public class Flatten {
    public void flatten(TreeNode node){
        if(node == null) return;

        flatten(node.left);
        flatten(node.right);

        if(node.left != null){
            TreeNode tempRight = node.right;
            node.right = node.left;

            node.left = null;

            TreeNode cur = node.right;
            while(cur.right != null){
                cur = cur.right;
            }
            cur.right = tempRight;
        }
    }
}
