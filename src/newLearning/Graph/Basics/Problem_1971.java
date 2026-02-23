package newLearning.Graph.Basics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem_1971 {

    boolean res = false;

    public boolean validPath(int n, int[][] edges, int source, int destination) {

        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] g : edges){
            graph.get(g[0]).add(g[1]);
            graph.get(g[1]).add(g[0]);
        }




        return dfs(graph,source,destination,new boolean[n]);

    }

    private boolean dfs(List<List<Integer>> graph, int source, int destination,boolean[] vis){
        if(source == destination){
            return true;
        }
        vis[source] = true;
        for (int v : graph.get(source)) {
            if(!vis[v]) {
                if (dfs(graph, v, destination, vis)) {
                    return true;
                }
            }
        }
        return false;
    }
}
