package newLearning.Graph.Basics;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Problem_994 {
    int result = 0;
    public int orangesRotting(int[][] grid) {
        int[] dx = new int[]{-1,0,1,0};
        int[] dy = new int[]{0,1,0,-1};
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++)
                if(grid[i][j]==1) {
                        helper(grid, i, j, 0, dx, dy);
                        result++;
                }

        for(int[] a : grid){
            System.out.println(Arrays.toString(a));
            int val = Arrays.stream(a).anyMatch(i -> i == 1) ? 1 : 0;
            System.out.println(val);
            if(val == 1) return -1;
        }
        return result;
    }

    private void helper(int[][] grid, int sr, int sc, int time, int[] dx, int[] dy) {
        if(sr < 0 || sc < 0 || sr>=grid.length || sc>=grid[0].length || grid[sr][sc] == 2 || grid[sr][sc] == 0) return;
        grid[sr][sc] = 2;
        result = Math.max(result,time);
        for(int i = 0;i<dx.length;i++){
            int newSr = sr + dx[i];
            int newSc = sc + dy[i];
            helper(grid,newSr,newSc,time+1,dx,dy);
        }
    }


    private int helperBFS(int[][] grid,int[] dx,int[] dy) {
        Queue<int[]> queue = new LinkedList<>();
        int rotten = 0;
        for(int index = 0;index<grid.length;index++) {
            if(!queue.isEmpty()) break;
            for (int index2 = 0; index2 < grid[0].length; index2++)
                if (grid[index][index2] == 2){
                    queue.add(new int[]{index, index2});
                }else if (grid[index][index2] == 1){
                    rotten++;
                }
        }
        int result = 0;
        int cnt = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            cnt+=size;
            for(int i=0;i<size;i++){
                int[] pIndexes = queue.poll();
                for(int index = 0;index<dx.length;index++){
                    int newSr = pIndexes[0] + dx[index];
                    int newSc = pIndexes[1] + dy[index];
                    if(newSc >= 0 && newSc < grid[0].length && newSr >= 0 && newSr < grid.length
                            && grid[newSr][newSc] == 1){
                        grid[newSr][newSc] = 2;
                        queue.add(new int[]{newSr,newSc});
                    }
                }
            }
            if(!queue.isEmpty())
                result++;
        }

        return cnt == rotten ? result : -1;
    }

}
