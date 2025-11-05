package Structures.Stack;

import java.util.Stack;

class MinStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        if(val<minStack.peek()){
            minStack.push(val);
        }
    }

    public void pop() {
        int num = stack.pop();
        if(num == minStack.peek()){
            minStack.pop();
        }
    }

    public int top() {
        stack.peek();
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}