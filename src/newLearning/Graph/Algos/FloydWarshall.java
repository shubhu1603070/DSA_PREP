package newLearning.Graph.Algos;

import java.util.Arrays;
import java.util.Map;

public class FloydWarshall {


    public static void main(String[] args) {
        FloydWarshall fw = new FloydWarshall();
        int[][] edges = {
                {0, 1, 5},
                {0, 2, 4},
                {2, 3, 3},
                {3, 1, -10} // The tricky negative edge
        };
//        fw.floydWarshall(edges,4);
        edges = new int[][]{
                {0, 1, 2},
                {1, 2, 3},
                {2, 3, -6},
                {3, 1, 1}
        };
        fw.floydWarshall(edges,4);
    }

    private void floydWarshall(int[][] edges,int V){
        int[][] result = new int[V][V];
        int maxInfty = 1_000_000_000;

        for(int i = 0; i < V; i++){
            Arrays.fill(result[i],maxInfty);
            result[i][i] = 0;
        }

        for(int[] k : result){
            System.out.println(Arrays.toString(k));
        }

        for(int[] edge : edges){
            int u =  edge[0];
            int v =  edge[1];
            int w =  edge[2];
            result[u][v] = Math.min(result[u][v], w);
        }
        System.out.println("Arrays second:");
        for(int[] k : result){
            System.out.println(Arrays.toString(k));
        }

        /*
            Main idea is to run the relaxation 2*V times for each node
            this way the outer kth loop helps us know if there is path better than
            from i -> j if we go through i -> k -> j if there is path i -> k -> j better than
            i -> j than use this path instead of i -> j
         */
        for(int k = 0;k < V;k++){
            for(int i = 0;i<V;i++){
                for(int j = 0;j<V;j++){
                    /*
                        Check if both i->k and k->j paths are reachable (i.e., not INF) if yes than:

                        check if the result[i][j] (i -> j) is min
                        or
                        result[i][k] -> result[k][j] (i -> k -> j)
                     */
                    result[i][j] = (result[i][k] != maxInfty && result[k][j] != maxInfty) ? result[i][j] = Math.min(result[i][j],result[i][k]+result[k][j]) : result[i][j];
                }
            }
        }

        /*
            to check if there is any negative cycle present we have to check the diagonals of the result
            if the diagonals of the result contains value < 0 means there is negative cycle present
         */
        boolean flag = false;
        for(int i=0;i<V;i++){
            if(result[i][i] < 0){
                flag = true;
                break;
            }
        }

        if(flag){
            System.out.println("🚨 Negative Cycle Detected! Shortest paths undefined.");
        }

        for(int[] ele : result)
            System.out.println(Arrays.toString(ele));

    }

}
