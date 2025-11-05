package Structures.BinaryTree;

import Structures.BinaryTree.Utils.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class CommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pList = new ArrayList<>();
        List<TreeNode> qList = new ArrayList<>();

        findPath(root, p, new ArrayList<>(), pList);
        findPath(root, q, new ArrayList<>(), qList);

        int i = 0;
        while (i < pList.size() && i < qList.size() && pList.get(i) == qList.get(i)) i++;
        return pList.get(i - 1);
    }

    private boolean findPath(TreeNode root, TreeNode dest, List<TreeNode> curr, List<TreeNode> result) {
        if (root == null) return false;

        curr.add(root);
        if (root == dest) {
            result.addAll(curr);
            return true;
        }
        if (findPath(root.left, dest, curr, result) || findPath(root.right, dest, curr, result)) return true;
        curr.remove(curr.size() - 1);
        return false;
    }
}
