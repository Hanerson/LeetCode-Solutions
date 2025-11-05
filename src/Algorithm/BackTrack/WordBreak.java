package Algorithm.BackTrack;

import java.util.*;

public class WordBreak {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);

        List<List<String>> res = new ArrayList<>();
        List<String> ans = new ArrayList<>();

        dfs(s, set, 0, new ArrayList<>(), res);

        for(List<String> list : res){
            StringBuilder sb = new StringBuilder();
            for(String word : list){
                sb.append(word).append(" ");
            }
            sb.deleteCharAt(sb.length()-1);
            ans.add(sb.toString());
        }
        return ans;
    }

    public void dfs(String s, HashSet<String> set, int depth, List<String> path, List<List<String>> res){
        if(depth == s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = depth+1; i <= s.length(); i++){
            String sub = s.substring(depth,i);
            if(set.contains(sub)){
                path.add(sub);
                dfs(s, set, depth + sub.length(), path, res);
                path.remove(path.size()-1);
            }
        }
    }

    public static void main(String[] args){
        String s = "catsanddog";
        String[] ref = new String[]{
                "cat","cats","and","sand","dog"
        };
        List<String> wordDict = new ArrayList<>(Arrays.asList(ref));
        WordBreak wb = new WordBreak();
        List<String> res = wb.wordBreak(s, wordDict);
        System.out.println(res);
    }
}
