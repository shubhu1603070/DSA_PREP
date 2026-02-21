package newLearning.Graph.Basics;

import java.util.*;

public class Problem_1319 {

    public static void main(String[] args) {
        Problem_1319 p = new Problem_1319();
        p.makeConnected(6,new int[][]{{0,1},{0,2},{0,3},{1,2},{1,3}});
//        p.makeConnected(4,new int[][]{{0,1},{0,2},{1,2}});
    }

    public int makeConnected(int n, int[][] connections) {
        List<List<Integer>> graph = new ArrayList<>();

        boolean[] visited = new boolean[n];
        int independentConnections = 0;

        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] g : connections){
            graph.get(g[0]).add(g[1]);
            graph.get(g[1]).add(g[0]);
        }

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(i,graph,visited);
                independentConnections++;
            }
        }
        int connection = independentConnections - 1;
        return connections.length >= connection ? connection : -1;
    }

    private void dfs(int source, List<List<Integer>> graph, boolean[] visited) {
        visited[source] = true;
        for(Integer v : graph.get(source)){
            if(!visited[v]){
                dfs(v,graph,visited);
            }
        }
    }

}
