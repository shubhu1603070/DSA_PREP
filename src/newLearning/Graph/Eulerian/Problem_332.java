package newLearning.Graph.Eulerian;

import java.util.*;
import java.util.stream.Collectors;

public class Problem_332 {

    List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        String[][] data = {{"JFK","SFO"}, {"JFK","ATL"}, {"SFO","ATL"}, {"ATL","JFK"}, {"ATL","SFO"}};
        List<List<String>> result = Arrays.stream(data)
                .map(Arrays::asList)
                .toList();
        Problem_332 p = new Problem_332();
        System.out.println(p.findItinerary(result));
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String,PriorityQueue<String>> graph = new HashMap<>();

        for(List<String> ticket:tickets){
            String source = ticket.get(0);
            String destination = ticket.get(1);
            if(!graph.containsKey(source)){
                graph.put(source,new PriorityQueue<>());
            }
            graph.get(source).offer(destination);
        }

        dfs(graph,"JFK");
        Collections.reverse(result);
        return result;
    }


    public void dfs(Map<String,PriorityQueue<String>> graph,String source){

        PriorityQueue<String> pq = graph.get(source);

        while(Objects.nonNull(pq) && !pq.isEmpty()){
            String des =  pq.poll();
            dfs(graph,des);
        }

        result.add(source);

    }



}
