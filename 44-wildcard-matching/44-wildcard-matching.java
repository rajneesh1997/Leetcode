class Solution {
    public int f(int i, int j, String pattern, String text,int[][] dp){
        if(i < 0 && j < 0) return 1;
        if(i < 0 && j >= 0) return 0;
        if(i >= 0 && j < 0){
            for(int itr = i; itr > -1; itr--)
                if(pattern.charAt(itr) != '*')
                    return 0;
            return 1;
        }
        if(dp[i][j] != -1) return dp[i][j];
        if(pattern.charAt(i) == text.charAt(j) || pattern.charAt(i) == '?')
            return dp[i][j] = f(i-1,j-1,pattern,text,dp);
        if(pattern.charAt(i) == '*')
            return dp[i][j] = f(i-1,j,pattern,text,dp) |  f(i,j-1,pattern,text,dp);
        return dp[i][j] = 0;
    }
    public boolean isMatch(String s, String p) {
        int n = p.length();
        int m = s.length();
        
        int[][] dp = new int[n][m];
        for(int[] row : dp)
            Arrays.fill(row,-1);
        
        return f(n-1,m-1,p,s,dp) != 0;
    }
}