class Solution {
    public int f(int i, int buy, int count, int n, int[] prices, int[][][] dp){
        if(count == 0)  return 0;
        if(i == n){
            return 0;
        }
        if(dp[i][buy][count] != -1) return dp[i][buy][count];
        int profit = 0;
        if(buy == 1){
            profit = Math.max(-prices[i] + f(i+1,0,count,n,prices,dp),
                             0 + f(i+1,1,count,n,prices,dp));
        } else {
             profit = Math.max(prices[i] + f(i+1,1,count-1,n,prices,dp),
                              0 + f(i+1,0,count,n,prices,dp));
        }
        return dp[i][buy][count] = profit;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        
        int[][][] dp = new int[n][2][3];
        for(int[][] f : dp){
            for(int[] s : f){
                Arrays.fill(s,-1);
            }
        }
        
        return f(0,1,2,n,prices,dp);
    }
}