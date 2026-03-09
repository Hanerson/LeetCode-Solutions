package Daily;

public class MinOperations_1758 {
    public int minOperations(String s) {
        char c = '1';

        int count = 0;
        for(char ch : s.toCharArray()){
            if(ch != c){
                count++;
            }

            c = c == '1' ? '0' : '1';
        }

        return Math.min(count, s.length() - count);
    }
}
