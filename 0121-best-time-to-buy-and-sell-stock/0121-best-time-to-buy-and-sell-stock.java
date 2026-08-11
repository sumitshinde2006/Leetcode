class Solution {
    public int maxProfit(int[] prices) {
        int small=prices[0];
        int profit=0;
        for(int i=0;i<prices.length;i++)
        {
            if(prices[i]<small)
                small=prices[i];

            int current =prices[i]-small;
            if(current>profit)
            profit=current;
        }   
        return profit;
    }
}