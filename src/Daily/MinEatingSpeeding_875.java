package Daily;

public class MinEatingSpeeding_875 {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1, max = 0;
        for(int pile : piles) {
            max = Math.max(max, pile);
        }
        while(min <= max) {
            int mid = (max - min) / 2 + min;
            if(canFinishInTime(mid, piles, h)){
                max = mid - 1;
            }else{
                min = mid + 1;
            }
        }
        return min;
    }
    
    private boolean canFinishInTime(int speed, int[] piles, int h){
        long count = 0;
        for(int pile : piles){
            int coil = pile / speed;
            count += (pile % speed == 0) ? coil : coil + 1;
        }
        return count <= h;
    }
}
