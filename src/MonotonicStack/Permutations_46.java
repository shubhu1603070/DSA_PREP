package MonotonicStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Permutations_46 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        dfs(nums,new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums,List<Integer> list) {
        if(list.size() == nums.length) {
            res.add(list);
            return;
        }
        for(int i = 0;i < nums.length;i++) {
            if(!list.contains(nums[i])) {
                list.add(nums[i]);
                dfs(nums, list);
                list.remove(list.size() - 1);
            }
        }
    }

    int count = 0;

    private void dfs1(int[] nums,List<Integer> list) {
        if(list.size() == nums.length) {
            Boolean aBoolean = list.stream().reduce(Integer::sum).map(n -> {
                int sqrt = ((int) Math.sqrt(n));
                return sqrt * sqrt == n;
            }).orElseGet(() -> Boolean.FALSE);
            count += aBoolean ? 1 : 0;
            return;
        }
        for (int num : nums) {
            if (!list.contains(num)) {
                list.add(num);
                dfs(nums, list);
                list.remove(list.size() - 1);
            }
        }
    }


}
