import java.util.LinkedList;
import java.util.Queue;

public class o1matrix {
    public int[][] nearest(int[][] grid)
    {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        
        int[][] vis = new int[n][m];
        int[][] ans = new int[n][m];
        
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<m; j++) {
                if(grid[i][j] == 1) {
                    q.add(new Pair(i, j, 0));
                    ans[i][j] = 0;
                    vis[i][j] = 1;
                }
            }
        }
        int[] delrow = {0,0,-1,1};
        int[] delcol = {1,-1,0,0};
        while(!q.isEmpty()) {
            int r = q.peek().row;
            int c = q.peek().col;
            int dist = q.peek().step;
            q.poll();
            for(int i = 0; i<4; i++) {
                int nrow = r + delrow[i];
                int ncol = c + delcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==0 && vis[nrow][ncol]==0) {
                    q.add(new Pair(nrow, ncol, dist + 1));
                    vis[nrow][ncol] = 1;
                    ans[nrow][ncol] = dist + 1;
                }
            }
            
        }
        return ans;
    }

    public static void main(String[] args) {
        
    }
}
class Pair {
    int row;
    int col;
    int step;
    Pair(int row, int col, int step) {
        this.row = row;
        this.col = col;
        this.step = step;
    }
}