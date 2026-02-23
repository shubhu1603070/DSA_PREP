package newLearning.Graph.Basics;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Geeks_Village_And_Wells {

    int[][] directions = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
    int maxValue = 100001;

    public static void main(String[] args) {
        Geeks_Village_And_Wells g = new Geeks_Village_And_Wells();
        g.chefAndWells(3,3,new char[][]{{'H','H','H'},{'H','W','H'},{'H','H','H'}});
        g.chefAndWells(5,5,new char[][]{{'H','N','H','H','H'},{'N','N','H','H','W'},{'W','H','H','H','H'},{'H','H','H','H','H'},{'H','H','H','H','H'}});
    }

    public int[][] chefAndWells(int n, int m, char[][] grid) {
//        int[][] visited = new int[n][m];
//        for(int[] a : visited){
//            Arrays.fill(a, maxValue);
//        }
//
//        helper(visited,grid,0,0,0);
//        for(int index = 0;index<grid.length;index++){
//            for(int index1 = 0;index1<grid[0].length;index1++){
//                if(visited[index][index1] == maxValue){
//                    visited[index][index1] = -1;
//                }else if(grid[index][index1]!='.'){
//                    visited[index][index1] = 2 * visited[index][index1];
//                }
//            }
//        }
//        for(int[] ele : visited){
//            System.out.println(Arrays.toString(ele));
//        }
//        return visited;

        return helperBFS(grid, n, m);
    }


    private int[][] helperBFS(char[][] grid,int n,int m){
        Queue<int[]> queue = new LinkedList<>();
        int[][] dist = new int[n][m];
        int maxValue = 100001;
        for(int[] a : dist){
            Arrays.fill(a,maxValue);
        }

        for(int row = 0;row<n;row++){
            for(int col = 0;col<m;col++){
                if(grid[row][col] == 'W'){
                    queue.add(new int[]{row,col});
                    dist[row][col] = 0;
                }
            }
        }
        while (!queue.isEmpty()){
            int[] arr = queue.poll();
            int distance = dist[arr[0]][arr[1]];
            for (int[] direction : directions) {
                int row = arr[0] + direction[0];
                int col = arr[1] + direction[1];
                if (row >= 0 && row < n && col >= 0 && col < m && grid[row][col] != 'N' && dist[row][col] == maxValue) {
                    dist[row][col] = distance + 1;
                    queue.add(new int[]{row, col});
                }
            }
        }

       for(int r = 0;r<n;r++){
           for(int c = 0;c<m;c++){
               if(grid[r][c] == 'W' || grid[r][c] == '.' ||  grid[r][c] == 'N'){
                   dist[r][c] = 0;
               }else if(dist[r][c] == maxValue){
                   dist[r][c] = -1;
               }else{
                   dist[r][c] = 2*dist[r][c];
               }
           }
       }

//       for (int[] ele : dist) {
//           System.out.println(Arrays.toString(ele));
//       }
       return dist;
    }

    private int helper(int[][] vis,char[][] grid,int sr,int sc,int time){
        if(sr < 0 || sr >= grid.length || sc < 0 || sc >= grid[0].length) return maxValue;
        else if(grid[sr][sc]=='W') return time;
        else if(vis[sr][sc] < maxValue) return vis[sr][sc];
        else if(grid[sr][sc]!='N') {
            int a = maxValue,b=maxValue,c=maxValue,d=maxValue;
            a = helper(vis, grid, sr, sc - 1, time + 1);
            b = helper(vis, grid, sr + 1, sc, time + 1);
            c = helper(vis, grid, sr - 1, sc, time + 1);
            d = helper(vis, grid, sr, sc + 1, time + 1);
            System.out.println("a=" + a + ",b=" + b + ",c=" + c + ",d=" + d);
            return vis[sr][sc] = Math.min(Math.min(Math.min(a,b),Math.min(c,d)),vis[sr][sc]);
        }
        return maxValue;
    }


}
