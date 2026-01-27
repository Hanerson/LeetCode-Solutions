package Daily;
import java.util.*;

public class DistributeCandies_575 {
    public int distributeCandies(int[] candyType) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : candyType){
            set.add(num);
        }

        int count = candyType.length / 2;
        int size = set.size();

        return Math.min(count, size);
    }
}
