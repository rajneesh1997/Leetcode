class Solution {
    public int f(int i, int prev_i, int n, int[] nums,int[][] dp){
        if(i == n){
            return 0;
        }
        if(dp[i][prev_i+1] != -1) return dp[i][prev_i+1];
        int notPick = 0 + f(i+1, prev_i, n, nums, dp);
        int pick = 0;
        if(prev_i == -1 || nums[i] > nums[prev_i])
            pick = 1 + f(i+1,i,n,nums,dp);
        return dp[i][prev_i+1] = Math.max(pick, notPick);
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for(int[] row : dp)
            Arrays.fill(row,-1);
        
        return f(0,-1,n,nums,dp);
    }
}