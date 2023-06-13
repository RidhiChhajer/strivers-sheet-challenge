import java.util.ArrayList;
import java.util.HashSet;

public class distinctIslands {
    int countDistinctIslands(int[][] grid) {
        // Your Code here
        
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        HashSet < ArrayList < Integer >> st = new HashSet < > ();
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<m; j++) {
                if(vis[i][j]==0 && grid[i][j] == 1) {
                    ArrayList < Integer> sa = new ArrayList <Integer>();
                    dfs(i, j, grid, vis, sa, i, j);
                    st.add(sa);
                }
            }
        }
        return st.size();
    }
    
    void dfs(int r, int c, int[][] grid, int[][] vis, ArrayList < Integer> sa, int br, int bc) {
        int n = grid.length;
        int m = grid[0].length;
        vis[r][c] = 1;
        sa.add(r - br);
        sa.add(c - bc);
        
        int[] delrow = {0,0,-1,1};
        int[] delcol = {1,-1,0,0};
        
        for(int i = 0; i<4; i++) {
            int nrow = r + delrow[i];
            int ncol = c + delcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1 && vis[nrow][ncol]==0) {
                vis[nrow][ncol] = 1;
                dfs(nrow, ncol, grid, vis, sa, br, bc);
                   
            }
        }
            
    }
     
}
