package Daily;

public class NumberOfOnePositiveSubstrings_3234 {
    public int numberOfSubstrings_prefix(String s){
        int n = s.length();
        int[] prefixSum = new int[n];
        char[] arr = s.toCharArray();
        prefixSum[0] = (arr[0] == '1') ? 1 : 0;

        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + (arr[i] - '0');
        }
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                int ones = prefixSum[j] - (i > 0 ? prefixSum[i - 1] : 0);
                int length = j - i + 1;
                int zeros = length - ones;
                if(ones >= zeros * zeros){
                    count++;
                }
            }
        }
        return count;
    }

    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] pre = new int[n + 1];
        pre[0] = -1;
        for (int i = 0; i < n; i++) {
            if (i == 0 || (i > 0 && s.charAt(i - 1) == '0')) {
                pre[i + 1] = i;
            } else {
                pre[i + 1] = pre[i];
            }
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            int cnt0 = s.charAt(i - 1) == '0' ? 1 : 0;
            int j = i;
            while (j > 0 && cnt0 * cnt0 <= n) {
                int cnt1 = (i - pre[j]) - cnt0;
                if (cnt0 * cnt0 <= cnt1) {
                    res += Math.min(j - pre[j], cnt1 - cnt0 * cnt0 + 1);
                }
                j = pre[j];
                cnt0++;
            }
        }
        return res;
    }
}
