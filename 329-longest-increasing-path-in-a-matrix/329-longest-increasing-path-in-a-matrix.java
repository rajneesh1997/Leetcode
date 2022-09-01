class Solution {
    int[] dir = {0,1,0,-1,0};
    public int f(int i, int j, int[][] matrix, int[][] dp){
        if(dp[i][j] != -1) return dp[i][j];
        dp[i][j] = 1;
        int ans = 0;
        int val = matrix[i][j];  
        for(int k = 1; k < dir.length; k++){
            int nr = i + dir[k-1];
            int nc = j + dir[k];
            
            if(nr >= 0 && nr < matrix.length && nc >= 0 &&  nc < matrix[0].length){
                int nval = matrix[nr][nc];
                if(nval > val){
                    ans = Math.max(ans, f(nr,nc,matrix,dp));
                }
            }
        }
        return dp[i][j] += ans;
    }
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        int[][] dp = new int[n][m];
        for(int[] row : dp)
            Arrays.fill(row,-1);
        
        int ans = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                ans = Math.max(ans, f(i,j,matrix,dp));
            }
        }
        
        // for(int[] row : dp){
        //     for(int ele : row){
        //         System.out.print(ele + " ");
        //     }
        //     System.out.println();
        // }
        
        return ans;
    }
}