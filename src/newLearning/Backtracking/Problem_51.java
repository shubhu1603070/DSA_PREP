package newLearning.Backtracking;

import java.util.*;

public class Problem_51 {

    boolean[] rows;
    boolean[] cols;
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
      rows = new boolean[n+1];
      cols = new boolean[n+1];
      result = new ArrayList<>();
      String[][] board = new String[n][n];
      for(String[] b : board) Arrays.fill(b,".");
      dfs(board,new ArrayList<>(),n,
          0,0,0);
      return Collections.emptyList();
    }


    private void dfs(String[][] board,List<String> list,int n,
                     int queens,int row,int col){
      if(row < 0 || col < 0 || row >= n || col >= n) return;
      System.out.println(Arrays.deepToString(board));
      if(queens == n){
        System.out.println(list);
        return;
      }
      if(!rows[row]
          && !cols[col]
          && diagonal(row,col,board)){
        board[row][col] = "Q";
        list.add(row+","+col);
        rows[row] = true;
        cols[col] = true;
        dfs(board,list,n,queens+1,row+1,col+1);
        rows[row] = false;
        cols[col] = false;
        board[row][col] = ".";
        list.removeLast();
      }
    }

    private boolean diagonal(int r,int c,String[][] board){
      int row = r;
      int col = c;
      int col_ = c;
      while(row >= 0 && col >= 0 && col < board.length){
        if(board[row][col].equals("Q") || board[row][col_].equals("Q")){
          return false;
        }
        row--;
        col--;
        col_++;
      }
      row = r;
      col = c;
      col_ = c;
      while(row < board.length && col < board.length && col_ >= 0){
        if(board[row][col].equals("Q") || board[row][col_].equals("Q")){
          return false;
        }
        row++;
        col++;
        col_--;
      }
      return true;
    }



    public static void main(String[] args) {
        Problem_51 p = new Problem_51();
//        p.solveNQueens(4);
//        p.dominantIndices(new int[]{5,4,3});
//        p.dominantIndices(new int[]{4,1,2});
//        p.countSubarrays(new int[]{1,3,2},4);
      p.countSubarrays(new int[]{1,2,3},4);
      p.countSubarrays(new int[]{5,5,5,5,5},0);
//      p.mergeAdjacent(new int[]{3,1,1,2});
//      p.mergeAdjacent(new int[]{2,2,4});
    }


  public int dominantIndices(int[] nums) {
    int[] sum = new int[nums.length];
    int n = nums.length;
    sum[n-1] = nums[n-1];
//    System.out.println(Arrays.toString(sum));
    for(int i = n-2;i >= 0;i--){
      sum[i] = sum[i+1]+nums[i];
    }

//    for(int i = nums.length-2;i>=0;i--){
//      sum[i]+=nums[i+1];
//    }
    int count = 0;
//    System.out.println(Arrays.toString(sum));
    for(int i = 1;i<n;i++){
//      System.out.println("nums : "+nums[i-1] +" : "+(sum[i]/(n-i)));
      if(nums[i-1] > (sum[i] / (n - i))){
        count++;
      }
    }
//    System.out.println(count);
    return count;
  }

  public List<Long> mergeAdjacent(int[] nums) {
    Stack<Long> stack = new Stack<>();
    for (int num : nums) {
      if (!stack.isEmpty() && stack.peek() == num) {
        long sum = (long) num;
        while (!stack.isEmpty() && stack.peek() == sum) {
          sum *= 2;
          stack.pop();
        }
        stack.push(sum);
      } else {
        stack.push((long) num);
      }
    }
    return stack.stream().toList();
  }

  public long countSubarrays(int[] nums, long k) {
    long answer = 0;
    int n = nums.length;
    int left = 0;
    int right = 0;
    Deque<Integer> min = new ArrayDeque<>();
    Deque<Integer> max = new ArrayDeque<>();
    for(;right < n;right++){

      while(!max.isEmpty() && nums[max.peekLast()] <= nums[right]){
        max.pollLast();
      }
      max.offerLast(right);

      while(!min.isEmpty() && nums[min.peekLast()] >= nums[right]){
        min.pollLast();
      }
      min.offerLast(right);

      while(left <= right && !min.isEmpty() && !max.isEmpty()){
        long diff = (long) nums[max.peekFirst()] - nums[min.peekFirst()];
        long len = right - left + 1L;
        long cost = diff * len;
        if(cost <= k) break;
        if(max.peekFirst() == left) max.pollFirst();
        if(!min.isEmpty() && min.peekFirst() == left) min.pollFirst();
        left++;
      }

      answer += right - left + 1L;

    }

    System.out.println(answer);
    return answer;
  }

}
