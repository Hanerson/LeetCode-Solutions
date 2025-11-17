package Daily;

public class NumberOfSubstringContainsOnlyOnes_1513 {

    private final int MOD = 1000000007;

    public int numSub(String s){
        char[] arr = (s + '0').toCharArray();
        int i = 0;
        long sum = 0;
        while(arr[i] != '1'){
            i ++;
            if(i == arr.length - 1) return 0;
        }
        int j = i, currLen = 0;
        while(true){
            if(arr[j] == '1'){
                currLen++;
                j ++;
                if(j == arr.length - 1) break;
            }else{
                sum += calculate(currLen) % MOD;
                sum %= MOD;
                while(arr[j] != '1'){
                    j ++;
                    if(j == arr.length - 1) break;
                }
                currLen = 0;
                if(j == arr.length - 1) break;
            }
        }
        sum += calculate(currLen) % MOD;
        return (int)(sum % MOD);
    }

    private long calculate(int len){
        return (long) len * (len + 1) / 2;
    }

    public static void main(String[] args) {
        NumberOfSubstringContainsOnlyOnes_1513 s = new NumberOfSubstringContainsOnlyOnes_1513();
        System.out.println(s.numSub("1010"));
    }
}
