package newLearning.Graph.Algos;

import java.util.*;

public class BellmanFord {

    public static void main(String[] args) {
        int[][] edges = {
                {0, 1, 5},
                {0, 2, 4},
                {2, 3, 3},
                {3, 1, -10} // The tricky negative edge
        };
        BellmanFord bf = new BellmanFord();
        bf.bellmanFord(edges,4,0);
        edges = new int[][]{
                {0, 1, 2},
                {1, 2, 3},
                {2, 3, -6},
                {3, 1, 1}
        };
//        bf.bellmanFord(edges,4,0);
    }


    private void bellmanFord(int[][] edges,int V,int source){
        int[] distances = new int[V];
        List<List<int[]>> graph = new ArrayList<>();
        int maxInf = Integer.MAX_VALUE;
        /*
            min heap on the basis of distance instead of implementing comparable on Pair we have used comparator
            in the priorityQueue directly which works the same way
         */
//        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.distance));

        for (int i = 0; i < edges.length; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            graph.get(u).add(new int[]{v,w});
        }

        Arrays.fill(distances, maxInf);

        //For the source the minimum distance will always be 0 because this is source node and from source we don't have any weight
        distances[source] = 0;

        //adding the source node in the PQ with distance 0
        boolean updated;
        for(int index = 0; index < V; index++){
            /*
                this flag is used to check if we have already found the best path possible if there is any change the distance means we still have hope
                of finding the best path than this than we update it to true other-wise if this is the best shortest path present than just break from
                there what's the meaning of going forward because we know this is the best and fastest path.
             */
            updated = false;
            for(int[] edge : edges){
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];
                //Check if from node u to node v can be reached in node u + weight time which is lesser than the distance[v] present on node v
                if(distances[u] != maxInf && distances[u] + w < distances[v]){
                    distances[v] = distances[u] + w;
                    //add the distance[v] and v because this will be used for next node to calculate the distance.
                    /*
                        update it to true because we have again found a better path and there are chances that if we follow this path we can reach to
                        other nodes in the shortest time if we follow this path.
                     */
                    updated = true;
                }
            }

            /*
                if there was no change in the distance for any node means this is the best path for all the nodes from the source so break it no meaning of going
                forward and keep checking.
             */
            if(!updated) break;
        }

        //We again update it to false to check for one more time to see if there is any negative cycle present
        updated = false;

        /*
            Check if after V-1 time still there is any change in the distance if there is change means we have negative cycle present in the group,
            and it's not possible to calculate the best route to v from the source node.
         */
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            if(distances[u] != maxInf && distances[u] + w < distances[v]){
                distances[v] = distances[u] + w;
                updated = true;
            }
        }

        //if at the vth time we again find the change in the distance means we have found a negative cycle
        if(updated){
            System.out.println("🚨 Negative Cycle Detected! Shortest paths undefined.");
        }

        System.out.println(Arrays.toString(distances));

    }

}
