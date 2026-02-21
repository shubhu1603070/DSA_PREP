package newLearning.DP.LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem_354 {

    List<int[]> res;

    public int maxEnvelopes(int[][] envelopes) {

        Arrays.sort(envelopes, (o1, o2) -> {
            if(o1[0] != o2[0]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        });
        System.out.println(Arrays.toString(envelopes));

        int n = envelopes.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int res  = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(envelopes[i][0] >  envelopes[j][0] &&  envelopes[i][1] > envelopes[j][1]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return Arrays.stream(dp).max().getAsInt();
    }

    private int getDolls(int[][] envelopes){
        Arrays.sort(envelopes, (o1, o2) -> Integer.compare(o1[0],o2[0]));
        System.out.println(Arrays.toString(envelopes));
        res = new ArrayList<>();
        for (int[] envelope : envelopes) {
            for(int[] arr : res){
                System.out.println(Arrays.toString(arr));
            }
            int binaryIndex = binarySearch(res, envelope);
            if (binaryIndex == res.size()) {
                res.add(new int[]{envelope[0], envelope[1]});
            } else {
                res.set(binaryIndex, new int[]{envelope[0], envelope[1]});
            }
        }
        System.out.println(res);
        return res.size();
    }

    private int binarySearch(List<int[]> res, int[] envelope) {
        int left = 0,right = res.size();
        int index = right;
        while(left < right){
            int mid = left + (right - left)/2;
            //if the res.get(mid)
            int[] arr = res.get(mid);
            if(arr[0] < envelope[0] && arr[1] < envelope[1]){
                left = mid + 1;
            }else{
                index = right = mid;
            }
        }
        return index;
    }

}
