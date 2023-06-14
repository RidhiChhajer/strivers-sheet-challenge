import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class bipartiteBFS {
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        
        int[] color = new int[V];
        Arrays.fill(color, -1);
        
        for(int i = 0; i<V; i++) {
            if(color[i]==-1) {
                if(!isBipartiteHelper(i, V, adj, color)){
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isBipartiteHelper(int st, int V, ArrayList<ArrayList<Integer>>adj, int[] color)
    {
        // Code here
        Queue<Integer> q = new LinkedList<>();
        q.add(st);
        color[st] = 0;
        
        while(!q.isEmpty()) {
            int temp = q.poll();
            
            for(Integer neighbor: adj.get(temp)) {
                if(color[neighbor]==-1) {
                    color[neighbor] = 1 - color[temp];
                    q.add(neighbor);
                } else if(color[neighbor]==color[temp]) {
                    return false;
                }
            }
        }
        return true;
    }
}
