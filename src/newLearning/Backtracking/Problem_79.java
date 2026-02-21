package newLearning.Backtracking;

public class Problem_79 {

    public static void main(String[] args) {
        System.out.println(exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}},"ABCCED"));
    }

    static public boolean exist(char[][] board, String word) {
        boolean flag = false;
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[0].length; col++){
                if(board[row][col] == word.charAt(0)){
                    flag = dfs(board,row,col,0,word,new boolean[board.length][board.length]);
                    if(flag) break;
                }
            }
        }
        return flag;
    }


    static private boolean dfs(char[][] board, int row, int col,int index,String str,boolean[][] visited){
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col] || index >= str.length()) return false;
        visited[row][col] = true;
        if(str.charAt(0) == board[row][col]){
            System.out.println(str.substring(index));
            return  dfs(board,row,col+1,index+1,str,visited) ||
                    dfs(board,row,col-1,index+1,str,visited) ||
                    dfs(board,row+1,col,index+1,str,visited) ||
                    dfs(board,row-1,col,index+1,str,visited);
        }
        visited[row][col] = false;
        return false;
    }


}
