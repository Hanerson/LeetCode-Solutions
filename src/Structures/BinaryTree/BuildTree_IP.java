package Structures.BinaryTree;

import Structures.BinaryTree.Utils.TreeNode;

import java.util.HashMap;

public class BuildTree_IP {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) map.put(inorder[i] , i);
        return build(inorder, postorder, 0, inorder.length-1, inorder.length-1, map);
    }

    public TreeNode build(int[] inorder, int[] postorder, int left, int right, int pos, HashMap<Integer, Integer> map){

        if(left > right) return null;

        TreeNode root = new TreeNode(postorder[pos]);
        int div = map.get(postorder[pos]);
        TreeNode leftTree = build(inorder, postorder, left, div-1, pos - right + div -1, map);
        TreeNode rightTree = build(inorder, postorder, div+1, right, pos-1, map);
        root.left = leftTree;
        root.right = rightTree;

        return root;
    }
}
