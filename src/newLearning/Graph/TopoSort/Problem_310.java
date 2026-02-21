package newLearning.Graph.TopoSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem_310 {


    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int[] deg = new int[n];
        List<List<Integer>> graph = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();

        if(n == 1) return List.of(0);

        for(int i=0;i<n;i++)
            graph.add(new ArrayList<>());

        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            deg[edge[0]]++;
            deg[edge[1]]++;
        }

        for(int i=0;i<n;i++)
            if(deg[i]==1)
                queue.add(i);

        while(n > 2){
            int size = queue.size();
            n-=size;
            while(size-- > 0){
                int node = queue.poll();
                for(int ele : graph.get(node)){
                    deg[ele]--;
                    if(deg[ele]==1)
                        queue.add(ele);
                }
            }
        }

        while(!queue.isEmpty()){
            int node = queue.poll();
            res.add(node);
        }

        return res;

    }

}
