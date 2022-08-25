class Solution {
    public int f(int i, int j, String pattern, String text,int[][] dp){
        if(i == 0 && j == 0) return 1;
        if(i == 0 && j > 0) return 0;
        if(i > 0 && j == 0){
            for(int itr = i; itr > 0; itr--)
                if(pattern.charAt(itr-1) != '*')
                    return 0;
            return 1;
        }
        if(dp[i][j] != -1) return dp[i][j];
        if(pattern.charAt(i-1) == text.charAt(j-1) || pattern.charAt(i-1) == '?')
            return dp[i][j] = f(i-1,j-1,pattern,text,dp);
        if(pattern.charAt(i-1) == '*')
            return dp[i][j] = f(i-1,j,pattern,text,dp) |  f(i,j-1,pattern,text,dp);
        return dp[i][j] = 0;
    }
    public boolean isMatch(String text, String pattern) {
        int n = pattern.length();
        int m = text.length();
        
        int[][] dp = new int[n+1][m+1];
        dp[0][0] = 1;
        for(int j = 1; j <= m; j++)
            dp[0][j] = 0;
        for(int i = 1; i <= n; i++){
            boolean flag = true;
            for(int itr = i; itr > 0; itr--)
                if(pattern.charAt(itr-1) != '*'){
                    dp[i][0] = 0;
                    flag = false;
                    break;
                }
            if(flag)
                dp[i][0] = 1;
        }
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <=m; j++){
                if(pattern.charAt(i-1) == text.charAt(j-1) || pattern.charAt(i-1) == '?')
                    dp[i][j] = dp[i-1][j-1];
                else if(pattern.charAt(i-1) == '*')
                    dp[i][j] = dp[i-1][j] | dp[i][j-1];
                else dp[i][j] = 0;                
            }
        }
        
        return dp[n][m] != 0;
//         for(int[] row : dp)
//             Arrays.fill(row,-1);
        
//         return f(n,m,p,s,dp) != 0;
    }
}