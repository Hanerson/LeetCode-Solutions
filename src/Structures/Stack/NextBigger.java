package Structures.Stack;

import java.util.Arrays;
import java.util.Stack;

public class NextBigger {
    public int[] nextBigger(int[] temps){
        Stack <Integer> stack = new Stack<>();
        int[] ans = new int[temps.length];
        int pos = 0;
        while (pos < temps.length) {
            while (!stack.isEmpty() && temps[pos] > temps[stack.peek()]) {
                ans[stack.peek()] = pos - stack.peek();
                stack.pop();
            }
            stack.push(pos);
            pos++;
        }
        return ans;
    }
    public static void main(String[] args){
        NextBigger sol = new NextBigger();
        int[] temps = new int[] {73,74,75,71,69,72,76,73};

        System.out.println(Arrays.toString(sol.nextBigger(temps)));
    }
}
