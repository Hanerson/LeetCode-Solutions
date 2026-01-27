package Daily;

import java.util.*;

public class MaxKDistinct_3684 {
    public int[] maxKDistinct(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums){
            pq.offer(num);
        }

        HashSet<Integer> set = new HashSet<>();

        while (!pq.isEmpty()){
            int num = pq.poll();

            if(set.contains(num)) continue;
            if(list.size() == k) break;
            set.add(num);
            list.add(num);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        MaxKDistinct_3684 obj = new MaxKDistinct_3684();
        int[] nums = new int[]{84, 93, 100, 77, 90};

        System.out.println(Arrays.toString(obj.maxKDistinct(nums, 3)));
    }
}
