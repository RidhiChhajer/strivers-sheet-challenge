import java.util.*;
public class graphDFS {
    public static void main(String[] args) {
        
    }

    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int[] vis = new int[V];
        for(int i = 0; i<V; i++) {
            vis[i] = 0;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        dfs(0, adj, vis, ans);
        return ans;
        
    }
    
    public void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, ArrayList<Integer> ans) {
        // Code here
        if(vis[node]==0) {
            vis[node]=1;
            ans.add(node);
            for(Integer neighbor: adj.get(node)) {
                dfs(neighbor, adj, vis, ans);
            }
        } 
        
    }
}
