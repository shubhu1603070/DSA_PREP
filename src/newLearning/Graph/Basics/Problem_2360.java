package newLearning.Graph.Basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem_2360 {

    public int longestCycle(int[] edges) {

        List<List<Integer>> graph = new ArrayList<>();
        boolean[] visited = new boolean[edges.length];

        for(int i = 0; i < edges.length; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++){
            graph.get(i).add(edges[i]);
        }
        for(List<Integer> list : graph){
            System.out.println("list: " + list);
        }
        int[] path = new int[edges.length];
        for(int i = 0; i < edges.length; i++) {
            if(!visited[i]) {
                count = 0;
                System.out.println("starting source " + i);
                dfsIsCycle(i, visited, graph, path);
            }
        }
        System.out.println(res);
        System.out.println(Arrays.toString(path));
        return res > 0 ? res : -1;
    }

    int count = 0;
    int res = 0;
    private void dfsIsCycle(int source,boolean[] visited, List<List<Integer>> graph,int[] path) {
        count++;
        path[source] = count;
        visited[source] = true;
        for(int nei : graph.get(source)){
            if(nei != -1) {
                if (!visited[nei]) {
                    System.out.println("connecting starting source " + nei);
                    dfsIsCycle(nei, visited, graph, path);
                } else if(path[nei] != 0){
                    System.out.println(source + " : " + nei + " : " + path[source] + " : " + path[nei] + " : " + res);
                    int currentLen = (path[source] - path[nei]) + 1;
                    res = Math.max(res, currentLen);
                    System.out.println("result : " + res);
                }
            }
        }
        path[source] = 0;
    }

    public static void main(String[] args) {
        Problem_2360 obj = new Problem_2360();
        obj.longestCycle(new int[]{-1,4,-1,2,0,4});
    }


}
