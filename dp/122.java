class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1){
            return 0;
        }
        int res = 0;
        int[] bouns = new int[prices.length - 1];
        for(int i = 1; i < prices.length; i++){
            bouns[i-1] = prices[i] - prices[i-1];
            if(bouns[i-1] > 0){
                res+=bouns[i-1];
            }
        }
        
        return res;
    }
}