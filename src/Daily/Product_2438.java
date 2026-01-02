package Daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Product_2438 {

    public static final int MOD = 1000000007;

    public int[] productQueries(int n, int[][] queries) {
        char[] chars = toBinaryReversed(n).toCharArray();

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == '1'){
                list.add(i);
            }
        }

        int[] preSum = new int[list.size() + 1];
        preSum[0] = 0;

        for(int i = 0; i < list.size(); i++){
            preSum[i + 1] = preSum[i] + list.get(i);
        }

        int[] ans = new int[queries.length];
        int pos = 0;

        for(int[] query : queries){
            int left = query[0];
            int right = query[1];

            int power = preSum[right + 1] - preSum[left];
            ans[pos] = (int)(Math.pow(2, power) % MOD);
            pos++;
        }

        return ans;
    }

    private String toBinaryReversed(int num) {
        StringBuilder sb = new StringBuilder();

        while (num != 0) {
            sb.append(num % 2);
            num /= 2;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Product_2438 p = new Product_2438();

        System.out.println(Arrays.toString(p.productQueries(15, new int[][]{{0,1},{2,2},{0,3}})));
    }
}
