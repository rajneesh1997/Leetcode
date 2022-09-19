class Solution {
    public int f(int i, int[] nums, int k, int[] multipliers, int[][] dp){
        if(k == multipliers.length){
            return 0;
        }
        if(dp[i][k] != -1) return dp[i][k];
        int j = nums.length -1 -(k-i);
        int ans = Integer.MIN_VALUE;
        int start = nums[i] * multipliers[k] + f(i+1,nums,k+1,multipliers,dp);
        int end = nums[j] * multipliers[k] + f(i,nums,k+1, multipliers,dp);
        ans = Math.max(ans, Math.max(start,end));
        return dp[i][k] = ans;
    }
    public int maximumScore(int[] nums, int[] multipliers) {
        int n = nums.length;
        int m = multipliers.length;
        int[][] dp = new int[n+1][m+1];
        // for(int[] row : dp){
        //     Arrays.fill(row,-1);
        // }
        // return f(0, nums, 0, multipliers, dp);
        for(int i = n-1; i >= 0; i--){
            for(int k = m-1; k >= 0; k--){
                int j = nums.length -1 -(k-i);
                if(j < n){
                    int start = nums[i] * multipliers[k] + dp[i+1][k+1];
                    int end = nums[j] * multipliers[k] + dp[i][k+1];
                    dp[i][k] = Math.max(start, end);
                }
                
            }
        }
        return dp[0][0];
    }
}