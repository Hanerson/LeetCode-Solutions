package Algorithm.BackTrack;

import java.util.ArrayList;
import java.util.List;

public class Partition {
    public List<List<String>> partition(String s){
        List<List<String>> ans = new ArrayList<>();
        backtrack(ans, s, 0, new ArrayList<>());
        return ans;
    }

    public void backtrack(List<List<String>> res, String s, int start, List<String> path){
        if(start == s.length()){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = start; i < s.length(); i++){
            if(isPalindrome(s, start, i)){
                String sub = s.substring(start, i + 1);
                path.add(sub);
                backtrack(res, s, i + 1, path);
                path.remove(path.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, int i, int j){
        char[] arr = s.toCharArray();
        while (i < j){
            if(arr[i] != arr[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args){
        Partition sol = new Partition();
        String s = "aab";
        System.out.println(sol.partition(s));
    }
}
