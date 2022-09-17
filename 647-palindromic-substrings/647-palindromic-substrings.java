class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int ans = 0;
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++){
            dp[i][i] = 1;
            if(i < n-1 && s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = 1;
                ans++;
            }
        }
        
        for(int k = 1; k < n; k++){
            for(int i = 0; i < n-k; i++){
                int j = i+k;
                if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == 1){
                    dp[i][j] = 1;
                    ans++;
                }
            }
        }
        return ans + n;
    }
}