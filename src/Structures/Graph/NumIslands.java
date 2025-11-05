package Structures.Graph;

public class NumIslands {
    public int numIslands(char[][] grid){
        int m =  grid.length+2, n = grid[0].length+2;
        char[][] broad =  new char[m][n];
        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i==0 || j==0 || i==m-1 || j==n-1) broad[i][j] = '0';
                else{
                    broad[i][j] = grid[i-1][j-1];
                }
            }
        }

        int count = 0;
        int[] dx = new int[] {1,0,-1,0}, dy = new int[] {0,1,0,-1};

        for(int i=0; i< m; i++){
            for(int j=0; j<n; j++){
                if(broad[i][j]=='1' && !visited[i][j]){
                    printIsland(visited, broad, i, j, dx, dy);
                    count++;
                }
            }
        }

        return count;
    }

    public void printIsland(boolean[][] visited, char[][] broad, int i, int j, int[] dx, int[] dy){
        visited[i][j] = true;
        for(int dir=0; dir<4; dir++){
            int x = i + dx[dir];
            int y = j + dy[dir];
            if(!visited[x][y] && broad[x][y]=='1'){
                printIsland(visited, broad, x, y, dx, dy);
            }
        }
    }

    public static void main(String[] args) {
        NumIslands obj = new NumIslands();
        char[][] grid = new char[][]{
                {'1', '0', '1', '1', '1'},
                {'1', '0', '1', '0', '1'},
                {'1', '1', '1', '0', '1'}
        };
        System.out.println(obj.numIslands(grid));
    }
}

