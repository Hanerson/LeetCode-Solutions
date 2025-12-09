package Structures.Stack;

import java.util.Scanner;
import java.util.Stack;

public class CanSeeBuildings {
    public int canSeeBuildings(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int res = 0;

        for (int h : heights) {
            int sameHeightCount = 1;
            while (!stack.isEmpty() && stack.peek()[0] <= h) {
                int[] top = stack.pop();
                res += top[1];
                if (top[0] == h) {
                    sameHeightCount += top[1];
                    break;
                }
            }
            if (!stack.isEmpty()) {
                res += 1;
            }
            stack.push(new int[]{h, sameHeightCount});
        }

        return res;
    }


    public static void main(String[] args) {
        CanSeeBuildings obj = new CanSeeBuildings();
        System.out.println(obj.canSeeBuildings(new int[]{2,4,1,2,2,5,1}));
    }
}
