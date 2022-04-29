class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 1) return 0;
        int ans = 0;
        int a = prices[0];
        for(int i = 1; i < prices.length ; i++){
            if(prices[i] < a){
                a = prices[i];
            }
            ans = Math.max(ans, prices[i] - a);
        }
        return ans;
    }
}