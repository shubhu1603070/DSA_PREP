package newLearning.LeetcodeWeekly;

import java.util.*;

public class Feb_489 {



  //Q1
  public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
    List<Integer> res = new ArrayList<>();
    Map<Integer,Integer> map = new HashMap<>();
    for(int b : bulbs){
      if(map.containsKey(b)){
        map.remove(b);
      }
      else map.put(b,1);
    }
    map.forEach((k,v) -> {
      if(v % 2 != 0) res.add(k);
    });
    Collections.sort(res);
    return res;
  }

  //Q2
  public int firstUniqueFreq(int[] arr) {
    Map<Integer, Integer> f1 = new HashMap<>();
    for (int a : arr) {
      f1.put(a, f1.getOrDefault(a, 0) + 1);
    }
    Map<Integer, Integer> f2 = new HashMap<>();
    for (int f : f1.values()) {
      f2.put(f, f2.getOrDefault(f, 0) + 1);
    }
    for (int a : arr) {
      if (f2.get(f1.get(a)) == 1) {
        return a;
      }
    }

    return -1;
  }

  //Q3
  public int almostPalindromic(String s) {
    int n = s.length();
    if(n <= 1) return 0;
    int ans = Integer.MIN_VALUE;
    char[] arr = s.toCharArray();
    for(int i = 0;i<n;i++){
      ans = Math.max(ans,expand(i,i,arr));
      ans = Math.max(ans,expand(i,i+1,arr));
    }
    return ans;
  }

  private int expand(int left, int right, char[] ch) {
    while (left >= 0 && right < ch.length) {
      if (ch[left] == ch[right]) {
        left--;
        right++;
      }else{
        int l1 = left-1,r1 = right;
        while(r1 < ch.length && l1 >= 0 && ch[r1] == ch[l1]){
          r1++;
          l1--;
        }
        int l2 = left,r2 = right+1;
        while(l2 >= 0 && r2 < ch.length && ch[l2] == ch[r2]){
          l2--;
          r2++;
        }
        return Math.max(r1-l1-1,r2-l2-1);
      }
    }
    return (left < 0 && right >= ch.length) ? (right-left-1) : (right - left);
  }


}
