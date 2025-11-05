package Structures.String;

public class IsScramble {
    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        if (n != s2.length()) return false;
        if (s1.equals(s2)) return true;

        boolean[][][] dp = new boolean[n][n][n + 1];

        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        for (int c : count)  if (c != 0) return false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][1] = (s1.charAt(i) == s2.charAt(j));
            }
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len <= n; i++) {
                for (int j = 0; j + len <= n; j++) {
                    for (int k = 1; k < len; k++) {
                        if(!dp[i][j][len]){
                            if ((dp[i][j][k] && dp[i + k][j + k][len - k]) ||
                                    (dp[i][j + len - k][k] && dp[i + k][j][len - k])) {
                                dp[i][j][len] = true;
                                break;
                            }
                        }
                    }
                }
            }
        }

        return dp[0][0][n];
    }
}