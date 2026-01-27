package Basic50;

import java.util.Arrays;

public class CanMake_1502 {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);

        return check(arr);
    }

    private boolean check(int[] arr){
        int step = arr[0] - arr[1];

        for(int i = 1; i < arr.length; i++){
            if(arr[i - 1] - arr[i] != step) return false;
        }

        return true;
    }
}
