package Daily;

public class MaxMinPower_2528 {
    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;

        long[] prefix = new long[n + 1];
        for(int i = 0; i < n; i++)
            prefix[i + 1] = prefix[i] + stations[i];

        long[] power = new long[n];

        for(int i = 0; i < n; i++){
            int l = Math.max(0, i - r);
            int rr = Math.min(n - 1, i + r);
            power[i] = prefix[rr + 1] - prefix[l];
        }

        long left = 0, right = (long)1e18;

        while(left < right){
            long mid = (left + right + 1) / 2;

            if(check(power, r, k, mid))
                left = mid;
            else
                right = mid - 1;
        }

        return left;
    }

    private boolean check(long[] power, int r, int k, long target){
        int n = power.length;

        long[] diff = new long[n + 1];
        long add = 0;
        long remain = k;

        for(int i = 0; i < n; i++){
            add += diff[i];

            long cur = power[i] + add;

            if(cur < target){
                long need = target - cur;

                remain -= need;
                if(remain < 0) return false;

                add += need;

                int pos = Math.min(n, i + 2*r + 1);
                diff[pos] -= need;
            }
        }

        return true;
    }
}
