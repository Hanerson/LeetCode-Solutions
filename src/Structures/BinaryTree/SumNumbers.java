package Structures.BinaryTree;

import Structures.BinaryTree.Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SumNumbers {
    public int sumNumbers(TreeNode root) {
        List<String> nums = new ArrayList<>();
        int sum = 0;

        dfs(new StringBuilder(), root, nums);

        for(String num : nums){
            sum += Integer.parseInt(num);
        }
        return sum;
    }

    private void dfs(StringBuilder curr, TreeNode root, List<String> nums){
        curr.append(root.val);
        if(root.left == null && root.right == null){
            nums.add(new String(curr));
        }
        if(root.left != null){
            dfs(curr, root.left, nums);
        }
        if(root.right != null){
            dfs(curr, root.right, nums);
        }
        curr.deleteCharAt(curr.length()-1);
    }

}
