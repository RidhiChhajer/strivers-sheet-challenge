import java.util.ArrayList;
import java.util.Arrays;

public class detectCycleDfs {
    public static void main(String[] args) {
        
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int[] vis = new int[V];
        Arrays.fill(vis, 0);
        for(int i = 0; i<V; i++) {
            if(vis[i]==0) {
                if(dfs(i, -1, adj, vis)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, int[] vis) {
        vis[node] = 1;
        for(Integer neighbor: adj.get(node)) {
            if(vis[neighbor]==0) {
                if(dfs(neighbor, node, adj, vis)) {
                    return true;
                }
            } else if (neighbor!=parent) {
                return true;
            }
        }
        return false;
    }
}
