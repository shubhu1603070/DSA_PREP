package newLearning.Graph.Algos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Prims {


    public static void main(String[] args) {

        Prims p = new Prims();

        int N = 5;
        int[][] edges = {
                {1, 2, 6}, {2, 3, 4}, {1, 3, 2},
                {3, 4, 3}, {4, 5, 5}, {3, 5, 7}
        };

        int cost = p.primMST(edges, N);
        System.out.println(cost);
        edges = new int[][]{
                {1, 2, 10}, {2, 3, 5}};
        cost = p.primMST(edges, N);
        System.out.println(cost);

    }

    class Edge{
        int u,v,w;
        Edge(int u,int v,int w){
            this.u=u;
            this.v=v;
            this.w=w;
        }
    }


    private int primMST(int[][] edges,int N){
        int totalCost = 0,edgeUsed = 0;
        boolean[] vis = new  boolean[N+1];
        List<List<Edge>> list = new ArrayList<>(N+1);
        /*
            Min heap -> sort on the basis of the weight => This is the step where it becomes GREEDY algo always taking into
            the consideration of the best weight
         */
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.w));

        for(int i=0;i<N+1;i++){
            list.add(new ArrayList<>());
        }

        for(int[] e: edges){
            int u = e[0];
            int v = e[1];
            int w = e[2];
            list.get(u).add(new Edge(u,v,w));
            list.get(v).add(new Edge(v,u,w));
        }
        //Taking 1 as a source node [Source node can be any node]
        int source = 1;
        //Marking the node as visited so we don't visit it again.
        vis[source] = true;
        //Also add this in the priority queue so that it can be used for connecting the other nodes in the current TREE
        for(Edge e : list.get(source)){
            pq.offer(e);
        }


        while(!pq.isEmpty() && edgeUsed < N-1){
            Edge e = pq.poll();
            int u = e.u;
            int v = e.v;
            int w = e.w;
            int newNode = source;
            /*
                Check if the u is already visited and V is not visited
                what it represents is that we can connect V to this tree as it's not already has been used
             */
            if(vis[u] && !vis[v]){
                newNode = v;
            }
            /*
                Check if the v is already visited and U is not visited
                what it represents is that we can connect U to this tree as it's not already has been used
             */
            else if(!vis[u] && vis[v]){
                newNode = u;
            }
            /*
                And if both of the nodes are already been used than we don't have a node to connect to the tree
                As they both are already been connected to the TREE
             */
            else continue;

            /*
                If we find the node which we can connect in the TREE than we have to make sure we increase the COST also right
                because connecting this node to tree will COST something
             */
            totalCost+=w;
            /*
                And if we use this new node to connect to the TREE means we have created one more edge in TREE so the number
                of EDGES will increase by 1
             */
            edgeUsed++;
            /*
                As the newNode is already now connected to TREE we should mark it as visited so that next time we don't consider
                this node for the TREE as it's already been added to the TREE
             */
            vis[newNode] = true;
            /*
                If we have used the new node means connected this new node to the tree we should also make sure to add all
                the edges to the priority queue so that we can find the best cost to connect these nodes also in the tree.
             */
            for(Edge edge : list.get(newNode)){
                if(!vis[edge.v]){
                    pq.offer(edge);
                }
            }
        }
        /*
            Why this because if we don't have N-1 used edges means we couldn't Connect the N nodes
            because to connect N node you need N-1 edges in tree.
         */
        return edgeUsed == N-1 ? totalCost : -1;
    }

}
