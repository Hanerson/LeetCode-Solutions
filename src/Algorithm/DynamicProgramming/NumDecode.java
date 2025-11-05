package Algorithm.DynamicProgramming;

public class NumDecode {
    public int numDecode(String s){
        if(s.charAt(0) == '0') return 0;
        int len = s.length();
        char[] arr = s.toCharArray();
        int[]  dp = new int[len];
        dp[len-1] = (arr[len-1] == '0') ? 0 : 1;
        if(len == 1) return 1;
        if(arr[len - 2] == '1'){
            dp[len - 2] = dp[len -1]+1;
        }else if(arr[len - 2] == '2'){
            if(arr[len - 1] < '7') dp[len - 2] = dp[len -1]+1;
            else dp[len - 2] = dp[len -1];
        }else if(arr[len - 2] == '0') dp[len - 2] = 0;
        else dp[len - 2] = dp[len -1];
        for(int i = len - 3; i >= 0; i--){
            if(arr[i] == '1'){
                dp[i] = dp[i+1] + dp[i+2];
            }else if(arr[i] == '2'){
                if(arr[i+1] < '7') dp[i] = dp[i+1] + dp[i+2];
                else dp[i] = dp[i+1];
            }else if(arr[i] == '0'){
                dp[i] = 0;
            }else{
                dp[i] = dp[i+1];
            }
        }
        return dp[0];
    }
    public static void main(String[] args){
        NumDecode n = new NumDecode();
        System.out.println(n.numDecode("12120"));
    }
}
