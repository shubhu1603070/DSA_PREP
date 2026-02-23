package newLearning.Graph.Basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem_797 {


    public static void main(String[] args) {
        int[][] arr1 = {
                {1,2},
                {3},
                {3},
                {}
        };

        int[][] arr2 = {
                {4,3,1},
                {3,2,4},
                {3},
                {4},
                {}
        };

//        allPathsSourceTarget(arr1);
//        allPathsSourceTarget(arr2);
    }

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++){
            for(int j :  graph[i]){
                adj.get(i).add(j);
            }
        }


        for(int i = 0; i < n; i++){
            dfs(i,adj,new ArrayList<>());
        }
        return result;
    }

    private void dfs(int source,List<List<Integer>> adj,List<Integer> path){
        path.add(source);
        if(source == adj.size())
            result.add(new ArrayList<>(path));
        for(int ele : adj.get(source)){
            if(!path.contains(ele))
                dfs(ele, adj, path);
        }
        path.removeLast();
    }

}
