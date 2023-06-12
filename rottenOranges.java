import java.util.LinkedList;
import java.util.Queue;

public class rottenOranges {
    public int orangesRotting(int[][] grid)
    {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        
        int countFresh = 0;
        Queue<Pair> q = new LinkedList<>();
        
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<m; j++) {
                if(grid[i][j]==1) {
                    countFresh++;
                }
                else if(grid[i][j]==2) {
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 2;
                } else {
                    vis[i][j] = 0;
                }
                
            }
        }
        int tm = 0;
        int counter = 0;
        int[] delrow = {-1,1,0,0};
        int[] delcol = {0,0,-1,1};
        while(!q.isEmpty()) {
            int t = q.peek().tm;
            int r = q.peek().row;
            int c = q.peek().col;
            tm = Math.max(tm, t);
            q.poll();
            for(int i = 0; i<4; i++) {
                int nrow = r + delrow[i];
                int ncol = c + delcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]!=2 && grid[nrow][ncol]==1) {
                    vis[nrow][ncol] = 2;
                    counter++;
                    q.add(new Pair(nrow, ncol, t + 1));
                }                
                
                
            }

        }
        if(counter!=countFresh) return -1;
        return tm;
    }

    public static void main(String[] args) {
        
    }
}
class Pair {
    int row;
    int col;
    int tm;
    Pair(int row, int col, int tm) {
        this.row = row;
        this.col = col;
        this.tm = tm;
    }
}