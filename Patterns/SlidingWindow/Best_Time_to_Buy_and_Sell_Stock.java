public class Best_Time_to_Buy_and_Sell_Stock {
    

    public int maxProfit(int[] prices) {

        int minPrice=prices[0];
        int maxProfit=0;
        for(int i=0;i<prices.length;i++){
            minPrice=Math.min(minPrice,prices[i]);
            maxProfit=Math.max(maxProfit,prices[i]-minPrice);
        }
        return maxProfit;
    }
}
