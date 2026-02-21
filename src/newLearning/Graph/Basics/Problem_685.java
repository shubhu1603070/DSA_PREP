package newLearning.Graph.Basics;

import java.util.*;

public class Problem_685 {

    public static void main(String[] args) {
        int[][] edges = {{1,2},{1,3},{2,3}};
        Problem_685 p = new Problem_685();
        System.out.println(Arrays.toString(p.findRedundantDirectedConnection(edges)));
        edges = new int[][]{{1,2},{2,3},{3,4},{4,1},{1,5}};
        System.out.println(Arrays.toString(p.findRedundantDirectedConnection(edges)));
        edges = new int[][]{{2,1},{3,1},{4,2},{1,4}};
        System.out.println(Arrays.toString(p.findRedundantDirectedConnection(edges)));
    }

    int[] parent;

    public int[] findRedundantDirectedConnection(int[][] edges) {

        int n = edges.length;
        parent = new int[n+1];
        int[] parentOf = new int[n+1];
        int[] degree = new int[n+1];
        int[] cd1 = null;
        int[] cd2 = null;
        for (int i = 0; i <=n ; i++) {
            parent[i] = i;
        }

        //Find edge with two parents
        for(int[] edge : edges){
            degree[edge[1]]++;
            if(degree[edge[1]] == 2){
                cd1 = new int[]{parentOf[edge[1]],edge[1]};
                cd2 = new int[]{edge[0],edge[1]};
                break;
            }
            parentOf[edge[1]] = edge[0];
        }

//        System.out.println(Arrays.toString(degree));

        for(int[] edge : edges){
            if(!(Objects.nonNull(cd2) && edge[0] == cd2[0] && edge[1] == cd2[1])){
                //right now we're considering the first edge only and skipping the second one
                if(!union(edge[0],edge[1])){
                    //Found a cycle
                    if(cd1 != null) return cd1;
                    return edge;
                }
            }
        }
        return cd2;
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
