package Pro100.BFS;

import java.util.*;

public class MazeHasPath {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int rows = maze.length;
        int cols = maze[0].length;

        Queue<int[]> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();

        queue.add(start);
        visited.add(start[0] * cols + start[1]);

        int[][] dirs = {{0,-1},{0,1},{-1,0},{1,0}};

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1];
            if(x == destination[0] && y == destination[1]) return true;

            for(int[] dir : dirs){
                int nx = x, ny = y;

                while(nx + dir[0] >= 0 && nx + dir[0] < rows
                        && ny + dir[1] >= 0 && ny + dir[1] < cols
                        && maze[nx + dir[0]][ny + dir[1]] == 0){
                    nx += dir[0];
                    ny += dir[1];
                }

                int code = nx * cols + ny;
                if(!visited.contains(code)){
                    queue.add(new int[]{nx, ny});
                    visited.add(code);
                }
            }
        }

        return false;
    }
}