package newLearning.Graph.Basics;

import java.util.*;

public class Problem_2467 {


    public static void main(String[] args) {

        Problem_2467 p = new Problem_2467();

        int[][] edges = {
                {0,1},
                {1,2},
                {1,3},
                {3,4}
        };

        System.out.println(p.mostProfitablePath(edges,3,new int[]{-2,4,2,-4,6}));
    }


    int result = 0;
    int finalResult = 0;
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {


        List<List<Integer>> adj = new ArrayList<>();
        int n = edges.length;

        for(int i = 0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        Map<Integer,Integer> map = new HashMap<>();
        dfsForBob(adj,bob,-1,0,map);
        return dfsForAlice(adj,0,-1,0,map,amount);

    }

    private int dfsForAlice(List<List<Integer>> adj,int source,int parent,int time,Map<Integer,Integer> bobMap,int[] amount){
        int aliceAmount = 0;
        if(bobMap.containsKey(source)) {
            if (bobMap.get(source) == time)
                aliceAmount += (amount[source] / 2);
            else if (bobMap.get(source) > time) {
                aliceAmount = amount[source];
            }
        }else{
            aliceAmount = amount[source];
        }

        int maxResult = Integer.MIN_VALUE;
        for(int ele : adj.get(source)){
            if(ele != parent){
                int curAmount = dfsForAlice(adj, ele, source, time+1, bobMap, amount);
                maxResult = Math.max(curAmount,maxResult);
            }
        }

        if(maxResult == Integer.MIN_VALUE){
            return aliceAmount;
        }else{
            return aliceAmount +  maxResult;
        }
    }

    private boolean dfsForBob(List<List<Integer>> adj,int source,int parent,int time,Map<Integer,Integer> map){
        map.put(source,time);
        if(source==0) return true;
        for(int ele : adj.get(source)){
            if(ele==parent) continue;
            if(dfsForBob(adj,ele,source,time+1,map)) return true;
        }
        map.remove(source);
        return false;
    }

}
