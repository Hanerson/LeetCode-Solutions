package Structures.BinaryTree.Utils;

public class Basics {

    public static TreeNode tree1() {
        int[] preorder = {1,2,4,5,3};
        int[] inorder  = {4,2,5,1,3};
        return buildBinaryTree(preorder, inorder);
    }

    public static TreeNode tree2() {
        int[] preorder = {10,5,2,7,15,12,20};
        int[] inorder  = {2,5,7,10,12,15,20};
        return buildBinaryTree(preorder, inorder);
    }

    public static TreeNode tree3() {
        int[] preorder = {1,2,3,4};
        int[] inorder  = {1,2,3,4};
        return buildBinaryTree(preorder, inorder);
    }

    // 主方法：传入前序和中序数组
    public static TreeNode buildBinaryTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        return build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    // 递归构建
    private static TreeNode build(int[] preorder, int preStart, int preEnd,
                           int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        // 前序的第一个就是根
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        // 找到根在中序遍历中的位置
        int inRootIndex = inStart;
        while (inRootIndex <= inEnd && inorder[inRootIndex] != rootVal) {
            inRootIndex++;
        }

        int leftSize = inRootIndex - inStart; // 左子树节点数量

        // 构建左子树
        root.left = build(preorder, preStart + 1, preStart + leftSize,
                inorder, inStart, inRootIndex - 1);

        // 构建右子树
        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                inorder, inRootIndex + 1, inEnd);

        return root;
    }


    //有关于这一个打印二叉树的方法，打印树的结构是 left child 位于根元素上方 right child 位于根元素下方

    public static void printTree(TreeNode root) {
        printTree(root, "", true);
    }

    private static void printTree(TreeNode node, String prefix, boolean isTail) {
        if (node == null) return;

        // 打印当前节点
        System.out.println(prefix + (isTail ? "└── " : "├── ") + node.val);

        // 收集左右孩子
        if (node.left != null || node.right != null) {
            if (node.left != null) {
                printTree(node.left, prefix + (isTail ? "    " : "│   "), node.right == null);
            }
            if (node.right != null) {
                printTree(node.right, prefix + (isTail ? "    " : "│   "), true);
            }
        }
    }
}
