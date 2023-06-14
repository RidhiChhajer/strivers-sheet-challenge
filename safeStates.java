import java.util.ArrayList;
import java.util.List;

public class safeStates {
    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {

        // Your code here
        int[] vis = new int[V];
        int[] pathVis = new int[V];
        int[] safe = new int[V];
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i<V; i++) {
            if(vis[i]==0) {
                dfs(i, adj, vis, pathVis, safe);
            }
        }
        
        for(int i = 0; i<V; i++) {
            if(safe[i]==1) {
                ans.add(i);
            }
        }
        return ans;
    }
    
    
    public boolean dfs(int i, List<List<Integer>> adj, int[] vis, int[] pathVis, int[] safe) {
        // code here
        vis[i] = 1;
        pathVis[i] = 1;
        for(Integer neighbor: adj.get(i)) {
            if(vis[neighbor]==0) {
                if(dfs(neighbor, adj, vis, pathVis, safe)) {
                    return true;
                }
            } else if(pathVis[neighbor]==1) {
                return true;
            }
        }
        safe[i] = 1;
        pathVis[i] = 0;
        return false;
        
    }
}
