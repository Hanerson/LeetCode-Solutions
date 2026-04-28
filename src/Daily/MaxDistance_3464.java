package Daily;

import java.util.*;

public class MaxDistance_3464 {
    int side;
    public int maxDistance(int side, int[][] points, int k) {
        List<Integer> list = new ArrayList<>();
        this.side = side;

        for(int[] point : points) list.add(getVet(point));
        list.sort(Comparator.comparingInt(a -> a));

        int low = 0, high = side;

        while(low <= high){
            int mid = (high - low) / 2 + low;

            if(checkIsValid(mid, list, k)){
                low = mid + 1;
            }else high = mid - 1;
        }

        return high;
    }

    private boolean checkIsValid(int mid, List<Integer> list, int k) {
        int n = list.size();
        if (n == 0) return false;
        for (int start = 0; start < Math.min(k, n); start++) {
            int count = 1;
            int last = list.get(start);

            for (int i = start + 1; i < n; i++) {
                if (list.get(i) - last >= mid) {
                    count++;
                    last = list.get(i);
                    if (count >= k) break;
                }
            }
            if (count >= k) {
                return true;
            }
        }
        return false;
    }

    private int getVet(int[] point){
        if(point[1] == 0){
            return point[0];
        }else if(point[0] == side){
            return point[0] + point[1];
        }else if(point[1] == side){
            return 3 * side - point[0];
        }else return 4 * side - point[1];
    }
}
