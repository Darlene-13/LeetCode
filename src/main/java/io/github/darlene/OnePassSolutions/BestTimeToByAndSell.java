package io.github.darlene.OnePassSolutions;

public class BestTimeToByAndSell {

    public int maxProfit(int [] prices){
        int minSoFar  = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++){
            minSoFar = Math.min(minSoFar, prices[i]);
            int residue  = prices[i] - minSoFar;
            maxProfit = Math.max(residue, maxProfit);
        }
        return maxProfit;
    }
}
