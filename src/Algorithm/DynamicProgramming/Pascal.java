package Algorithm.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pascal {
    public List<List<Integer>> generate(int numRows){
        List<List<Integer>> ans = new ArrayList<>();
        if(numRows == 0) return null;
        List<Integer> temp1 = new ArrayList<>();
        temp1.add(1);
        ans.add(temp1);
        if(numRows == 1) return ans;
        else{
            int count = 0;
            while(count < numRows-1){
                List<Integer> temp = new ArrayList<>();
                for(int i = 0; i< ans.get(count).size() + 1;i++){
                    if(i==0 || i== ans.get(count).size()){
                        temp.add(1);
                    }else{
                        temp.add(ans.get(count).get(i-1)+ans.get(count).get(i));
                    }
                }
                count++;
                ans.add(temp);
            }
        }
        return ans;
    }

    public List<List<Integer>> generate2(int numRows){
        List<List<Integer>> ans = new ArrayList<>();
        Integer[][] dp = new Integer[numRows][numRows];
        dp[0][0]=1;
        for(int i = 1; i< numRows;i++){
            for(int j=0;j<=i;j++){
                if(j==0||j==i){
                    dp[i][j]=1;
                }
                else{
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                }
            }
        }
        for(int i = 0; i< numRows;i++){
            ans.add(new ArrayList<>(Arrays.asList(Arrays.copyOfRange(dp[i], 0, i + 1))));
        }
        return ans;
    }

    public List<Integer> generate3(int numRows) {
        if (numRows == 0) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>(numRows);

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(i + 1);
            row.add(1);
            for (int j = 1; j < i; j++) {
                List<Integer> prevRow = ans.get(i - 1);
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            if (i > 0) {
                row.add(1);
            }

            ans.add(row);
        }

        return ans.get(ans.size()-1);
    }

    public static void main(String[] args){
        Pascal sol = new Pascal();
        List<List<Integer>> res = sol.generate2(9);
        for (List<Integer> re : res) {
            System.out.println(re);
        }
    }
}
