class Solution {
    public boolean check(int i, int j, String wrd){
        while(i < j){
            // System.out.println(wrd);
            // System.out.println(i + " " + j);
            if(wrd.charAt(i) != wrd.charAt(j))
                return false;
            i++; j--;
        }
        return true;
    }
    public int f(int i, String s,int[] dp){
        if(i == s.length()) return 0;
        if(dp[i] != -1) return dp[i];
        int ans = Integer.MAX_VALUE;
        for(int k = i; k < s.length(); k++){
            if(check(i,k,s)){
                ans = Math.min(ans, 1 + f(k+1,s,dp));
            }
        }
        return dp[i] = ans;
    }
    public int minCut(String s) {
        int[] dp = new int[s.length()];
        // Arrays.fill(dp,-1);
        // return f(0,s,dp) - 1;
        int n = s.length();
        
        for(int i = n-1; i > -1; i--){
            int ans = Integer.MAX_VALUE;
            for(int k = i; k < s.length(); k++){
                if(check(i,k,s)){
                    ans = Math.min(ans, 1 + f(k+1,s,dp));
                }
                dp[i] = ans;
            }
        }
        return dp[0] - 1;
    }
}