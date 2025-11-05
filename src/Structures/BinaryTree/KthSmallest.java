package Structures.BinaryTree;

import Structures.BinaryTree.Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class KthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        helper(root, k, list);
        return list.get(list.size() - 1);
    }

    public void helper(TreeNode root, int k, List<Integer> list){

        if(root == null) return ;
        helper(root.left, k, list);
        list.add(root.val);
        if(k == list.size()){
            return;
        }
        helper(root.right, k, list);
    }
}
