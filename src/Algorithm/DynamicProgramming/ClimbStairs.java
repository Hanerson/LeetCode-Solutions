package Algorithm.DynamicProgramming;


import java.util.Scanner;

public class ClimbStairs {
    public int climbStairs(int n){
        int[] dp  = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <=n ; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args){
        ClimbStairs obj = new ClimbStairs();
        int n;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter no. of stairs:");
        n = sc.nextInt();

        System.out.println(obj.climbStairs(n));
    }
}
