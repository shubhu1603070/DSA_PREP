package newLearning.Graph.Basics;

import java.util.ArrayList;
import java.util.List;

public class Problem_466 {

    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> forward = new ArrayList<>();
        List<List<Integer>> backward = new ArrayList<>();
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++){
            forward.add(new ArrayList<>());
            backward.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++){
            int a = connections[i][0], b = connections[i][1];
            forward.get(a).add(b);
            backward.get(b).add(a);
        }

        return dfs(0,visited,forward,backward,0);
    }

    private int dfs(int source, boolean[] visited, List<List<Integer>> forward, List<List<Integer>> backward, int ans){
        visited[source] = true;
        for(int node : forward.get(source)){
            if(!visited[node]){
                ans+=1;
                ans+=dfs(node,visited,forward,backward,ans);
            }
        }
        for(int node : backward.get(source)){
            if(!visited[node]){
                ans+=dfs(node,visited,forward,backward,ans);
            }
        }
        return ans;
    }

}
