package Algorithm.BFS;

import java.util.*;

public class CourseOrder {
    public int[] findOrder(int numCourses, int[][] prerequisites){
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int[] pair : prerequisites){
            if(map.containsKey(pair[0])) {
                map.get(pair[0]).add(pair[1]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(pair[1]);
                map.put(pair[0], list);
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < numCourses; i++){
            if(!map.containsKey(i)) queue.add(i);
        }

        List<Integer> order = new ArrayList<>();

        while(!queue.isEmpty()){
            int course = queue.poll();
            order.add(course);
            List<Integer> toRemove = new ArrayList<>();

            for(int key : map.keySet()){
                List<Integer> preList = map.get(key);
                preList.remove(Integer.valueOf(course));
                if(preList.isEmpty()){
                    queue.add(key);
                    toRemove.add(key);
                }
            }

            for(int key : toRemove){
                map.remove(key);
            }
            // a brand-new method to view my codes!
        }

        if(order.size() == numCourses) {
            return order.stream().mapToInt(Integer::intValue).toArray();
        } else {
            return new int[0];
        }
    }
}
