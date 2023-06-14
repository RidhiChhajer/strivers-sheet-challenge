import java.util.ArrayList;
import java.util.Arrays;

public class bipartiteDFS {
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        
        int[] color = new int[V];
        Arrays.fill(color, -1);
        
        for(int i = 0; i<V; i++) {
            if(color[i]==-1) {
                if(!isBipartiteHelper(i, 0, V, adj, color)){
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isBipartiteHelper(int node, int c, int V, ArrayList<ArrayList<Integer>>adj, int[] color)
    {
        // Code here
        color[node] = c;
        for(Integer neighbor: adj.get(node)) {
            if(color[neighbor]==-1) {
                if(!isBipartiteHelper(neighbor, 1 - c, V, adj, color)){
                    return false;
                }
            } else if(color[neighbor]==color[node]) {
                return false;
            }
        }
        return true;
        
    }
}
