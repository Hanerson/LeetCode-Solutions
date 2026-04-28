package Daily;

public class MaxTurbulenceSize_978 {
    public int maxTurbulenceSize(int[] arr) {
        //post order
        int max = getMaxLength(arr);

        //reverse order
        int[] copy = new int[arr.length];
        for(int i = 0; i < arr.length; i ++){
            copy[i] = arr[arr.length - 1 - i];
        }

        max = Math.max(max, getMaxLength(copy));

        return max;
    }

    private int getMaxLength(int[] arr){
        int[] dp = new int[arr.length];

        int max = 1;

        //dp[i] means the max length of the Turbulence array end with arr[i]
        dp[0] = 1;
        for(int i = 1; i < arr.length; i ++){
            if(i % 2 == 0 && arr[i] > arr[i - 1] || i % 2 == 1 && arr[i] < arr[i - 1]){
                dp[i] = dp[i - 1] + 1;

                max = Math.max(max, dp[i]);
            }else dp[i] = 1;
        }

        return max;
    }
}
