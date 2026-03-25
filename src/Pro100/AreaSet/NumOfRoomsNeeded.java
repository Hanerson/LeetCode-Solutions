package Pro100.AreaSet;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class NumOfRoomsNeeded {
    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        for(int[] interval : intervals){
            if(!queue.isEmpty() && interval[0] > queue.peek()){
                queue.poll();
            }else{
                queue.offer(interval[1]);
            }
        }

        return queue.size();
    }
}
