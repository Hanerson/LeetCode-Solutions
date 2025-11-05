package Structures.BinaryTree;

import Structures.BinaryTree.Utils.TreeNode;

import java.util.*;

public class BuildTree_PI {
    private Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        indexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preL, int preR,
                           int[] inorder, int inL, int inR) {
        if (preL > preR || inL > inR) return null;
        int rootVal = preorder[preL];
        TreeNode root = new TreeNode(rootVal);

        int inRootIndex = indexMap.get(rootVal);
        int leftSize = inRootIndex - inL;
        root.left = build(preorder, preL + 1, preL + leftSize,
                inorder, inL, inRootIndex - 1);

        root.right = build(preorder, preL + leftSize + 1, preR,
                inorder, inRootIndex + 1, inR);

        return root;
    }
}
