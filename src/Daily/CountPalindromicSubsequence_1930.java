package Daily;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CountPalindromicSubsequence_1930 {

    private static final HashSet<String> SET = new HashSet<>();

    public int countPalindromicSubsequence(String s){
        char[] arr = s.toCharArray();
        for(int i = 1; i < arr.length - 1; i++){
            helper(arr, i);
        }
        return SET.size();
    }

    private void helper(char[] arr, int pos){
        HashSet<Character> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        for(int i = 0; i < pos; i++){
            set.add(arr[i]);
            if(set.size() == 26) break;
        }

        for(int i = pos + 1; i < arr.length; i++){
            if(set.contains(arr[i])){
                SET.add("" + arr[i] + arr[pos] + arr[i]);
            }
        }
    }
}
