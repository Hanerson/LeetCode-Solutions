package Daily;

public class BinaryGap_868 {
    public int binaryGap(int n) {
        int pos = 0, maxLen = 0, prev = -1;

        while(n != 0){
            int leak = n % 2;
            n = n / 2;

            if(leak == 1){
                if(prev != -1){
                    maxLen = Math.max(maxLen, (pos - prev));
                    prev = pos;
                }

                prev = pos;
            }
            pos ++;
        }

        return maxLen;
    }
}
