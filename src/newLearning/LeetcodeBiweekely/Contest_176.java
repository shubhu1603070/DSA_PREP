package newLearning.LeetcodeBiweekely;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Contest_176 {

  public String mapWordWeights(String[] words, int[] weights) {
    Map<Integer, Character> map = new HashMap<>();
    for (int i = 0; i < 26; i++) {
      map.put(i, (char) ('a' + i));
    }
    StringBuilder sb = new StringBuilder();
    for(String word : words){
      int sum = 0;
      for(char ch : word.toCharArray()){
        sum+=(ch-97);
      }
      System.out.println(sum);
      sb.append(map.get(Math.abs(27-(sum%26))));
    }
    return sb.toString();
  }

  static public long rob(int[] nums, int[] colors) {
    Long[][] memo = new Long[nums.length][2];
    return dfs(0, false, nums, colors, memo);
  }

  static private long dfs(int index, boolean prevTaken,
                   int[] nums, int[] colors,
                   Long[][] memo) {

    if (index >= nums.length) return 0;

    int taken = prevTaken ? 1 : 0;
    if (memo[index][taken] != null) return memo[index][taken];

    // OPTION 1 → skip current
    long notTake = dfs(index + 1, false, nums, colors, memo);

    // OPTION 2 → take current
    long take = 0;

    if (!prevTaken || colors[index] != colors[index - 1]) {
      take = nums[index] + dfs(index + 1, true, nums, colors, memo);
    }

    return memo[index][taken] = Math.max(take, notTake);
  }

  public int prefixConnected(String[] words, int k) {
    Map<String,Integer> map = new HashMap<>();
    for(String st : words){
      if(st.length() < k) continue;
      String substring = st.substring(0,k);
      map.put(substring,map.getOrDefault(substring,0)+1);
    }
    int count = 0;
    for(int value : map.values()){
      if(value >= 2) count++;
    }

    return count;

  }


  static public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
    if(n == 0) return Collections.emptyList();
    List<List<Integer>> graph = new ArrayList<>();
    char[] ch = s.toCharArray();
    List<Boolean> ans = new ArrayList<>();
    StringBuilder palString;
    boolean[] visited = new boolean[n];
    Arrays.fill(visited,false);

    Integer first = 0;
    for(int i = 0;i<n;i++) graph.add(new ArrayList<>());

    for(int[] e : edges){
      graph.get(e[0]).add(e[1]);
    }
    for(String str : queries){
      String[] s1 = str.split(" ");
      if(s1[0].equals("update")){
        ch[Integer.parseInt(s1[1])] = s1[2].charAt(0);
      }else{
        palString = new StringBuilder(ch[first]);
        palindrome(first,graph,visited,palString,ch);
        if(checkPalindrome(palString.toString())){
          ans.add(true);
        }else{
          ans.add(false);
        }
      }
    }
    System.out.println(ans);
    return ans;
  }

  static public boolean checkPalindrome(String str) {
    int i = 0;
    int j = str.length() - 1;
    System.out.println(str);
    char[] ch = str.toCharArray();
    while(i <= j){
      if(ch[i++] != ch[j--]) return false;
    }
    return true;
  }

  static public void palindrome(int ele,List<List<Integer>> graph,boolean[] vis,StringBuilder str,char[] ch){
    if(vis[ele]) return;
    vis[ele] = true;
    for(int child : graph.get(ele)){
      if(!vis[child]) {
        str.append(ch[child]);
        palindrome(child, graph, vis,str,ch);
      }
    }
  }

  public static void main(String[] args) {
//    palindromePath(3,new int[][]{{0,1},{1,2}},"aac",new String[]{"query 0 2","update 1 b","query 0 2"});
  }

}
