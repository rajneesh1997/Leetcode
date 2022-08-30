class Solution {
    public boolean f(int ind, int k, int[] stones, int[][] dp){
        if(ind == stones.length-1){
            return true;
        }
        if(dp[ind][k] != -1) return dp[ind][k] == 1 ? true : false;
        boolean ans = false;
        for(int i = ind+1; i < stones.length; i++){
            int toReach = stones[i];
            if(stones[ind]+k == toReach){
                ans = ans || f(i,k-1, stones,dp) || f(i,k, stones,dp) || f(i,k+1, stones,dp);
            }
        }
        if(ans){
            dp[ind][k] = 1;
        } else {
            dp[ind][k] = 0;
        }
        return ans;
    }
    public boolean canCross(int[] stones) {
        int n = stones.length;
        int[][] dp = new int[n][n];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return f(0,1,stones,dp);
    }
}