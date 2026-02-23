package newLearning.Graph.FloodFill;

public class Problem_200 {

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    boolean flag = dfs(grid,i,j);
                    if(flag) res++;
                }
            }
        }
        return res;
    }

    private boolean dfs(char[][] grid, int r, int c){
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) return false;
        if(grid[r][c] == '1') {
            grid[r][c] = '2';
            boolean down = dfs(grid, r + 1, c);
            boolean up = dfs(grid, r - 1, c);
            boolean right = dfs(grid, r, c + 1);
            boolean left = dfs(grid, r, c - 1);
            System.out.println(down + " " + up + " " + right + " " + left + " " + right);
            return down ||  up || right || left;
        }
        return false;
    }

}
