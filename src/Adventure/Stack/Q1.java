package Adventure.Stack;

import java.util.*;

public class Q1 {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();

        int endEle = target[target.length - 1];
        int pos = 0;

        for(int i = 1; i <= endEle; i++){
            if(i != target[pos]){
                ans.add("Push");
                ans.add("Pop");
            }
            else{
                pos ++;
                ans.add("Push");
            }
        }

        return ans;
    }
}
