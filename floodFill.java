public class floodFill {
    public static void main(String[] args) {
        
    }
    public int[][] floodfill(int[][] image, int sr, int sc, int newColor)
    {
        int[][] nimage = image;
        int delRow[] = {-1, 0, +1, 0};
        int delCol[] = {0, +1, 0, -1}; 
        dfs(image, nimage, sr, sc, newColor, delRow, delCol);
        return nimage;
        
    }
    
    public void dfs(int[][] image, int[][] nimage, int r, int c, int newColor, int[] delrow, int[] delcol) {
        int ic = image[r][c];
        nimage[r][c] = newColor;
        int n = image.length;
        int m = image[0].length;
        for(int i = 0; i<4; i++) {
            int nrow = r+delrow[i];
            int ncol = c+delcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && image[nrow][ncol]==ic && nimage[nrow][ncol]!=newColor) {
                dfs(image, nimage, nrow, ncol, newColor, delrow, delcol);
            }
        }
        
    }
}
