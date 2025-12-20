package classic150;

import java.util.*;

/**
 * it seemed that we can solve this problem with three methods: BFS, DFS, Union Set
 * */

public class FindAllPeople_2092 {

    /**
     * uses BFS with temp Graph of time
     * */
    public List<Integer> findAllPeople_BFS(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[2]));

        Set<Integer> known = new HashSet<>();
        known.add(0);
        known.add(firstPerson);

        int i = 0;
        while (i < meetings.length) {
            int time = meetings[i][2];
            Map<Integer, List<Integer>> graph = new HashMap<>();
            Set<Integer> people = new HashSet<>();

            while (i < meetings.length && meetings[i][2] == time) {
                int a = meetings[i][0];
                int b = meetings[i][1];
                graph.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
                graph.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
                people.add(a);
                people.add(b);
                i++;
            }
            Queue<Integer> q = new LinkedList<>();
            Set<Integer> visited = new HashSet<>();

            for (int p : people) {
                if (known.contains(p)) {
                    q.offer(p);
                    visited.add(p);
                }
            }

            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int nxt : graph.getOrDefault(cur, Collections.emptyList())) {
                    if (visited.add(nxt)) {
                        q.offer(nxt);
                    }
                }
            }
            known.addAll(visited);
        }

        return new ArrayList<>(known);
    }
}
