package Basic50;

public class FindWinner_1275 {
    private final int[][] possible = {
            {0,1,2},{3,4,5},{6,7,8},
            {0,3,6},{1,4,7},{2,5,8},
            {0,4,8},{2,4,6}
    };

    public String tictactoe(int[][] moves) {
        char[] posit = new char[9];
        char curr = 'A';

        for (int[] move : moves) {
            posit[move[0] * 3 + move[1]] = curr;
            curr = (curr == 'A') ? 'B' : 'A';
        }

        for (int[] pos : possible) {
            if (posit[pos[0]] != '\0'
                    && posit[pos[0]] == posit[pos[1]]
                    && posit[pos[1]] == posit[pos[2]]) {
                return String.valueOf(posit[pos[0]]);
            }
        }

        return moves.length < 9 ? "Pending" : "Draw";
    }

}
