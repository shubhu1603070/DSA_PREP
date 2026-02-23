package newLearning.Graph.Algos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskals {

    static class DSU{
        int[] parent;
        int[] size;
        int componentCount;
        DSU(int n){
            parent = new int[n+1];
            size = new int[n+1];
            componentCount = n;
            for (int i = 0; i <= n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        private boolean union(int u, int v){
            int par_u = find(u);
            int par_v = find(v);
            if(par_u != par_v){
                if(size[par_u] > size[par_v]){
                    parent[par_v] = par_u;
                    size[par_u] += size[par_v];
                }else{
                    parent[par_u] = par_v;
                    size[par_v] += size[par_u];
                }
                componentCount--;
                return true;
            }else{
                System.out.println("Cycle detected");
                return false;
            }
        }

        private int find(int u){
            if(parent[u] == u) return u;
            return parent[u] = find(parent[u]);
        }

        private int getComponentCount(){
            return componentCount;
        }
    }

    //This helps us in storing the result in sorted order on the basis of weight.
    static class Edge implements Comparable<Edge>{
        int u,v,w;
        Edge(int u, int v, int w){
            this.u = u;
            this.v = v;
            this.w = w;
        }

        public int compareTo(Edge e){
            return Integer.compare(this.w, e.w);
        }
    }

    public long kruskalMST(int N, int[][] edges) {
        DSU dsu = new DSU(N);
        long totalCost = 0;
        int edgeUsed = 0;
        List<Edge> edgeList = new ArrayList<>();
        /*
            Now add all the edges in edgeList because using this edgeList we'll be iterating over it and
            will be performing if we can reach to this location using some previous visited path or not.
         */
        for(int[] edge: edges){
            edgeList.add(new Edge(edge[0], edge[1], edge[2]));
        }

        /*
            why are we soring the edgeList because we want to store the path on the basis of the weight
            to use the compareTo method of Edge class we'll have to sort it right
         */
        Collections.sort(edgeList);

        for(Edge edge: edgeList){
            //to connect n nodes we need n-1 connections right
            if(edgeUsed == N-1) break;
            /*
                check if there is a connection possible means if they don't belong to the same component then
                there is meaning of using this edge otherwise we can reach to city u and v from some previous nodes
                which we already have used and somehow that node is helping us reach to this destination.
             */
            if(dsu.union(edge.u, edge.v)){
                totalCost += edge.w;
                edgeUsed++;
            }
        }
        /*
            Why this condition because if the nodes are not connected directly, or indirectly it means
            there is more than one component present and MST says everything should come under the single component
         */
        return edgeUsed == N-1 ? totalCost : -1;

    }


}
