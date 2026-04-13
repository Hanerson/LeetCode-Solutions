package Daily;

import java.util.HashMap;

//TODO this method need an improve with monotonic stack

public class TotalStrength_2281 {

    int[][] st;
    int[] log;

    final int MOD = (int)(Math.pow(10, 9) + 7);
    public int totalStrength(int[] strength) {

        RMQInit(strength);

        int[] prefix = new int[strength.length + 1];

        prefix[0] = 0;

        for(int i = 0; i < strength.length; i ++){
            prefix[i + 1] = prefix[i] + strength[i];
        }

        int sum = 0;

        for(int i = 0; i < strength.length; i ++){
            for(int j = i; j < strength.length; j ++){
                int subSum = prefix[j + 1] - prefix[i];

                sum += subSum * query(i, j);

                sum %= MOD;
            }
        }

        return sum;
    }

    public void RMQInit(int[] strength) {
        int n = strength.length;

        log = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            log[i] = log[i / 2] + 1;
        }
        int maxK = log[n];
        st = new int[n][maxK + 1];

        for (int i = 0; i < n; i++) {
            st[i][0] = strength[i];
        }

        for (int j = 1; j <= maxK; j++) {
            for (int i = 0; i + (1 << j) <= n; i++) {

                st[i][j] = Math.min(
                        st[i][j - 1],
                        st[i + (1 << (j - 1))][j - 1]
                );
            }
        }
    }
    public int query(int l, int r) {
        int len = r - l + 1;
        int k = log[len];

        return Math.min(
                st[l][k],
                st[r - (1 << k) + 1][k]
        );
    }
}
