package Structures.Array;

public class ValidMountainArray_941 {
    public boolean validMountainArray(int[] arr) {
        if(arr.length < 3) return false;
        if(arr[1] <= arr[0])  return false;

        boolean up = true;
        int prev = Integer.MIN_VALUE;
        for(int num : arr){
            if(prev == num) return false;
            if(prev > num) up = false;
            if(!up && num > prev) return false;
            prev = num;
        }
        return !up;
    }
}
