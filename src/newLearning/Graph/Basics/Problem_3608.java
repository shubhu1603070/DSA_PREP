package newLearning.Graph.Basics;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Problem_3608 {


    int[] parent;
    public int minTime(int n, int[][] edges, int k) {
        parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }

        Arrays.sort(edges,(a,b) -> Integer.compare(a[2],b[2]));
        int count = n;
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            if(union(u,v)){
                count--;
            }
            if(count < k) return w;
        }

        return 0;

    }


    private int find(int u){
        if(parent[u] == u) return u;
        return parent[u] = find(parent[u]);
    }


    private boolean union(int u,int v){
        int u_ = find(u);
        int v_ = find(v);
        if(u_ != v_){
            parent[u_] = v_;
            return true;
        }
        return false;
    }



}
