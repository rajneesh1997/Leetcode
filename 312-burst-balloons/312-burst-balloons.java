class Solution {
    public int f(int i, int j, int[] balloons, int[][] dp){
        if(i > j) return 0;
        if(i == j){
            return balloons[i-1] * balloons[i] * balloons[j+1];
        }
        if(dp[i][j] != -1) return dp[i][j];
        int ans = Integer.MIN_VALUE;
        for(int k = i; k <= j; k++){
            ans = Math.max(ans, balloons[i-1] * balloons[k] * balloons[j+1] + f(i,k-1,balloons,dp) + f(k+1,j,balloons,dp));
        }
        return dp[i][j] = ans;
    }
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] balloons = new int[n+2];
        int itr = 0;
        balloons[itr++] = 1;
        for(int ele : nums){
            balloons[itr++] = ele;
        }
        balloons[itr] = 1;
        
        int[][] dp = new int[n+2][n+2];
//         for(int[] row : dp)
//             Arrays.fill(row, -1);
        
//         return f(1,n,balloons,dp);
        
        for(int i = n; i >= 1; i--){
            for(int j = 1; j <=n; j++){
                if(i > j) continue;
                int ans = Integer.MIN_VALUE;
                for(int k = i; k <= j; k++){
                    // System.out.println(i + " " + j);
                    ans = Math.max(ans, (balloons[i-1] * balloons[k] * balloons[j+1]) + dp[i][k-1] + dp[k+1][j]);
                }
                dp[i][j] = ans;
            }
        }
        
        return dp[1][n];
    }
}