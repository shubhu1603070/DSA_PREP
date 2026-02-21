package newLearning.Graph.Basics;

import java.util.*;

public class Problem_1557 {

    List<Integer> result=new ArrayList<>();

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] visited = new boolean[n];
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        int maxOutDegree=0;
        int[] outDegree=new int[n];
        for(List<Integer> list : edges) {
            graph.get(list.getFirst()).add(list.getLast());
            outDegree[list.getFirst()]++;
        }
        int max = -1;
        for(int i = 1;i<n;i++){
            if(outDegree[i-1] > outDegree[i] && outDegree[i-1] > max){
                maxOutDegree = i-1;
                max = outDegree[i-1];
            }else if(outDegree[i] > max){
                max = outDegree[i];
                maxOutDegree = i;
            }
        }
        System.out.println(Arrays.toString(outDegree));
        dfs(graph,maxOutDegree,visited);

        for(int i=0;i<n;i++) {
            if(!visited[i]) {
                result.add(i);
                visited[i] = true;
                dfs(graph, i, visited);
            }
        }
        return result;
    }

    private void dfs(List<List<Integer>> edges, int source, boolean[] visited){
        visited[source] = true;
        for(Integer v: edges.get(source)){
            dfs(edges,v,visited);
        }
    }


    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        Set<Integer> visited = new HashSet<>();
        int cIndex = 0;
        visited.add(0);
        for(List<Integer> list : rooms){
            if(!visited.contains(cIndex)) return false;
            for (Integer v : list) {
                if(v != cIndex){
                    visited.addAll(rooms.get(v));
                }
            }
            cIndex++;
        }
        return true;
    }

}
