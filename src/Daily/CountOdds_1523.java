package Daily;

public class CountOdds_1523 {
    public int countOdds(int low, int high) {
        return pre(high) - pre(low - 1);
    }
    public int pre(int x) {
        return (x + 1) >> 1;
    }
}
