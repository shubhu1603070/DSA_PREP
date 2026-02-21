package newLearning.Graph.Algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {

    public static void main(String[] args) {
        Dijkstra dijkstra = new Dijkstra();
        int[][] edges = {
                {0, 1, 2}, {0, 2, 4}, {1, 3, 7}, {2, 4, 3},
                {3, 5, 1}, {4, 3, 2}, {4, 5, 5}, {1, 2, 1}
        };
        dijkstra.dijAlgo(6,edges,0);
    }

    class Pair implements Comparable<Pair>{
        int distance,node;

        Pair(int distance, int node){
            this.distance = distance;
            this.node = node;
        }

        @Override
        public int compareTo(Pair pair) {
            return this.distance - pair.distance;
        }
    }


    public void dijAlgo(int V, int[][] edges,int source){
        List<List<int[]>> graph = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] distances = new int[V];

        for(int i = 0; i < V; i++){
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            graph.get(u).add(new int[]{v, w});
        }

        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;
        pq.offer(new Pair(0, source));
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            /*
                if the distance we calculated before is greater than the distance[node u] than there is no meaning
                 of even taking it into consideration because node u can be reached in lesser time than this
                 and if we take this into consideration than we might calculate the distance to reach node v wrong
                 right because if the distance[node u] > distance it means this is not the path we should be taking
                 because this path is longer and if we try to use this we'll always calculate the longer path.
             */
            int dis = p.distance;
            int u = p.node;
            if(dis > distances[u]) continue;
            for(int[] neig : graph.get(u)){
                int v =  neig[0];
                int w =  neig[1];
                /*
                    this condition is when we try to reach to node v from node u we have to check
                    if the current distance at node v is already minimum than the node u + weight
                    why distance[node u] + weight because we're trying to reach v from u so we have considered
                    the amount of weight present at distance[node u] because this is min time we took to reach node u
                    from source node + the weight which we'll take to reach v from node u so total weight is
                    distance[node u] + the weight it'll take to reach from node u to node v,
                    and then we add it in the queue also as a distance[v],v because there are chances that the
                    nodes which can be reached from node v can use this path for the minimum distance
                    why only distance[v],v is added
                    distance[v] makes sure that the next path we take should only be minimum instead of maximum
                    this is the actual reason why dijkstra is called greedy because it takes the greedy approach to node v
                    means minimum distance approach to node v from start of the algo
                 */
                if(distances[u] != Integer.MAX_VALUE && distances[v] > w + distances[u]){
                    distances[v] = w + distances[u];
                    pq.offer(new Pair(distances[v], v));
                }
            }
        }
        System.out.println("Shortest distances from source " + source + ": " + Arrays.toString(distances));
    }

}
