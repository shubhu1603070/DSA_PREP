package newLearning.Graph.Basics;

import java.util.Arrays;

public class Problem_200 {
    int count = 0;
    public int numIslands(char[][] grid) {
        int[] dx = new int[]{-1,0,1,0};
        int[] dy = new int[]{0,1,0,-1};
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++)
                if(grid[i][j]=='1') {
                    count++;
                    helper(grid, i, j, dx, dy);
                }
        return count;
    }

    private boolean helper(char[][] grid,int sr,int sc,int[] dx,int[] dy){
        if(sr < 0 || sc < 0 || sr>=grid.length || sc>=grid[0].length || grid[sr][sc]!='1') return false;
        grid[sr][sc]='2';
        for(int i = 0;i<dx.length;i++){
            int newSR = sr + dx[i];
            int newSC = sc + dy[i];
            if(helper(grid,newSR,newSC,dx,dy)) count++;
        }
        return true;
    }

}
