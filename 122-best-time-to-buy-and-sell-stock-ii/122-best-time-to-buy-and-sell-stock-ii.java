class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 1) return 0;
        int i = 0, j = i + 1;
        int profit = 0, ans = 0;
        while(j < prices.length){
            if(prices[j] < prices[j-1]){
                ans += profit;
                profit = 0;
                i = j; j = i + 1;
            }
            else{
                profit = Math.max(profit, prices[j] - prices[i]);
                j++;
            }
        }
        if(profit > 0)
            ans += profit;
        return ans;
    }
}