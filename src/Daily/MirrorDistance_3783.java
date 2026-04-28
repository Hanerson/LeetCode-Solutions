package Daily;

public class MirrorDistance_3783 {
    public int mirrorDistance(int n) {
        int rev = 0, copy = n;

        while(copy > 0){
            int leak = copy % 10;

            rev = rev * 10 + leak;
            copy /= 10;
        }

        return Math.abs(rev - n);
    }
}
