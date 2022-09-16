class Solution {
    int n,m;
    int[][][] dp;
    public int f(int row, int j1, int j2, int[][] grid){
        if(j1 == j2)
            return 0;
        if(row == n-1){
            return grid[row][j1] + grid[row][j2];
        }
        if(dp[row][j1][j2] != -1) return dp[row][j1][j2];
        int ans = Integer.MIN_VALUE;
        for(int i = -1; i <= 1; i++){
            for(int j = -1; j <= 1; j++){
                if((j1+i) > m-1 || (j2+j) > m-1 || (j1+i) < 0 || (j2+j) < 0)
                    continue;
                ans = Math.max(ans , grid[row][j1] + grid[row][j2] + f(row+1,j1+i, j2+j, grid));
            }
        }
        return dp[row][j1][j2] = ans;
    }
    public int cherryPickup(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        dp = new int[n][m][m];
        for(int[][] first : dp){
            for(int[] second : first){
                Arrays.fill(second,-1);
            }
        }
        return f(0,0,m-1,grid);
    }
}