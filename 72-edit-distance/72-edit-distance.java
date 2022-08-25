class Solution {
    public int f(int i, int j, String str1, String str2, int[][] dp){
        if(j < 0) return i+1;
        if(i < 0) return j+1;
        if(dp[i][j] != -1) return dp[i][j];
        if(str1.charAt(i) == str2.charAt(j))
            return dp[i][j] = f(i-1,j-1,str1,str2,dp);
        return dp[i][j] = 1 + Math.min(f(i-1,j-1,str1,str2,dp), Math.min(f(i,j-1,str1,str2,dp), f(i-1,j,str1,str2,dp)));
    }
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        
        int[][] dp = new int[n][m];
        for(int[] row : dp)
            Arrays.fill(row,-1);
        
        return f(n-1,m-1,word1,word2,dp);
    }
}