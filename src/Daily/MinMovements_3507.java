package Daily;

import java.util.ArrayList;
import java.util.List;

public class MinMovements_3507 {
    public int minimumPairRemoval(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        int count = 0;

        while (list.size() > 1) {
            boolean isAscending = true;
            int minSum = Integer.MAX_VALUE;
            int targetIndex = -1;

            for (int i = 0; i < list.size() - 1; i++) {
                int sum = list.get(i) + list.get(i + 1);

                if (list.get(i) > list.get(i + 1)) {
                    isAscending = false;
                }

                if (sum < minSum) {
                    minSum = sum;
                    targetIndex = i;
                }
            }

            if (isAscending) {
                break;
            }

            count++;
            list.set(targetIndex, minSum);
            list.remove(targetIndex + 1);
        }

        return count;
    }

    public static void main(String[] args){
        MinMovements_3507 obj = new MinMovements_3507();
        System.out.println(obj.minimumPairRemoval(new int[]{5,2,3,1}));
    }
}
