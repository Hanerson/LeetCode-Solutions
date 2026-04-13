package Daily;

class RMQ {
    int[][] st;
    int[] log;

    public RMQ(int[] strength) {
        int n = strength.length;

        // 预处理log
        log = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            log[i] = log[i / 2] + 1;
        }

        int maxK = log[n];
        st = new int[n][maxK + 1];

        // 长度1初始化
        for (int i = 0; i < n; i++) {
            st[i][0] = strength[i];
        }

        // 填表
        for (int j = 1; j <= maxK; j++) {
            for (int i = 0; i + (1 << j) <= n; i++) {

                st[i][j] = Math.min(
                        st[i][j - 1], // 左半
                        st[i + (1 << (j - 1))][j - 1] // 右半
                );
            }
        }
    }

    public int query(int l, int r) {
        int len = r - l + 1;

        // 找最大2次幂
        int k = log[len];

        return Math.min(
                st[l][k],
                st[r - (1 << k) + 1][k]
        );
    }
}