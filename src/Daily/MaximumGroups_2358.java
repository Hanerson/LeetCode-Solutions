package Daily;

public class MaximumGroups_2358 {
    public int maximumGroups(int[] grades){
        int n = grades.length;
        int high = grades.length;
        int low = 1, mid = 0;
        while(low < high){
            mid = low + (high - low)/2;
            if(check(n, mid)){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return mid;
    }

    private boolean check(int size, int k){
        return 2 * size >= k * (k + 1);
    }
}
