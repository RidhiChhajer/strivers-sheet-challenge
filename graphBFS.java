import java.util.*;
public class graphBFS {
    public static void main(String[] args) {
        
    }
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int[] vis = new int[V];
        for(int i = 0; i<V; i++) {
            vis[i] = 0;
        }
        vis[0] = 1;
        
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        
        ArrayList<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()) {
            int temp = q.poll();
            ans.add(temp);
            
            ArrayList<Integer> neighbours = adj.get(temp);
            for(Integer i: neighbours) {
                if(vis[i]==0) {
                    vis[i] = 1;
                    q.add(i);
                } 
            }
        }
        
        return ans;
    }
}
