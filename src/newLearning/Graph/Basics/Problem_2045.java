package newLearning.Graph.Basics;

import java.util.*;

public class Problem_2045 {

    public static void main(String[] args) {
        int[][] edge = {{1,2},{1,3},{1,4},{3,4},{4,5}};
        Problem_2045 p = new Problem_2045();
        System.out.println(p.secondMinimum(5,edge,3,5));
    }




    public int secondMinimum(int n, int[][] edges, int time, int change) {
        int[] first = new int[n+1];
        int[] second = new int[n+1];
        int infy = (int)1e7;
        Arrays.fill(first,infy);
        Arrays.fill(second,infy);
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++)
            adj.add(new ArrayList<>());

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        //int[] -> {node,distance}
        Queue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a->a[1]));
        q.add(new int[]{1,0});
        first[1] = 0;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int u = cur[0];
            int w = cur[1];
            if(w > second[u]) continue;
            if(u == n && w > first[u]) {
                return w;
            }
            int div = w / change;
            if(div % 2 == 1){
                w = change * (div+1);
            }

            for(int ele :  adj.get(u)){
                int curWeight = w + time;
                if(first[ele] > curWeight){
                    second[ele] = first[ele];
                    first[ele] = curWeight;
                    q.add(new int[]{ele,first[ele]});
                    if(second[ele] != infy) q.add(new int[]{ele,second[ele]});
                }else  if(curWeight > first[ele] && curWeight < second[ele]){
                    second[ele] = curWeight;
                    q.add(new int[]{ele,second[ele]});
                }
            }

        }
        return -1;
    }


    private int bfs(int[][] edges,int n,int time,int change){
        List<List<Integer>> adj = new ArrayList<>();
        int[] dis1 = new int[n+1];
        int[] dis2 = new int[n+1];
        Arrays.fill(dis1,Integer.MAX_VALUE);
        Arrays.fill(dis2,Integer.MAX_VALUE);
        for(int i=0;i<=n;i++)
            adj.add(new ArrayList<>());
        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Queue<int[]> q = new LinkedList<>();
        int currentTime = 0;
        q.offer(new int[]{1,0});
        dis1[1] = 0;
        while(!q.isEmpty()){
            int[] edge = q.remove();
            currentTime = edge[1];
            int wait = 0;
            if((currentTime / change) % 2 == 1){
                wait = change - (currentTime % change);
                currentTime+=wait;
            }
            currentTime+=time;
            for(int ele : adj.get(edge[0])){
                if(dis1[ele] != Integer.MAX_VALUE && currentTime > dis1[1]) {
                    dis2[ele] = dis1[ele];
                    dis1[ele] = currentTime;
                    q.offer(new int[]{ele,currentTime});
                }else{
                    dis1[ele] = currentTime;
                    q.offer(new int[]{ele,currentTime});
                }
            }
            adj.get(edge[0]).clear();
        }
        System.out.println(Arrays.toString(dis1));
        System.out.println(Arrays.toString(dis2));
        return dis2[n] == Integer.MAX_VALUE ? dis1[n] : dis2[n];
    }

}
