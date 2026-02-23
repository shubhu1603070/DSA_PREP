package newLearning.LeetcodeWeekly.Feb_1;

public class Q4 {


    public static void main(String[] args) {
        System.out.println(longestAlternating(new int[]{2,1,3,2}));
        System.out.println(longestAlternating(new int[]{3,2,1,2,3,2,1}));
    }

    static public int longestAlternating(int[] nums) {
        //remove
        //not remove
        //take max
        int n = nums.length;
        if(n == 2 || n == 1) return 1;


        return Math.max(dfs(nums,1,2,0,true),dfs(nums,1,2,0,false));

    }

    static private int dfs(int[] nums,int low,int high,int prev,boolean flag){
            if(low >= nums.length || high >= nums.length) return 0;
            //0 < 2 > 1
            int a = 0,b = 0,c = 0,d = 0;
            if(flag) {
                if (nums[low] > nums[prev] && nums[low] > nums[high]) {
                    a = dfs(nums, low + 1, high + 1, low, false);
                } else {
                    b = dfs(nums, low + 1, high + 1, low, false);
                }
            }else { //2 > 0 < 1
                if (nums[low] < nums[prev] && nums[prev] < nums[high]) {
                    c = dfs(nums, low + 1, high + 1, low, true);
                } else {
                    d = dfs(nums, low + 1, high + 1, low, true);
                }
            }

        return Math.max(Math.max(a,b)+1,Math.max(c,d)+1);
    }

    private int dfs_(int[] nums){
        int n = nums.length;
        if(n <= 1) return 1;
        int u0,u1,d0,d1;
        u0 = u1 = d0 = d1 = 1;
        for(int idx = 1; idx < n; idx++){
            if(nums[idx] > nums[idx-1]){
                u1 = Math.max(u1,d0+1);
                u0 = d0+1;
            }else if(nums[idx] < nums[idx-1]){
                d1 = Math.max(d1,u0+1);
                d0 = u0+1;
            }else{
                u1 = Math.max(u1,u0);
                d1 = Math.max(d1,d0);
                u0 = d0 = 1;
            }
        }
        return Math.max(Math.max(u0,d0),Math.max(u1,d1));

    }

}
