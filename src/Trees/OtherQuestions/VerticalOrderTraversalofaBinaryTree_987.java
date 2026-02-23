package Trees.OtherQuestions;

import Trees.TreeNode;

import java.util.*;

public class VerticalOrderTraversalofaBinaryTree_987 {

    class Tuple {
        public int row, col;
        TreeNode node;

        public Tuple(int row, int col, TreeNode node) {
            this.row = row;
            this.col = col;
            this.node = node;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "row=" + row +
                    ", col=" + col +
                    ", node=" + node.val +
                    '}';
        }
    }


    public List<List<Integer>> verticalTraversal(TreeNode root) {

    Map<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
    Queue<Tuple> queue = new LinkedList<>();
    queue.offer(new Tuple(0,0,root));

    while(!queue.isEmpty()){
        Tuple tuple = queue.poll();
        TreeNode node = tuple.node;
        int row = tuple.row;
        int col = tuple.col;

        if(!map.containsKey(row)){
            map.put(row,new TreeMap<>());
        }
        if(!map.get(row).containsKey(col)){
            map.get(row).put(col,new PriorityQueue<>());
        }
        map.get(row).get(col).offer(node.val);

        if(node.left!=null){
            queue.offer(new Tuple(row-1,col+1,node.left));
        }
        if(node.right!=null){
            queue.offer(new Tuple(row+1,col+1,node.right));
        }
    }
        System.out.println(map);
    List<List<Integer>> result = new ArrayList<>();
    for(TreeMap<Integer,PriorityQueue<Integer>> values : map.values()){
        result.add(new ArrayList<>());
        System.out.println(values);
        for (PriorityQueue<Integer> pq : values.values()){
            while (!pq.isEmpty()){
                result.get(result.size()-1).add(pq.poll());
            }
        }
        System.out.println(result);
    }
    return result;
    }

//    private void dfs(TreeNode root,int row,int col) {
//        if(root == null) return;
//        dfs(root.left,row+1,col-1);
//        dfs(root.right,row+1,col+1);
//        list.add(new Pair(row,col,root));
//    }


}
