package newLearning.Graph.Basics;

import java.util.LinkedList;
import java.util.Queue;

public class Steps_By_Knight {

    private int[][] cordinates = new int[][]{{-2,-1},{-2,1},{2,1},{2,-1},{-1,2},{1,2},{-1,-2},{1,-2}};

    public int minStepToReachTarget(int knightPos[], int targetPos[], int n) {
        // Code here
        int src_x = n-knightPos[1];
        int src_y = knightPos[0]-1;
        int target_x = n-targetPos[1];
        int target_y = targetPos[0]-1;
        return helper(src_x,src_y,target_x,target_y,n);
    }

    private int helper(int srcX, int srcY, int targetX, int targetY, int n) {

        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<int[]>();
        int steps = 0;

        visited[srcX][srcY] = true;
        queue.add(new int[]{srcX, srcY});

        while (!queue.isEmpty()) {
            int size =  queue.size();
            while(size>0){
                int[] cur = queue.poll();
                int curX = cur[0];
                int curY = cur[1];
                if(curX == targetX && curY == targetY){
                    return steps;
                }
                for(int i=0;i<=cordinates.length;i++){
                    int new_x = curX+cordinates[i][0];
                    int new_y = curY+cordinates[i][1];
                    if(new_x > 0 && new_x < n && new_y > 0 && new_y < n && !visited[new_x][new_y]){
                        visited[new_x][new_y] = true;
                        queue.add(new int[]{new_x,new_y});
                    }
                }
                size--;
            }
            steps+=1;
        }
        return -2;
    }

}
