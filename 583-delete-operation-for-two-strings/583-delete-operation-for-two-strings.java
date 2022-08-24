class Solution {
    public int f(int i, int j, String word1, String word2, int[][] dp){
        if(i == 0 || j == 0)
            return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(word1.charAt(i-1) == word2.charAt(j-1))
            return dp[i][j] = 1 + f(i-1, j-1, word1, word2, dp);
        return dp[i][j] = Math.max(f(i, j-1, word1,word2,dp), f(i-1, j, word1, word2,dp));
    }
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        
        int[][] dp = new int[n+1][m+1];
        
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        
        int lcs = f(n,m,word1,word2,dp);
        
        return n + m - (2 * lcs);
    }
}