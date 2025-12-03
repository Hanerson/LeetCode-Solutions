package Structures.Array;

public class MinOperations_1769 {
    public int[] minOperations(String boxes){
        char[] arr = boxes.toCharArray();
        int[] ans = new int[arr.length];

        int count = 0;
        int left = arr[0] == '1' ? 1 : 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == '1'){
                ans[0] += i;
                count ++;
            }
        }

        for(int i = 1; i < arr.length; i++){
            ans[i] = ans[i - 1] + left - (count - left);
            left += arr[i] - '0';
        }

        return ans;
    }
}
