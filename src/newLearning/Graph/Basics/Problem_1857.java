package newLearning.Graph.Basics;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem_1857 {


    public int largestPathValue(String colors, int[][] edges) {

        List<List<Integer>> graph = new ArrayList<>();
        int len = colors.length();
        int[][] nodeColors = new int[len][26];
        int[] inDegrees = new int[len];
        Queue<Integer> queue = new LinkedList<>();
        int processed = 0;
        int result = 0;

        for(int i = 0; i < len; i++){
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            inDegrees[edge[1]]++;
        }

        for(int i = 0; i < len; i++){
            if(inDegrees[i] == 0){
                queue.add(i);
            }
        }


        while (!queue.isEmpty()){
            int node = queue.poll();
            nodeColors[node][colors.charAt(node)-'a']++;
            processed+=1;
            result = Math.max(result,nodeColors[node][colors.charAt(node)-'a']);
            for(int neighbor : graph.get(node)){
                inDegrees[neighbor]--;
                if(inDegrees[neighbor] == 0){
                    queue.add(neighbor);
                }
                for(int i = 0; i < 26; i++){
                    nodeColors[neighbor][i] = Math.max(nodeColors[neighbor][i],nodeColors[node][i]);
                }
            }
        }


        return processed != edges.length ? -1 : result;

    }


}
