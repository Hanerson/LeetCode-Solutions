package classic150;

public class CountNodes_222 {
    public int countNodes(TreeNode root) {
        int depth = getDepth(root);
        int[] arr = new int[2];

        countLeaves(root, arr);

        return (int)((int)(Math.pow(2, depth) - 1) - (arr[0] - Math.pow(2, depth - 1)));
    }

    private void countLeaves(TreeNode root, int[] arr) {
        if(root.left == null && root.right == null){
            arr[0] ++;
            return;
        }

        if(root.left != null) countLeaves(root.left, arr);
        if(root.right != null) countLeaves(root.right, arr);
    }

    private int getDepth(TreeNode root) {
        int depth = 0;
        while (root != null) {
            depth++;
            root = root.left;
        }

        return depth;
    }
}