import java.util.*;
public class islands {
    public static void main(String[] args) {
        
    }
    public int numIslands(char[][] grid) {
        // Code here
        
        int[][] vis = new int[grid.length][grid[0].length];
        int count = 0;
        for(int i = 0; i<grid.length; i++) {
            for(int j = 0; j<grid[0].length; j++) {
                if(vis[i][j]==0 && grid[i][j]=='1') {
                    bfs(i, j, grid, vis);
                    count++;
                }
            }
        }
        return count;
    }
    
    public void bfs(int row, int col, char[][] grid, int[][] vis) {
        // Code here

        vis[row][col] = 1;
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row,col));
    
        while(!q.isEmpty()) {
            int ro = q.peek().row;
            int co = q.peek().col;
            q.poll();
            
            for(int delro = -1; delro<=1; delro++) {
                for(int delcol = -1; delcol<=1; delcol++) {
                    int nrow = ro + delro;
                    int ncol = co + delcol;
                    
                    if(nrow>=0 && nrow<grid.length && ncol>=0 && ncol<grid[0].length && vis[nrow][ncol]==0 && grid[nrow][ncol]=='1') {
                        vis[nrow][ncol] = 1;
                        q.add(new Pair(nrow, ncol));
                    }
                }
            }
        }
    }
}

class Pair {
    int row;
    int col;
    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
