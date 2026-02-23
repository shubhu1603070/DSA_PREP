package newLearning.DP.stateChange;

public class Problem_122 {

    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for (int price : prices) {
            min = Math.min(min, price);
            profit = Math.max(price - min, profit);
        }
        int res = 0;
        int buy = prices[0];
        for(int i = 1;i<prices.length;i++){
            if(buy < 0) buy = prices[i];
            else{
                int sell = prices[i] - buy;
                if(sell>0){
                    res+=sell;
                    buy = -1;
                }
            }
        }
        return Math.max(res,profit);
    }

}
