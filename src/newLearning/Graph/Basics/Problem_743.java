package newLearning.Graph.Basics;

import java.util.*;

public class Problem_743 {


    class Pair{
        int v,w;
        public Pair(int v,int w){
            this.v=v;
            this.w=w;
        }
    }

    //Solve using Single Source shortest path
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> graph = new ArrayList<>();
        int infy = Integer.MAX_VALUE - 200;
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge : times) {
            graph.get(edge[0]).add(new Pair(edge[1],edge[2]));
        }

        int[] res = new int[n+1];
        Queue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.w));
        Arrays.fill(res,infy);
        queue.add(new Pair(k,0));
        res[k] = 0;
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            int weight = pair.w;
            int u = pair.v;
            for(Pair p : graph.get(u)){
                int v = p.v;
                int curWeight = p.w;
                if(res[v] > curWeight + weight){
                    res[v] = curWeight + weight;
                    queue.offer(new Pair(v,res[v]));
                }
            }
        }
        int max = Arrays.stream(res,1,res.length).max().getAsInt();
        return max == infy ? -1 : max;
    }


    private int dij(int[][] edges,int n,int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<List<int[]>> graph = new ArrayList<>();

        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            graph.get(edge[0]).add(new int[]{edge[1],edge[2]});
        }


        int[] res = new int[n+1];
        Arrays.fill(res,Integer.MAX_VALUE);
        res[k] = 0;
        pq.add(k);
        while(!pq.isEmpty()){
            int u = pq.remove();
            for(int[] edge : graph.get(u)){
                int v = edge[1];
                int w = edge[2];
                if(res[u] != Integer.MAX_VALUE && res[u] + w < res[v]){
                    res[v] = res[u] + w;
                    pq.offer(w);
                }
            }
        }

        int result = -1;
        for(int i=0;i<=n;i++){
            if(res[i] == Integer.MAX_VALUE) return -1;
            if(result < res[i]) result = res[i];
        }
        return result;

    }

}
