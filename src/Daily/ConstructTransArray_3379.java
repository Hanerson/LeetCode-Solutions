package Daily;

public class ConstructTransArray_3379 {
    public int[] constructTransformedArray(int[] nums) {
        int m = nums.length;

        int[] ans = new int[m];
        for(int i = 0; i < m; i++){
            int bias = nums[i];
            while(bias < 0) bias += m;
            bias = (bias + i) % m;

            ans[i] = nums[bias];
        }

        return ans;
    }

    public static void main(String[] args){
        ConstructTransArray_3379 obj = new ConstructTransArray_3379();
        int[] ans = obj.constructTransformedArray(new int[]{3,-2,1,1});
    }
}
