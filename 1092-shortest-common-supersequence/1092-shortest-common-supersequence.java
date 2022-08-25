class Solution {
    public String shortestCommonSupersequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        
        int[][] dp = new int[n+1][m+1];
        for(int j = 0; j <= m; j++)
            dp[0][j] = 0;
        for(int i = 0; i <= n; i++)
            dp[i][0] = 0;
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        
        String ans = "";
        int i = n, j = m;
        while(i > 0 && j > 0){
            if(text1.charAt(i-1) == text2.charAt(j-1)){
                ans = text1.charAt(i-1) + ans;
                i--; j--;
            } else {
                if(dp[i-1][j] > dp[i][j-1]){
                    ans = text1.charAt(i-1) + ans;
                    i--;
                } else {
                    ans = text2.charAt(j-1) + ans;
                    j--;
                }
            }
        }
        while(i > 0)
            ans = text1.charAt(--i) + ans;
        while(j > 0)
            ans = text2.charAt(--j) + ans;
        return ans;
    }
}