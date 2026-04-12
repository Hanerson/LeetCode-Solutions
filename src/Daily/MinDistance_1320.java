package Daily;

public class MinDistance_1320 {
    public int minimumDistance(String word) {
        int[][][] dp = new int[word.length()][26][26];

        for(int i = 0; i < word.length(); i++){
            for(int j = 0; j < 26; j ++){
                for(int k = 0; k < 26; k ++){
                    dp[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }

        int first = word.charAt(0) - 'A';

        for(int i = 0; i < 26; i++){
            dp[0][first][i] = 0;
            dp[0][i][first] = 0;
        }

        for(int k = 1; k < word.length(); k ++){
            char curr = word.charAt(k);

            for(int i = 0; i < 26; i ++){
                for(int j = 0; j < 26; j ++){
                    if(dp[k - 1][i][j] == Integer.MAX_VALUE) continue;

                    dp[k][curr - 'A'][j] = Math.min(dp[k][curr - 'A'][j], dp[k-1][i][j] + getDistance(curr, (char)(i+'A')));
                    dp[k][i][curr - 'A'] = Math.min(dp[k][i][curr - 'A'], dp[k-1][i][j] + getDistance(curr, (char)(j+'A')));
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 26; i ++){
            for(int j = 0; j < 26; j ++){
                min = Math.min(min, dp[word.length() - 1][i][j]);
            }
        }

        return min;
    }

    private int getDistance(char a, char b){
        int[] vectA = getVector(a), vectB = getVector(b);

        return Math.abs(vectA[0] - vectB[0]) + Math.abs(vectA[1] - vectB[1]);
    }

    private int[] getVector(char c){
        int num = c - 'A';
        return new int[]{num / 6, num % 6};
    }
}
