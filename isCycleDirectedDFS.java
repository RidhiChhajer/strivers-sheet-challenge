import java.util.ArrayList;

public class isCycleDirectedDFS {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int[] vis = new int[V];
        int[] pathVis = new int[V];
        
        for(int i = 0; i<V; i++) {
            if(vis[i]==0) {
                if(dfs(i, adj, vis, pathVis)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean dfs(int i, ArrayList<ArrayList<Integer>> adj, int[] vis, int[] pathVis) {
        // code here
        vis[i] = 1;
        pathVis[i] = 1;
        for(Integer neighbor: adj.get(i)) {
            if(vis[neighbor]==0) {
                if(dfs(neighbor, adj, vis, pathVis)) {
                    return true;
                }
            } else if(pathVis[neighbor]==1) {
                return true;
            }
        }
        pathVis[i] = 0;
        return false;
        
    }
}
