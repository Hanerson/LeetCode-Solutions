package Daily;

public class MaxRunTime_2141 {
    /**
     * 这一题给我的感觉就是一个脑经急转弯
     * <p>
     * 首先我们非常容易判断最终可行的最大时间一定介于0和[SUM((batteries)/n)]
     * <p>
     * 越大的时间越难满足
     * <p>
     * 考虑使用二分查找
     * <p>
     * 对于单次查找，如果可以满足运行条件 --> 尝试寻找更大的可能时间//否则向下寻找
     * */
    public long maxRunTime(int n, int[] batteries) {
        long sum = 0;
        for (int b : batteries) sum += b;

        long left = 0, right = sum / n;
        long ans = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            if (canRun(mid, n, batteries)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    private boolean canRun(long T, int n, int[] batteries) {
        long total = 0;
        for (int b : batteries) {
            total += Math.min(b, T);
        }
        return total >= (long)n * T;
    }

}
