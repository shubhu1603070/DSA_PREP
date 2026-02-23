package newLearning.Graph.Basics;

public class Problem_684 {

    int[] parent;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n+1];
        for(int i = 0;i <= n;i++){
            parent[i] = i;
        }

        int[] ed = new int[2];
        for(int[] edge : edges){
            if(!union(edge[0],edge[1])){
                ed = edge;
            }
        }

        return ed;
    }

    public int find(int u){
        if(parent[u] == u) return u;
        return parent[u] = find(parent[u]);
    }

    public boolean union(int u,int v){
        int u_ = find(u);
        int v_ = find(v);
        if(u_ != v_){
            parent[u_] = v_;
            return true;
        }
        return false;
    }

}
