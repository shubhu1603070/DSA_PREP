package newLearning.Graph.Basics;

import java.util.*;

public class Problem_1135 {

    //edges = 10^5 [Prim]

    public int minimumCost(int n, int[][] connections) {
        return usingKruskal(n,connections);
    }

    //Solution - I
    //Here we're not doing it using size or rank we're just doing it directly.
    int[] parents;
    private int usingKruskal(int n, int[][] connections){
        parents = new int[n+1];
        int totalCost = 0;
        int edgeUsed = 0;
        Arrays.sort(connections,Comparator.comparingInt(a->a[2]));
        for(int i=0;i<=n;i++){
            parents[i]=i;
        }

        for(int[] edge : connections){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            int par_u = find(u);
            int par_v = find(v);
            if(par_u!=par_v){
                parents[par_u]=par_v;
                totalCost+=w;
                edgeUsed++;
            }
            if(edgeUsed == n-1) return totalCost;
        }
        return -1;
    }

    private int find(int node){
        if(parents[node] == node) return  node;
        return parents[node] = find(parents[node]);
    }


    class Edge{
        int u,v,w;
        Edge(int u,int v,int w){
            this.u=u;
            this.v=v;
            this.w=w;
        }
    }
    //Solution - II
    private int usingPrim(int n, int[][] connections){
        int totalCost,edgesUsed;
        totalCost = edgesUsed = 0;
        boolean[] vis = new boolean[n+1];
        List<List<Edge>> list = new ArrayList(n+1);
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.w));


        for(int i = 0;i<=n;i++){
            list.add(new ArrayList<>());
        }

        for(int[] edge : connections) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            list.get(u).add(new Edge(u,v,w));
            list.get(v).add(new Edge(v,u,w));
        }
        int source = 1;
        vis[source] = true;

        for(Edge e : list.get(source)){
            pq.offer(e);
        }


        while(!pq.isEmpty() && edgesUsed < n-1){
            Edge e = pq.poll();
            int u = e.u;
            int v = e.v;
            int w = e.w;
            int newNode = source;
            if(!vis[u]){
                newNode = u;
            }else if(!vis[v]){
                newNode = v;
            }else continue;
            edgesUsed++;
            totalCost+=w;
            vis[newNode] = true;

            for(Edge ed : list.get(newNode)){
                if(!vis[ed.v]) pq.offer(ed);
            }
        }

        return edgesUsed == n-1 ? totalCost : -1;
    }


}
