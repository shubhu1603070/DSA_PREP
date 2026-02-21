package newLearning.Graph.Algos;

import java.util.*;

public class TopoSortOrKahnsAlgo {

    public static void main(String[] args) {
        TopoSortOrKahnsAlgo topoSortOrKahnsAlgo = new TopoSortOrKahnsAlgo();
        List<List<Integer>> list = new LinkedList<>();
        int size = 4;
        for(int i =0;i<size;i++){
            list.add(new ArrayList<>());
        }
        list.get(0).add(1);
        list.get(1).add(2);
        list.get(2).add(3);
        list.get(3).add(1);
        topoSortOrKahnsAlgo.topoSortUsingBFS(list);
    }

    private void topoSortUsingBFS(List<List<Integer>> graph){
        int[] inDegree = new int[graph.size()];
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> elementsInOrder = new LinkedList<>();

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
            int currentVertex = queue.poll();
            elementsInOrder.add(currentVertex);
            for(int nei : graph.get(currentVertex)){
                inDegree[nei]--;
                if(inDegree[nei]==0){
                    elementsInOrder.add(nei);
                    queue.add(nei);
                }
            }
        }

        System.out.println(elementsInOrder);
        System.out.println(Arrays.toString(inDegree));

        //to check if there is a cycle check if the elements present in elementsInOrder are == total number of nodes present in graph
        if(elementsInOrder.size()!=graph.size()){
            System.out.println("There is a cycle present in this graph...");
        }

        //Also another way to check is check the indegree array and check if there is any element whose value is still not 0
        for(int element : inDegree)
            if(element != 0) {
                System.out.println("There is a cycle present in this graph...");
                break;
            }
    }

}
