package classic150;

import java.util.Arrays;

public class h_index_274 {
    public int hIndex(int[] citations){
        int len = citations.length;
        Arrays.sort(citations);

        int count = 1;
        while(len - count >= 0 && citations[len - count] >= count) count ++;

        return count -1;
    }

    public static void main(String[] args){
        h_index_274 h = new h_index_274();
        System.out.println(h.hIndex(new int[] {1}));
    }
}
