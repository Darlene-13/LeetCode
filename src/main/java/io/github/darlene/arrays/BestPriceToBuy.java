package io.github.darlene.arrays;

public class BestPriceToBuy{
    public int maximumProfit(int [] prices){
        int minPriceSoFar = prices[0];
        int maxProfit = 0;

        for(int i = 0; i < prices.length; i++){
            minPriceSoFar = Math.min(prices[i], minPriceSoFar);
            maxProfit = Math.max(maxProfit, prices[i] - minPriceSoFar);
        }
        return maxProfit;
    }
}
