class Solution {
    public int f(int i, int j, int[] values,int[][] dp){
        if(i == j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int ans = Integer.MAX_VALUE;
        for(int k = i; k < j; k++){
            int steps = values[i-1] * values[k] * values[j] + f(i,k,values,dp) + f(k+1,j,values,dp);
            ans = Math.min(ans, steps);
        }
        return dp[i][j] = ans;
    }
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];
        
        // for(int[] row : dp)
        //     Arrays.fill(row,-1);
        
        // int ans = f(1,n-1,values,dp);
        
        // for(int[] row : dp){
        //     for(int cell : row){
        //         System.out.print(cell + " ");
        //     }
        //     System.out.println();
        // }
        
        // return ans;        
        for(int i = n-1; i > 0; i--){
            for(int j = i+1; j < n; j++){
                int ans = Integer.MAX_VALUE;
                for(int k = i; k < j; k++){
                    int steps = values[i-1] * values[k] * values[j] + f(i,k,values,dp) + f(k+1,j,values,dp);
                    ans = Math.min(ans, steps);
                }
                dp[i][j] = ans;
            }
        }
        return dp[1][n-1];
    }
}