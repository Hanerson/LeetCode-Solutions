package Daily;

public class NumberOfWays_2147 {
    private static final int mod = 1000000007;

    public int numberOfWays(String corridor) {
        int n = corridor.length();
        char[] arr = corridor.toCharArray();
        int prev = -1, cnt = 0, ans = 1;
        for (int i = 0; i < n; ++i) {
            if (arr[i] == 'S') {
                ++cnt;
                if (cnt >= 3 && cnt % 2 == 1) {
                    ans = (int)((long)ans * (i - prev) % mod);
                }
                prev = i;
            }
        }
        if (cnt < 2 || cnt % 2 != 0) {
            ans = 0;
        }
        return ans;
    }
}
