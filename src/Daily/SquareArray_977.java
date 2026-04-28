package Daily;

public class SquareArray_977 {
    public int[] sortedSquares(int[] nums) {
        for(int i = 0; i < nums.length; i ++){
            nums[i] *= nums[i];
        }

        int head = 0, tail = nums.length - 1;

        int pos = nums.length - 1;
        int[] ans = new int[nums.length];

        while(head <= tail){
            if(nums[head] > nums[tail]){
                ans[pos] = nums[head];
                head ++;
            }else{
                ans[pos] = nums[tail];
                tail --;
            }

            pos --;
        }

        return ans;
    }
}
