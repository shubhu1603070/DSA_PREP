package newLearning.Graph.Basics;

import java.util.*;

public class Problem_210 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> set = new ArrayList<>();
        Queue<Integer> queue = new PriorityQueue<>();
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
        for (int[] arr : prerequisites) {
            int x = arr[0];
            int y = arr[1];
            if (x == y) return new int[0];
            graph.get(x).add(y);
        }

        for(List<Integer> list : graph){
            for(int element : list){
                inDegree[element]++;
            }
        }

        System.out.println(Arrays.toString(inDegree));

        for(int i=0;i<inDegree.length;i++){
            if(inDegree[i]==0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int course = queue.poll();
            set.add(course);
            for(int ele:graph.get(course)){
                inDegree[ele]--;
                if(inDegree[ele]==0){
                    queue.add(ele);
                }
            }
        }
        System.out.println(set);
        Collections.reverse(set);
        return set.size() == numCourses ? set.stream().mapToInt(Integer::intValue).toArray() : new int[0];
    }

}
