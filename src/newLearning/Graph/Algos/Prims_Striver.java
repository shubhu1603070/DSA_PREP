package newLearning.Graph.Algos;

import java.util.*;

public class Prims_Striver {

    public static void main(String[] args) {
        Prims_Striver obj = new Prims_Striver();
        int[][] edges = {
                {0, 1, 5}, {1, 2, 3}, {0, 2, 1}
        };
        obj.spanningTree(3,edges);
    }

    class Pair{
        int node;
        int distance;
        Pair(int node, int distance){
            this.node = node;
            this.distance = distance;
        }
    }

    public int spanningTree(int V, int[][] edges) {

        Queue<Pair> q = new PriorityQueue<Pair>((o1, o2) -> o1.distance - o2.distance);

        List<List<Pair>> adj = new ArrayList<>();

        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new Pair(v,w));
            adj.get(v).add(new Pair(u,w));
        }

//822238579379
        boolean[] visited = new boolean[V];
        Arrays.fill(visited,false);
        q.add(new Pair(0, 0));
        int sum = 0;
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int node = p.node;
            int wt = p.distance;
            if(!visited[node]){
                visited[node] = true;
                sum += wt;
                for(Pair pair : adj.get(node)){
                    if(!visited[pair.node]){
                        q.add(new Pair(pair.node,pair.distance));
                    }
                }
            }
        }

        System.out.println(sum);
        return sum;

    }

}
