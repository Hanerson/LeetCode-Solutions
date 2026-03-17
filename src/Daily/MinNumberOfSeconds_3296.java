package Daily;

public class MinNumberOfSeconds_3296 {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        int maxWorkerTime = 0;
        for(int workerTime : workerTimes){
            maxWorkerTime = Math.max(maxWorkerTime, workerTime);
        }

        long low = 0, high = (long)maxWorkerTime * mountainHeight * (mountainHeight + 1) / 2;

        while(low < high){
            long mid = (high - low) / 2 + low;

            if(canFinish(mountainHeight, workerTimes, mid)){
                high = mid;
            }else low = mid + 1;
        }

        return low;
    }

    private int getAmount(long seconds, int workerTime){
        if (workerTime == 0 || seconds == 0) return 0;
        long discriminant = 1 + 8 * seconds / workerTime;
        int k = (int)((Math.sqrt(discriminant) - 1) / 2);
        while ((long)workerTime * k * (k + 1) / 2 > seconds) {
            k--;
        }
        while ((long)workerTime * (k + 1) * (k + 2) / 2 <= seconds) {
            k++;
        }
        return k;
    }

    private boolean canFinish(int mountainHeight, int[] workerTimes, long deadline){
        long count = 0;
        for(int workerTime : workerTimes){
            count += getAmount(deadline, workerTime);
        }

        return count >= mountainHeight;
    }
}
