package Daily;

import java.util.LinkedList;
import java.util.Queue;

public class ContainsCycle_1559 {

    //obviously both DSF and BFS can solve the problem: let's do a practise for these tew method

    //Gemini说也可以使用并查集，试试看
    final int[][] dirs = {{0, 1}, {1, 0}, {-1 ,0}, {0 ,-1}};
    public boolean containsCycle(char[][] grid) {
        // return BFS(grid);
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for(int i = 0; i < grid.length; i ++){
            for(int j = 0; j < grid[0].length; j ++){
                if(visited[i][j]) continue;

                visited[i][j] = true;
                int[] pack = {i, j, -1, -1};

                if(DFS(grid, pack, visited, grid[i][j])) return true;
            }
        }

        return false;
    }

    public boolean DFS(char[][] grid, int[] info /*{x, y, px, py}*/, boolean[][] visited, char target){
        for(int dir = 0; dir < 4; dir ++){
            int dx = info[0] + dirs[dir][0], dy = info[1] + dirs[dir][1];

            if(dx < 0 || dx >= grid.length || dy < 0 || dy >= grid[0].length) continue;
            if(grid[dx][dy] != target) continue;

            if(visited[dx][dy] && !(dx == info[2] && dy == info[3])){
                return true;
            }
            if(!visited[dx][dy]){
                visited[dx][dy] = true;
                int[] newInfo = new int[]{dx, dy, info[0], info[1]};
                if (DFS(grid, newInfo, visited, target)) return true;
            }
        }

        return false;
    }

    public boolean BFS(char[][] grid){
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        Queue<int[]> queue = new LinkedList<>();

        for(int i =0; i < grid.length; i ++){
            for(int j = 0; j < grid[0].length; j ++){
                if(visited[i][j]) continue;

                queue.add(new int[]{i, j, -1, -1});
                visited[i][j] = true;
                char checkChar = grid[i][j];

                while(queue.size() != 0){
                    int[] point = queue.poll();
                    int x = point[0], y = point[1];

                    for(int dir = 0; dir < 4; dir ++){
                        int dx = x + dirs[dir][0], dy =y + dirs[dir][1];

                        if(dx < 0 || dx >= grid.length || dy < 0 || dy >= grid[0].length) continue;
                        if(grid[dx][dy] != checkChar) continue;

                        if(visited[dx][dy] && !(dx == point[2] && dy == point[3])){
                            return true;
                        }else{
                            if(!visited[dx][dy]){
                                queue.offer(new int[]{dx, dy, x, y});
                                visited[dx][dy] = true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
