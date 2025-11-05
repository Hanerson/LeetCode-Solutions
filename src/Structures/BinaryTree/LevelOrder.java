package Structures.BinaryTree;

import Structures.BinaryTree.Utils.TreeNode;

import java.util.*;

public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root){
        if(root == null) return null;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        level.add(root.val);
        res.add(level);
        boolean flag = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!flag){
            flag = false;
            List<Integer> temp = new ArrayList<>();
            Queue<TreeNode> tempQueue = new LinkedList<>();
            while(!queue.isEmpty()){
                TreeNode node = queue.poll();
                if(node.left != null){
                    tempQueue.offer(node.left);
                    temp.add(node.left.val);
                    flag = true;
                }
                if(node.right != null){
                    tempQueue.offer(node.right);
                    temp.add(node.right.val);
                    flag = true;
                }
            }
            res.add(temp);
            queue = tempQueue;
        }
        return res;
    }
}
