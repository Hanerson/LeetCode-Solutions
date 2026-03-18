package Pro100.ArraysAndStrings;

public class StringShift {
    public String stringShift(String s, int[][] shift) {
        long dis = 0;

        for(int[] dirs : shift){
            dis += (dirs[0] == 1) ? dirs[1] : - dirs[1];
        }

        while(dis < 0){
            dis += s.length() * 2;
        }

        dis %= s.length();

        return s.substring((int)dis - 1) + s.substring(0, (int)dis - 1);
    }
}
