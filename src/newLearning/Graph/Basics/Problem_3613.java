package newLearning.Graph.Basics;

import java.util.*;

public class Problem_3613 {


    public static void main(String[] args) {

        Problem_3613 p = new Problem_3613();

        int[][] arr1 = {
                {0,1,4},
                {1,2,3},
                {1,3,2},
                {3,4,6}
        };

        int[][] arr2 = {
                {0,1,5},
                {1,2,5},
                {2,3,5}
        };


        System.out.println(p.minCost(5,arr1,2));

        System.out.println("******************");

        System.out.println(p.minCost(4,arr2,1));
    }

    int[] size;
    int[] parent;

    public int minCost(int n, int[][] edges, int k) {

        parent = new int[n+1];
        size = new int[n+1];

        for(int i = 0; i <= n; i++){
            parent[i] = i;
            size[i] = 1;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[2],b[2]));

        for(int[] edge : edges){
            pq.offer(edge);
        }

        PriorityQueue<Integer> mstWeight = new PriorityQueue<>(Comparator.reverseOrder());

        while(!pq.isEmpty()){
            int[] edge = pq.poll();
            // System.out.println(edge[0]+" -> "+edge[1]+" w: "+edge[2]);
            if(union(edge[0],edge[1])){
                mstWeight.offer(edge[2]);
            }
        }

        // System.out.println(mstWeight);

        while(k-1 > 0 && !mstWeight.isEmpty()){
            mstWeight.remove();
            k--;
        }

        return mstWeight.isEmpty() ? 0 : mstWeight.peek();

    }


    private int find(int u){
        if(parent[u] == u) return u;
        return parent[u] = find(parent[u]);
    }


    private boolean union(int u, int v){
        int u_ =  find(u);
        int v_ = find(v);
        if(u_ == v_){
            return false;
        }
        if(size[u_] > size[v_]){
            size[u_] += size[v_];
            parent[v_] = parent[u_];
        }else{
            parent[u_] = parent[v_];
            size[v_] += size[u_];
        }
        return true;
    }


}
