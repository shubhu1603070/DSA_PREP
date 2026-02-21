package newLearning.Backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Rat_In_Maze_GFG {


    public static void main(String[] args) {
        ratInMaze(new int[][]{{1, 0, 0, 0},{1, 1, 0, 1},{1, 1, 0, 0},{0, 1, 1, 1}});
        ratInMaze(new int[][]{{1, 1, 1},{1, 0, 1},{1, 1, 1}});
    }

//    int[][] sides = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    int n = 4;
    static public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        ArrayList<String> res = new ArrayList<>();
        dfs(maze,0,0,res,"",new boolean[maze.length][maze[0].length]);
        System.out.println(res);
        return res;
    }

    static private void dfs(int[][] maze, int row, int col, ArrayList<String> res, String str,boolean[][] visited){
        if(row < 0 || row >= maze.length || col < 0 || col >= maze[0].length || visited[row][col]) return;
        if(row == maze.length - 1 && col == maze[0].length - 1){
            res.add(str);
            return;
        }
        visited[row][col] = true;
        if(maze[row][col] == 1) {
            dfs(maze, row + 1, col, res, str+"D",visited);
            dfs(maze, row, col - 1, res, str+"L",visited);
            dfs(maze, row, col + 1, res, str+"R",visited);
            dfs(maze, row - 1, col, res, str+"U",visited);
        }
        visited[row][col] = false;
    }

}
