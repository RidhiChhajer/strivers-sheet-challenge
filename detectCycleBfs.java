import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
public class detectCycleBfs {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int[] vis = new int[V];
        Arrays.fill(vis,0);
        for(int i = 0; i<V; i++) {
            if(vis[i]==0) {
                if(detectCycle(i, adj, vis)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean detectCycle(int sc, ArrayList<ArrayList<Integer>> adj, int[] vis) {
        // Code here
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(sc, -1));
        vis[sc] = 1;
        while(!q.isEmpty()) {
            int nv = q.peek().nv;
            int parent = q.peek().pa;
            q.poll();
            for(Integer neighbor: adj.get(nv)) {
                if(vis[neighbor]==0) {
                    q.add(new Node(neighbor, nv));
                    vis[neighbor] = 1;
                } else if(parent!=neighbor) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        
    }
}
class Node {
    int nv;
    int pa;
    Node(int nv, int pa) {
        this.nv = nv;
        this.pa = pa;
    }
}