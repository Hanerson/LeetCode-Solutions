package Adventure.Stack;

public class Q2 {
    public int evalRPN(String[] tokens) {
        if (tokens.length > 5000) {
            return 0;
        }
        int[] stack = new int[128];
        int top = -1;
        for (String s : tokens) {
            switch (s) {
                case "+":
                    int right = stack[top--];
                    int left = stack[top--];
                    stack[++top] = left + right;
                    break;
                case "-":
                    right = stack[top--];
                    left = stack[top--];
                    stack[++top] = left - right;
                    break;
                case "*":
                    right = stack[top--];
                    left = stack[top--];
                    stack[++top] = left * right;
                    break;
                case "/":
                    right = stack[top--];
                    left = stack[top--];
                    stack[++top] = left / right;
                    break;
                default:
                    stack[++top] = Integer.valueOf(s);
                    break;
            }
        }
        return stack[top];
    }

    public static void main(String[] args) {
        Q2 q2 = new Q2();
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(q2.evalRPN(tokens));
    }
}
