package Algorithm.DynamicProgramming;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2){
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 0;
        char[] m1 = text1.toCharArray();
        char[] n1 = text2.toCharArray();
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(m1[i-1] == n1[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return  dp[m][n];
    }

    public static void main(String[] args){
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        System.out.println(lcs.longestCommonSubsequence("awefbdqc", "abqc"));
    }
}
