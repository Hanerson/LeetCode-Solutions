package Algorithm;

public class GetPermutation {
    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for(int i=0;i<n;i++) nums[i]=i+1;
        for(int i=1;i<k;i++){
            nextPermutation(nums);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++) sb.append(nums[i]);
        return sb.toString();
    }
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int index_miner=-1;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                index_miner=i;
                break;
            }
        }
        if(index_miner!=-1){
            int temp_index=0;
            int temp=nums[index_miner];
            for(int i=n-1;i>index_miner;i--){
                if(nums[i]>temp){
                    temp_index=i;
                    break;
                }
            }
            nums[index_miner]=nums[temp_index];
            nums[temp_index]=temp;
        }
        reverse(nums,index_miner);
    }
    public void reverse(int[] nums, int start){
        int n=nums.length;
        for(int i=start+1;i<(nums.length+start+1)/2;i++){
            int temp = nums[i];
            nums[i]=nums[n-i+start];
            nums[n-i+start]=temp;
        }
    }
    public static void main(String[] args){
        GetPermutation solution = new GetPermutation();
        System.out.println(solution.getPermutation(4,9));
    }
}