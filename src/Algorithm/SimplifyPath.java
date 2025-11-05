package Algorithm;

import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] parts = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String part : parts) {
            if(part.equals(".") || part.isEmpty()) {
                continue;
            }else if(part.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
                continue;
            }
            stack.push(part);
        }
        boolean flag = stack.isEmpty();
        StringBuilder ans = new StringBuilder();
        if(!flag){
            while (!stack.isEmpty()) {
                ans.insert(0, "/" + stack.pop());
            }
        }
        return flag ? "/" : ans.toString();
    }
    public static void main(String[] args){
        SimplifyPath solution = new SimplifyPath();
        System.out.println(solution.simplifyPath("/home/"));
        System.out.println(solution.simplifyPath("/../"));
        System.out.println(solution.simplifyPath("/../"));
        System.out.println(solution.simplifyPath("/../../"));
    }
}
