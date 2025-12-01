package Daily;

public class PossibleOriginalInput_3333 {

    private static final int MOD = 1000000007;

    public int possibleStringCount(String word, int k) {
        int count = 1;
        char prev = word.charAt(0);
        for(char c : word.toCharArray()){
            if(c != prev){
                count++;
                prev = c;
            }
        }
        int op = word.length() - count;
        int sum = 0;
        for(int i = k - count; i <= op; i++){
            sum += comb(op,i) % MOD;
            sum %= MOD;
        }
        return sum;
    }

    private int comb(int n, int k) {
        if (k > n || n < 0 || k < 0) return 0;
        if (k > n - k) k = n - k;

        long numer = 1;
        long denom = 1;

        for (int i = 1; i <= k; i++) {
            numer *= (n - i + 1);
            denom *= i;
        }

        return (int) (numer / denom);
    }

    public static void main(String[] args) {
        PossibleOriginalInput_3333 p = new PossibleOriginalInput_3333();
        System.out.println(p.possibleStringCount("aaabbb", 3));
    }

}
