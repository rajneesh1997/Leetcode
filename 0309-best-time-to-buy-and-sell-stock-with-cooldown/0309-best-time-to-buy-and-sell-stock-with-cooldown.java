class Solution {
    public int f(int i, int stat, int n, int[] prices, int[][] dp){
        if(stat == 2) return 0;
        if(i >= n) return 0;
        int profit = 0;
        if(dp[i][stat] != -1) return dp[i][stat];
        if(stat == 1){
            profit = Math.max(-prices[i] + f(i+1,0,n,prices,dp),
                             0 + f(i+1,1,n,prices,dp));
        } else if(stat == 0){
            profit = Math.max(prices[i] + f(i+2,1,n,prices,dp),
                             0 + f(i+1,0,n,prices,dp));
        }
        return dp[i][stat] = profit;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        
        int[][] dp = new int[n][3];
        for(int[] row : dp)
            Arrays.fill(row,-1);
        
        return f(0,1,n,prices,dp);
    }
}