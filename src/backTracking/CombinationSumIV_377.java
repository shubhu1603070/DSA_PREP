package backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumIV_377 {

    List<List<Integer>> res = new ArrayList<>();
    int count = 0;

    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int length = nums.length;
        dfs(0, length > 1 ? length -1:length, nums,target,0,new ArrayList<Integer>());
        return res.size();
    }

    private void dfs(int start,int end,int[] nums, int target,int sum, List<Integer> list) {
        System.out.println(list);
        if(sum>target) return;
        if(target == sum){
            System.out.println("Resulting list : "+list);
            res.add(new ArrayList<>(list));
            return;
        }
        for (int index = start; index <= end; index++) {
            if(sum+nums[index] > target) continue;
            list.add(nums[index]);
            dfs(end > 0 ? index%end>0?index%end-1:index%end : index,end,nums,target,sum+nums[index],list);
            list.remove(list.size()-1);
        }
    }

    List<Integer> list = new ArrayList<>();

    public int dfs1(int[] nums, int target) {
        if(target == 0) return 1;
        if(target < 0) return 0;
        int count = 0;
        for(int num : nums){
//            list.add(num);
            int result = dfs1(nums, target - num);
//            if(result > 0) System.out.println("Path using " + num + " → remaining: " + (target - num)+" List: "+list);
//            list.remove(list.size()-1);
            count+=result;
        }
        return count;
    }

}
