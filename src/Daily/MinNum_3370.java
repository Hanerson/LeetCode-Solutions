package Daily;

public class MinNum_3370 {
    public int smallestNumber(int n) {
        return (n & (n + 1)) == 0 ? n : (Integer.highestOneBit(n) << 1) - 1;
    }
}
