package Structures.BinaryTree;

import Structures.BinaryTree.Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class GenerateTrees {
    public List<TreeNode>  generateTrees(int n){
        return build(1,n);
    }

    public List<TreeNode> build(int start, int end){

        List<TreeNode> res = new ArrayList<>();

        if(start > end){
            res.add(null);
            return res;
        }

        for(int i =  start; i <= end; i++){
            List<TreeNode> left = build(start, i-1);
            List<TreeNode> right =  build(i+1, end);

            for(TreeNode leftTree : left){
                for(TreeNode rightTree : right){
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
