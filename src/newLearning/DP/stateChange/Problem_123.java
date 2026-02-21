package newLearning.DP.stateChange;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem_123 {

    public int maxProfit(int[] prices) {
        int preMax = Integer.MIN_VALUE;
        List<Integer> list = new ArrayList<>();
        for (int i = prices.length-1; i >= 0 ; i--) {
            preMax = Math.max(preMax, prices[i]);
            int sell = preMax - prices[i];
            if(sell > 0){
                preMax = -1;
                list.add(sell);
            }
        }
        System.out.println(list);
        Collections.sort(list);
        if(list.size()>=2){
            return list.removeLast() + list.removeLast();
        }else if(list.size() == 1){
            return list.removeLast();
        }
        return 0;
    }

}
