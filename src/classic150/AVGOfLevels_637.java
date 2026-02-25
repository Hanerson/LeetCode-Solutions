package classic150;

import java.util.*;

public class AVGOfLevels_637 {
    public List<Double> averageOfLevels(TreeNode root) {
        if(root == null) return new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<Double> res = new ArrayList<>();

        while(!queue.isEmpty()) {
            int size = queue.size();
            long currSum = 0;
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                currSum += node.val;
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }

            res.add(currSum / (size * 1.0));
        }

        return res;
    }
}
