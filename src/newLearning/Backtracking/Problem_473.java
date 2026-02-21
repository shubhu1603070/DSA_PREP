package newLearning.Backtracking;

import java.util.*;

public class Problem_473 {

  public static void main(String[] args) {
    Problem_473 p = new Problem_473();
    System.out.println(p.makesquare(new int[]{1,1,2,2,2}));
//    System.out.println(p.makesquare(new int[]{3,3,3,3,4}));
//    System.out.println(p.makesquare(new int[]{2,4,4,8}));
//    System.out.println(p.makesquare(new int[]{5,5,5,5,4,4,4,4,3,3,3,3}));
  }

  public boolean makesquare(int[] matchsticks) {
    int total = Arrays.stream(matchsticks).sum();
    matchsticks = Arrays.stream(matchsticks).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
    if(total % 4 != 0) return false;
    dfs(0,0,total / 4,matchsticks);
    return count == 0;
  }
  int count = 4;
  List<Integer> list =  new ArrayList<>();
  List<List<Integer>> lists = new ArrayList<>();
  private void dfs(int index,int currentSum, int target, int[] matchsticks) {
    if(index >= matchsticks.length) return;
    if(currentSum == target) {
      System.out.println(list);
      currentSum = 0;
      count--;
    }
    if(count == 0 && list.size() == matchsticks.length){
      lists.add(new ArrayList<>(list));
    }
    list.add(matchsticks[index]);
    dfs(index + 1, currentSum + matchsticks[index], target, matchsticks);
    dfs(index + 1, currentSum, target, matchsticks);
    list.removeLast();
  }

}
