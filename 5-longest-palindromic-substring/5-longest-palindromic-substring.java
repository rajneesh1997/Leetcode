class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int maxi = 0;
        String ans = "";
        for(int i = 0; i < n; i++){
            dp[i][i] = true;
            if(dp[i][i]){
                String str = s.substring(i,i+1);
                if(str.length() > maxi){
                    maxi = str.length();
                    ans = str;
                }
            }
        }
        for(int i = 0; i < n-1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = true;
            }
            if(dp[i][i+1]){
                String str = s.substring(i,i+2);
                if(str.length() > maxi){
                    maxi = str.length();
                    ans = str;
                }
            }
        }
        for(int k = 2; k < n; k++){
            for(int i = 0; i < n-k; i++){
                int j = i + k;
                dp[i][j] = dp[i+1][j-1] && (s.charAt(i) == s.charAt(j));
                
                if(dp[i][j]){
                    String str = s.substring(i,j+1);
                    if(str.length() > maxi){
                        maxi = str.length();
                        ans = str;
                    }
                }
            }
        }
        return ans;
    }
}