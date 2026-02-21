package newLearning.Graph.Basics;

import java.util.*;

public class Problem_261 {


    public static void main(String[] args) {
        Problem_261 obj = new Problem_261();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            adj.add(new ArrayList<>());
        }

        adj.get(0).addAll(Arrays.asList(0,1));
        adj.get(1).addAll(Arrays.asList(2,3));
        adj.get(1).addAll(Arrays.asList(1,3));

        System.out.println(adj);

        System.out.println(obj.isTree(4,3,adj));
    }

    public boolean isTree(int n, int m, ArrayList<ArrayList<Integer>> edges) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for (ArrayList<Integer> edge : edges) {
            adj.get(edge.get(0)).add(edge.get(1));
            adj.get(edge.get(1)).add(edge.get(0));

        }

        boolean[] visited  = new boolean[n+1];
        Arrays.fill(visited, false);

        if(n == 1 && m == 0) return true;
        if(n-1 != m) return false;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,-1});
        visited[0] = true;

        while(!queue.isEmpty()){
            int[] node  = queue.remove();
            int u = node[0];
            int parent = node[1];
            for(int child : adj.get(u)){
                if(!visited[child]){
                    visited[child] = true;
                    queue.offer(new int[]{child,u});
                }else if(child != parent){
                    return false;
                }
            }
        }
        return true;
    }

}
