package newLearning.Graph.Basics;

import java.util.Arrays;

public class Problem_733 {

    public static void main(String[] args) {
        Problem_733 p = new Problem_733();
//        p.floodFill(new int[][]{[1,1,1],[1,1,0],[1,0,1]},1,1,2);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[] dx = new int[]{-1,0,1,0,-1,-1,1,1};
        int[] dy = new int[]{0,1,0,-1,1,-1,-1,1};


        /*
                i,j = 3,3
                i,j = -1,0 => 2,3
                i,j = 0,1 => 3,4
                i,j = 1,0 => 4,3
                i,j = 0,-1 => 3,2
         */

        helper(image,sr,sc,image[sr][sc],color,dx,dy);
        return image;
    }

    private void helper(int[][] image,int sr,int sc,int oriVal,int color,int[] dx,int[] dy){
        //why image[sr][sc] == color because what if the color == oriVal
        if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != oriVal || image[sr][sc] == color) return;
        image[sr][sc] = color;
        helper(image,sr-1,sc,oriVal,color,dx,dy);
        helper(image,sr,sc+1,oriVal,color,dx,dy);
        helper(image,sr+1,sc,oriVal,color,dx,dy);
        helper(image,sr,sc-1,oriVal,color,dx,dy);

        //neighbor
        helper(image,sr-1,sc+1,oriVal,color,dx,dy);
        helper(image,sr-1,sc-1,oriVal,color,dx,dy);
        helper(image,sr+1,sc-1,oriVal,color,dx,dy);
        helper(image,sr+1,sc+1,oriVal,color,dx,dy);

    }

}
