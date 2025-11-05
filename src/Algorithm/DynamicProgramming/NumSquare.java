package Algorithm.DynamicProgramming;

public class NumSquare {
    public int numSquare(int n){
        int[] dp = new int[n+1];
        int count = 0;
        for(int i = 1; i <= n; i++){
            if(Math.sqrt(i) % 1 == 0){
                dp[i] = 0;
                count=0;
            }else{
                count++;
                dp[i] = count;
            }
        }
        return helper(dp,n,0);
    }

    public int helper(int[] dict, int curr, int count){
        if(dict[curr] == 0){
            System.out.println(curr-dict[curr]);
            return count+1;
        }
        else{
            System.out.print(curr-dict[curr] + "+");
            return helper(dict, dict[curr], count+1);
        }
    }

    public static void main(String[] args){
        NumSquare sol = new NumSquare();
        System.out.println(sol.numSquare(234));
    }
}
