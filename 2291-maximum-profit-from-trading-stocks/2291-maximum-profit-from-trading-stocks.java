class Solution {
    public int f(int i, int budget, int[] present, int[] future,int[][] dp){
        if(i == 0){
            if(present[i] <= budget)
                return Math.max(0,future[i] - present[i]);
            return 0;
        }
        if(dp[i][budget] != -1) return dp[i][budget];
        int notPick = f(i-1,budget,present,future,dp);
        int pick = 0;
        if(present[i] <= budget)
            pick = future[i] - present[i] + f(i-1,budget-present[i],present,future,dp);
        return dp[i][budget] = Math.max(pick,notPick);
    }
    public int maximumProfit(int[] present, int[] future, int budget) {
        int n = present.length;
        
        int[][] dp = new int[n+1][budget+1];
        for(int[] row : dp)
            Arrays.fill(row,-1);
        return f(n-1,budget,present,future,dp);
    }
}