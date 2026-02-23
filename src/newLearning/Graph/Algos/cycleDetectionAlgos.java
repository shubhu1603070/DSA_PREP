package newLearning.Graph.Algos;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class cycleDetectionAlgos {


    //Undirected Graph

    private boolean isCycle(int node,List<List<Integer>> graph,boolean[] visited,int parent){
        visited[node] = true;
        for(int nei : graph.get(node)){
            if(!visited[nei]) {
                if(isCycle(nei,graph,visited,node)) return true;
            }else if(nei!=parent){
                return true;
            }
        }
        return false;
    }

    private boolean bfsIsCycle(int node,List<List<Integer>> graph,boolean[] visited){
        Queue<int[]> queue = new LinkedList<>();
        visited[node] = true;
        queue.add(new int[]{node,-1});
        while(!queue.isEmpty()){
            int[] cNode = queue.poll();
            int source = cNode[0];
            int parent = cNode[1];
            for(int nei : graph.get(source)){
                if(!visited[nei]){
                    visited[nei] = true;
                    queue.add(new int[]{nei,source});
                }else if(nei != parent){
                   return true;
                }
            }
        }
        return false;
    }

    //Directed Graph

    private boolean directedIsCycle(int node,List<List<Integer>> graph,boolean[] currentPath,boolean[] visited){
        visited[node] = true;
        //add the source node in the current path
        currentPath[node] = true;
        for(int nei : graph.get(node)){
            if(currentPath[nei]){
                return true;
            } else if(!visited[nei]){
                if(directedIsCycle(nei,graph,currentPath,visited)) return true;
            }
        }
        //remove the source node from the current path
        currentPath[node] = false;
        return false;
    }




}
