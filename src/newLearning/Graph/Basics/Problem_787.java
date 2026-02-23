package newLearning.Graph.Basics;

import java.util.*;

public class Problem_787 {


    public static void main(String[] args) {
        int[][] edges = {
                {0,1,100},
                {1,2,100},
                {2,0,100},
                {1,3,600},
                {2,3,200}
        };
        findCheapestPrice(4,edges,0,3,1);
        edges = new int[][]{
                {0,1,100},
                {1,2,100},
                {0,2,500}
        };
        findCheapestPrice(4,edges,0,2,1);
        edges = new int[][]{{0,1,100},{1,2,100},{0,2,500}};
        findCheapestPrice(4,edges,0,2,0);
    }

    //Use Bellman ford because it traverses level by level
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        if(dst == 0) return -1;

        int[] dist = new int[n];
        Arrays.fill(dist, (int) 1e5);

        List<List<int[]>> adj = new ArrayList<List<int[]>>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] flight : flights){
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }


        dist[src] = 0;
        for(int i = 0;i <= k;i++){
            int[] temp = Arrays.copyOf(dist, dist.length);
            for(int[] flight : flights){
                int u = flight[0];
                int v = flight[1];
                int w = flight[2];
                if(dist[u] != (int) 1e5 ){
                    temp[v] = Math.min(temp[v], dist[u] + w);
                }
            }
            dist = temp;
        }

        return dist[dst] == (int) 1e5 ? -1 : dist[dst];

    }

}
