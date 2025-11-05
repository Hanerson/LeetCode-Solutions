package Structures.BinaryTree;

import Structures.BinaryTree.Utils.TreeNode;
import static Structures.BinaryTree.Utils.Basics.*;

public class MaxDepth {

    /**
     * public int maxDepth(TreeNode root) {
     *         if (root == null) return 0;
     *         return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
     *     }
     * <p>
     *    实际上上面的方法更加直观，核心逻辑只有一句话，就是（总体最大深度）=（左右子树最大深度）+1
     */

    public int maxDepth(TreeNode root){
        return (root == null) ? 0 : calculate(root,1);
    }

    public int calculate(TreeNode root, int curr){
        if(root.left == null && root.right == null){
            return curr;
        }
        else{
            if(root.left == null){
                return calculate(root.right, curr+1);
            }else if(root.right == null){
                return calculate(root.left, curr+1);
            }
            return Math.max(calculate(root.left,curr+1),calculate(root.right,curr+1));
        }
    }

    public static void main(String[] args){
        MaxDepth sol = new MaxDepth();
        printTree(tree1());
        System.out.println(sol.maxDepth(tree1()));
        System.out.println();
        printTree(tree2());
        System.out.println(sol.maxDepth(tree2()));
        System.out.println();
        printTree(tree3());
        System.out.println(sol.maxDepth(tree3()));
        System.out.println();
    }
}
