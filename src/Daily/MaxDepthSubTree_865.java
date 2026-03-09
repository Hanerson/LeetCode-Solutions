package Daily;

import java.util.*;

public class MaxDepthSubTree_865 {

    HashMap<TreeNode, Integer> depth = new HashMap<>();

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        depth.put(null, -1);
        getDepth(root);
        if(isLeaf(root)) return root;

        int leftDepth = depth.get(root.left);
        int rightDepth = depth.get(root.right);

        if(leftDepth == rightDepth){
            return root;
        } else if(leftDepth > rightDepth){
            return subtreeWithAllDeepest(root.left);
        } else {
            return subtreeWithAllDeepest(root.right);
        }
    }
    private boolean isLeaf(TreeNode root){
        return root.left == null && root.right == null;
    }

    private int getDepth(TreeNode root){
        if(isLeaf(root)){
            depth.put(root, 0);
            return 0;
        }
        
        int leftDepth = -1, rightDepth = -1;
        
        if(root.left != null) leftDepth = getDepth(root.left) + 1;
        if(root.right != null) rightDepth = getDepth(root.right) + 1;
        
        depth.put(root, Math.max(leftDepth, rightDepth));
        
        return Math.max(leftDepth, rightDepth);
    }
}
