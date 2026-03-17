package Daily;

public class ChampionTower_799 {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] row = new double[query_row + 2];
        row[0] = poured;

        for (int i = 0; i < query_row; i++) {
            double[] next = new double[query_row + 2];

            for (int j = 0; j <= i; j++) {
                double overflow = Math.max(0, row[j] - 1);

                next[j] += overflow / 2;
                next[j + 1] += overflow / 2;
            }

            row = next;
        }

        return Math.min(1, row[query_glass]);
    }
}
