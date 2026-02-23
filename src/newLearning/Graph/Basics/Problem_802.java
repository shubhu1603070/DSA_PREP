package newLearning.Graph.Basics;

import java.util.*;

public class Problem_802 {


    //Do this tomorrow

    public static void main(String[] args) {

        int[][] arr1 = {
                {1,2},
                {2,3},
                {5},
                {0},
                {5},
                {},
                {}
        };

        int[][] arr2 = {
                {1,2,3,4},
                {1,2},
                {3,4},
                {0,4},
                {}
        };

        Problem_802 p = new Problem_802();
        System.out.println(p.eventualSafeNodes(arr1));
        System.out.println(p.eventualSafeNodes(arr2));
    }


    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int[] deg = new int[n];

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        //reverse the array
        for(int i = 0; i < n; i++){
            for(int arr : graph[i]){
                adj.get(arr).add(i);
                deg[i]++;
            }
        }

        for(int index = 0; index < n; index++){
            if(deg[index] == 0){
                q.add(index);
            }
        }

        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(node);

            for(int ele : adj.get(node)){
                deg[ele]--;
                if(deg[ele] == 0){
                    q.add(ele);
                }
            }

        }
        Collections.sort(ans);
        return ans;
    }

    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {

        int[] rDeg = new int[k+1];
        int[] cDeg = new int[k+1];

        List<List<Integer>> rAdj = new ArrayList<>();
        List<List<Integer>> cAdj = new ArrayList<>();
        Map<Integer,Integer[]> map = new HashMap<>();

        for(int i = 0;i<=k;i++){
            rAdj.add(new ArrayList<>());
            cAdj.add(new ArrayList<>());
        }
        for(int[] row : rowConditions){
            rAdj.get(row[0]).add(row[1]);
            rDeg[row[1]]++;
        }

        System.out.println("f1_1"+Arrays.toString(rDeg));

        for(int[] col : colConditions){
            cAdj.get(col[0]).add(col[1]);
            cDeg[col[1]]++;
        }

        System.out.println("f2_1"+Arrays.toString(cDeg));

        Queue<Integer> rq = new LinkedList<>();
        Queue<Integer> cq = new LinkedList<>();
        for(int i = 1;i<=k;i++){
            if(rDeg[i] == 0) rq.offer(i);
            if(cDeg[i] == 0) cq.offer(i);
        }

        int n = 0;
        while(!rq.isEmpty()){
            int ele = rq.remove();
            n++;
            map.put(n,new Integer[]{ele,-1});
            for(int v : rAdj.get(ele)){
                rDeg[v]--;
                if(rDeg[v] == 0) rq.offer(v);
            }
        }

        System.out.println("f1_2"+Arrays.toString(rDeg));

        if(n != k){
            return new int[][]{};
        }
        n = 0;
        while(!cq.isEmpty()){
            int ele = cq.remove();
            n++;
            map.computeIfPresent(n, (key, r) -> new Integer[]{r[0], ele});
            for(int v : cAdj.get(ele)){
                cDeg[v]--;
                if(cDeg[v] == 0) cq.offer(v);
            }
        }

        System.out.println("f2_2"+Arrays.toString(cDeg));

        if(n != k){
            return new int[][]{};
        }

        System.out.println("Hello");

        Collection<Integer[]> values = map.values();
        for(Integer[] value : values){
            System.out.println(Arrays.toString(value));
        }

        int[][] res = new int[k][k];
        for(int i = 1;i<=k;i++){
            res[rDeg[i]-1][cDeg[i]-1] = i;
        }

        return res;

    }

}
