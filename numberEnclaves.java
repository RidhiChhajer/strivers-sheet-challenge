import java.util.LinkedList;
import java.util.Queue;

public class numberEnclaves {
    public static void main(String[] args) {
        
    }
    int numberOfEnclaves(int[][] grid) {

        // Your code here
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0; i<n; i++) {
            if(grid[i][0]==1 && vis[i][0]==0) {
                q.add(new Pair(i, 0));
                vis[i][0]=1;
            }
            
            if(grid[i][m-1]==1 && vis[i][m-1]==0) {
                q.add(new Pair(i, m-1));
                vis[i][m-1]=1;
            }
        }
        
        for(int i = 0; i<m; i++) {
            if(grid[0][i]==1 && vis[0][i]==0) {
                q.add(new Pair(0, i));
                vis[0][i]=1;
            }
            
            if(grid[n-1][i]==1 && vis[n-1][i]==0) {
                q.add(new Pair(n-1, i));
                vis[n-1][i]=1;
            }
        }
        int[] delrow = {0,0,-1,1};
        int[] delcol = {-1,1,0,0};
        while(!q.isEmpty()) {
            int r = q.peek().row;
            int c = q.peek().col;
            q.poll();
            for(int i = 0; i<4; i++) {
                int nrow = r + delrow[i];
                int ncol = c + delcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1 && vis[nrow][ncol]==0) {
                    q.add(new Pair(nrow, ncol));
                    vis[nrow][ncol] = 1;
                }
            }
            
        }
        int count = 0;
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<m; j++) {
                if(vis[i][j]!=1 && grid[i][j]==1) {
                    count++;
                }
            }
        }
        return count;
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