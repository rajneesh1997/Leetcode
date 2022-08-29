class Solution {
    public int f(int ind, int[] nums,int[] dp){
        if(ind >= nums.length-1)
            return 0;
        if(nums[ind] == 0)
            return 99999;
        if(dp[ind] != -1) return dp[ind];
        int steps = nums[ind];
        int ans = Integer.MAX_VALUE;
        for(int i = 1; i <= steps; i++){
            ans = Math.min(ans,1 + f(ind+i,nums,dp));
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