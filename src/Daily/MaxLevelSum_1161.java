package Daily;

import java.util.LinkedList;
import java.util.Queue;

public class MaxLevelSum_1161 {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        if(root == null) return -1;
        queue.add(root);

        int maxSum = Integer.MIN_VALUE;
        int level = 0, currLevel = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            int tempSum = 0;

            currLevel ++;

            for(int i = 0; i < size; i++){
                TreeNode currNode = queue.poll();
                tempSum += currNode.val;

                if(currNode.left != null) queue.offer(currNode.left);
                if(currNode.right != null) queue.offer(currNode.right);
            }

            if(tempSum > maxSum){
                maxSum = tempSum;

                level = currLevel;
            }
        }

        return level;
    }
}
