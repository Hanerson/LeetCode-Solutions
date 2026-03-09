package Daily;

import java.util.Arrays;

public class NicePairs_2300 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);

        int m = spells.length, n = potions.length;

        int[] count = new int[m];

        for(int i = 0; i < m; i++){
            int left = 0, right = n - 1;
            int pos = n;

            while(left <= right){
                int mid = left + (right - left) / 2;

                if((long)spells[i] * potions[mid] >= success){
                    pos = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            count[i] = n - pos;
        }

        return count;
    }
}
