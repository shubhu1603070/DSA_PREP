package newLearning.Graph.Algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Kosaraju {

    public static void main(String[] args) {
        int[][] edges = {
                {0,1},
                {1,2},
                {2,0},
                {2,3},
                {3,4},
                {4,7},
                {4,5},
                {5,6},
                {6,4},
                {6,7}
                };

        Kosaraju obj = new Kosaraju();
        obj.kosaraju(edges,8);
    }

    public int kosaraju(int[][] edges,int V) {
        int scc = 0;
        Stack<Integer> stack = new Stack<>();
        List<List<Integer>> adj = new ArrayList<>();
        boolean[] visited = new boolean[V];

        for(int i=0;i<V;i++) adj.add(new ArrayList<>());

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
        }

        /*
            Run DFS for all the nodes and put them in stack so they can be later on utilize for checking if the
            node is reachable from the node where it came from again if it starts from itself.
         */
        for (int i = 0; i < V; i++) {
            if(!visited[i]){
                dfs(stack,i,adj,visited);
            }
        }


        /*
            create a new adjT and reverse all the edges in this new adj List
            Reverse all the edges
         */

        List<List<Integer>> adjT = new ArrayList<>();
        for(int i=0;i<V;i++) {
            adjT.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adjT.get(edge[1]).add(edge[0]);
        }

        //mark all the visited as false again so we can reuse it.
        Arrays.fill(visited,false);

        //Now pop element one by one and again run dfs on the reversed edge graph
        while(!stack.isEmpty()){
            int v = stack.pop();
            if(!visited[v]){
                scc++; //Count the connected components
                dfs2(v,adjT,visited);
                System.out.println();
            }
        }

        return scc;
    }

    private void dfs(Stack<Integer> stack, int node, List<List<Integer>> list, boolean[] visited) {
        if(!visited[node]){
            visited[node] = true;
            for(int edges : list.get(node)){
                if(!visited[edges]){
                    dfs(stack,edges,list,visited);
                }
            }
        }
        stack.push(node);
    }

    private void dfs2(int node,List<List<Integer>> list, boolean[] visited){
        visited[node] = true;
        //Print the node of the connected components
        System.out.print(node+" ");
        for(int edges : list.get(node)) {
            if (!visited[edges]) {
                dfs2(edges, list, visited);
            }
        }
    }
}
