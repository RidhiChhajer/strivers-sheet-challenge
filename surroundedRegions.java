public class surroundedRegions {
    static char[][] fill(int n, int m, char a[][])
    {
        // code here
        int[][] vis = new int[n][m];
        int[] delrow = {0,0,-1,1};
        int[] delcol = {-1,1,0,0};
        for(int i = 0; i<n; i++) {
            if(a[i][0]=='O' && vis[i][0]==0) {
                dfs(i, 0, vis, delrow, delcol, a);
            }
            if(a[i][m-1]=='O' && vis[i][m-1]==0) {
                dfs(i, m-1, vis, delrow, delcol, a);
            }
        }
        
        for(int i = 0; i<m; i++) {
            if(a[0][i]=='O' && vis[0][i]==0) {
                dfs(0, i, vis, delrow, delcol, a);
            }
            if(a[n-1][i]=='O' && vis[n-1][i]==0) {
                dfs(n-1, i, vis, delrow, delcol, a);
            }
        }
        
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<m; j++) {
                if(vis[i][j]==0) {
                    a[i][j] = 'X';
                }
            }
        }
        
        
        return a;
    }
    
    public static void dfs(int r, int c, int[][] vis, int[] delrow, int[] delcol, char a[][]) {
        int n = vis.length;
        int m = vis[0].length;
        vis[r][c] = 1;
        for(int i = 0; i<4; i++) {
            int nrow = r + delrow[i];
            int ncol = c + delcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && a[nrow][ncol]=='O' && vis[nrow][ncol]==0) {
                dfs(nrow, ncol, vis, delrow, delcol, a);
            }
        }
    }
    public static void main(String[] args) {
        
    }
}
