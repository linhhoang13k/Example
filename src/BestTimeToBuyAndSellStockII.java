class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for(int b=1; b<prices.length; b++){
            if(prices[b]-prices[b-1]>0){
                maxProfit+=(prices[b] - prices[b-1]);
            }
        }
        return maxProfit;
    }
}

class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
      int maxProfit = 0;
        for(int b=0; b<prices.length; b++){
            for(int s=b+1; s<prices.length; s++){
                if(prices[s]-prices[b]>maxProfit){
                    maxProfit=prices[s]-prices[b];
                }
            }
        }
        return maxProfit;
    }
}