package Structures.String;

import java.util.Arrays;

public class MinCut {
    public int minCut(String s){
        if(s == null || s.length() == 1) return 0;
        int[] dp = new int[ s.length() ];
        Arrays.fill(dp, s.length()-1);
        char[] arr = s.toCharArray();

        for(int i = 0; i < s.length(); i++){
            helper(arr, dp, i , i);
            helper(arr, dp, i, i+1);
        }
        return dp[s.length()-1];
    }
    private void helper(char[] arr, int[] dp, int start, int end){
        while(start >= 0 && end < arr.length && arr[start] == arr[end]){
            dp[end] =  Math.min(dp[end], ((start != 0) ? dp[start -1] : -1) + 1);
            start--;
            end++;
        }
    }
}
