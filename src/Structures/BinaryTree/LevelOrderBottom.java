package Structures.BinaryTree;

import Structures.BinaryTree.Utils.TreeNode;

import java.util.*;

public class LevelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root){

        if(root==null) return new ArrayList<>();

        int[] levelSize = new int[2000];
        int levelCount = 0;
        List<List<Integer>> res = new LinkedList<>();

        Stack<TreeNode> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        stack.push(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            levelSize[levelCount] = size;
            levelCount++;

            for(int i = 0;  i < size; i++){
                TreeNode node = queue.poll();
                if(node.right != null){
                    queue.add(node.right);
                    stack.push(node.right);
                }
                if(node.left != null){
                    queue.add(node.left);
                    stack.push(node.left);
                }
            }
        }

        for(int i = levelCount-1; i >= 0; i--){
            List<Integer> list = new LinkedList<>();
            for(int k = 0; k< levelSize[i]; k++){
                list.add(stack.pop().val);
            }
            res.add(list);
        }
        return res;
    }
}
