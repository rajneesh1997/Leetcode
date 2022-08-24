class Solution {
    public int f(int i, int j, String s, String t, int[][] dp){
        if(i == 0 || j == 0){
            return 0; 
        }
        if(dp[i][j] != -1) return dp[i][j];
        if(s.charAt(i-1) == t.charAt(j-1))
            return dp[i][j] = 1 + f(i-1, j-1, s, t, dp);
        return dp[i][j] = Math.max(f(i-1, j, s, t, dp), f(i, j-1, s, t, dp));
    }
    public int longestPalindromeSubseq(String s) {
        StringBuilder s2 = new StringBuilder(s);
        s2.reverse();
        String t = s2.toString();
        
        int n = s.length();
        int m = t.length();
        
        int[][] dp = new int[n+1][m+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        
        return f(n, m, s, t, dp);
    }
    public int minInsertions(String s) {
        return s.length() - longestPalindromeSubseq(s);
    }
}