class Solution {
    public int f(int i, int j, int[] cuts,int[][] dp){
        if(i > j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int ans = Integer.MAX_VALUE;
        for(int k = i; k <= j; k++){
            int cost = cuts[j+1] - cuts[i-1] + f(i,k-1,cuts,dp) + f(k+1,j,cuts,dp);
            ans = Math.min(ans,cost);
        }
        return dp[i][j] = ans;
    }
    public int minCost(int n, int[] cuts) {
        int c = cuts.length;
        int[] nCuts = new int[c+2];
        int i = 0;
        nCuts[i++] = 0;
        for(int e : cuts)
            nCuts[i++] = e;
        nCuts[i] = n;
        Arrays.sort(nCuts);
        int[][] dp = new int[c+1][c+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return f(1,c,nCuts,dp);
    }
}