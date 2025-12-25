package Daily;

import java.util.Arrays;

public class MaxHappiness_3075 {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);

        int desc = 0;

        long sum = 0;
        int pos = happiness.length - 1;

        while(k > 0){
            sum += Math.max(happiness[pos] - desc, 0);
            pos--;
            desc++;
            k --;
        }

        return sum;
    }
}
