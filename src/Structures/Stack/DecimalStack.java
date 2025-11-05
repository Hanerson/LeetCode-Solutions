package Structures.Stack;

import java.util.Stack;

public class DecimalStack{
    public int largestRectangleArea(int[] heights){
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int[] prev = new int[heights.length];
        for(int i = 0; i < heights.length; i++){
            if (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                    int temp = stack.pop();
                    max = Math.max(max, heights[temp] * (i - prev[temp] - 1));
                }
            }
            prev[i] = (stack.isEmpty()) ? -1 : stack.peek();
            stack.push(i);
        }
        for(int num : stack){
            max = Math.max(max, heights[num] * (heights.length - prev[num] - 1));
        }
        return max;
    }

    public static void main(String[] args) {
        DecimalStack s = new DecimalStack();
        int[] heights = new int[]{2,1,5,6,2,3};
        System.out.println(s.largestRectangleArea(heights));
    }
}
