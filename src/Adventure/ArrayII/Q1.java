package Adventure.ArrayII;

public class Q1 {
    public int[] findErrorNums(int[] nums) {
        int sec = 0, miss = 0;
        int[] bucket =  new int[nums.length + 1];
        for(int num : nums){
            bucket[num]++;
            if(bucket[num] == 2){
                sec = num;
            }
        }

        for(int i = 1; i <= nums.length; i++){
            if(bucket[i] == 0){
                miss = i;
            }
        }

        return new int[]{sec, miss};
    }
}
