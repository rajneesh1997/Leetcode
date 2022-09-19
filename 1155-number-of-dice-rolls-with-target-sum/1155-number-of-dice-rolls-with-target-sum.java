class Solution {
    final int MOD = 1000000007;
    public int f(int n, int k, int target, int[][] dp){
        if(n == 0){
            if(target == 0)
                return 1;
            return 0;
        }
        if(dp[n][target] != -1) return dp[n][target];
        int ans = 0;
        for(int i = 1; i <= k; i++){
            if(target >= i)
                ans = (ans % 1000000007) + (f(n-1,k,target-i,dp) % 1000000007);
        }
        return dp[n][target] = (ans % 1000000007);
    }
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n+1][target+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return f(n,k,target,dp);
    }
}