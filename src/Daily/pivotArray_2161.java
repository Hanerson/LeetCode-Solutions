package Daily;

import java.util.Arrays;

public class pivotArray_2161 {
    public int[] pivotArray(int[] nums, int pivot) {
        int cnt0 = 0, cnt1 = 0;

        for(int num : nums){
            if(num > pivot) cnt1 ++;
            if(num <= pivot) cnt0 ++;
        }

        int[] ans = new int[nums.length];
        Arrays.fill(ans, pivot);

        int ptr1 = cnt0, ptr0 = 0;

        for(int num : nums){
            if(num < pivot){
                ans[ptr0] = num;
                ptr0 ++;
            }else if(num > pivot){
                ans[ptr1] = num;

                ptr1 ++;
            }
        }

        return ans;
    }
}
