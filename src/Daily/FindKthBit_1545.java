package Daily;

public class FindKthBit_1545 {
    public char findKthBit(int n, int k) {
        if(n == 1) return '0';

        int pos = (int)Math.pow(2, n - 1);

        if(k == pos) return '1';
        if(k < pos){
            return findKthBit(n - 1, k);
        }else{
            return findKthBit(n - 1, 2 * pos - k) == '0' ? '1' : '0';
        }
    }
}
