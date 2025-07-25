package MonotonicStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII_47 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        dfs(nums,new ArrayList<>(), new boolean[nums.length]);
        return res;
    }

    private void dfs(int[] nums,List<Integer> list,boolean[] flag) {
        if(list.size() == nums.length) {
            res.add(list);
            return;
        }
        for(int i = 0;i < nums.length;i++) {
            System.out.println("List : "+list);
            if(flag[i] || (i > 0 && nums[i] == nums[i - 1] && !flag[i - 1])) continue;
            flag[i] = true;
            list.add(nums[i]);
            dfs(nums, list, flag);
            flag[i] = false;
            list.remove(list.size() - 1);
        }
    }

}
