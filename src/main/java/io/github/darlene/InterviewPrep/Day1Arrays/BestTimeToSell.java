package io.github.darlene.InterviewPrep.Day1Arrays;

/**
 * For us to get maximum profit we need to buy cheap sell expensive
 * Buy before we sell
 *  Input = array of prices(integer) output = Integer which is maximum profit
 *  We need to keep tabs of the maximum profit
 */

public class BestTimeToSell {
    public int maxProfit(int[] prices){
        int maxProfit = 0;
        int minPrice = prices[0];
        for(int i = 1; i < prices.length; i++){
            minPrice = Math.min(minPrice, prices[i]);
            int residue = prices[i] - minPrice;
            maxProfit = Math.max(maxProfit, residue);
        }

        return maxProfit;
    }
}