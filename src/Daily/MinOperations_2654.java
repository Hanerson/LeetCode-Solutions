package Daily;

public class MinOperations_2654 {
    public int minOperations(int[] nums) {
        int countOfOne = 0;
        for(int num : nums) countOfOne += (num == 1) ? 1 : 0;
        if(countOfOne != 0) return nums.length - countOfOne;

        int prefixGCD = 0, pos = 0;

        for(int i = 0; i < nums.length; i++){
            prefixGCD = gcd(prefixGCD, nums[i]);
            if(prefixGCD == 1){
                pos = i;
                break;
            }
        }

        return (prefixGCD == 1) ? (pos + nums.length -2) : -1;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}
