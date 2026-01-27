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

                case "+" -> {
                    int right = stack[top--];
                    int left = stack[top--];
                    stack[++top] = left + right;
                }
                case "-" -> {
                    int right = stack[top--];
                    int left = stack[top--];
                    stack[++top] = left - right;
                }
                case "*" -> {
                    int right = stack[top--];
                    int left = stack[top--];
                    stack[++top] = left * right;
                }
                case "/" -> {
                    int right = stack[top--];
                    int left = stack[top--];
                    stack[++top] = left / right;
                }
                default -> {
                    stack[++top] = Integer.valueOf(s);
                }
            }
        }
        return stack[top];
    }
}
