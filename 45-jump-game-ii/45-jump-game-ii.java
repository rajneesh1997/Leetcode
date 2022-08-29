class Solution {
    public int f(int ind, int[] nums,int[] dp){
        if(ind == nums.length-1)
            return 0;
        if(dp[ind] != -1) return dp[ind];
        int steps = nums[ind];
        if(steps == 0) return dp[ind] = 999999;
        int ans = Integer.MAX_VALUE;
        
        for(int i = 1; i <= steps; i++){
            if(ind + i < nums.length){
                ans = Math.min(ans,1 + f(ind+i,nums,dp));
            }
        }
        return dp[ind] = ans;
    }
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return f(0,nums,dp);
    }
}