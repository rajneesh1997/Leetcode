class Solution {
    public String getSubString(int i, int j, String str){
        String tmp = "";
        for(int k = i; k <= j ;k++){
            tmp = tmp + str.charAt(k);
        }
        return tmp;
    }
    public boolean f(int i, String s, List<String> wordDict, int[] dp){
        if(i == s.length()) return true;
        boolean ans = false;
        if(dp[i] != -1) return dp[i] == 1;
        for(int end = i; end < s.length(); end++){
            String wrd = getSubString(i,end,s);
            if(wordDict.contains(wrd)){
                ans = true && f(end+1,s,wordDict,dp);
            }
            if(ans){
                dp[i] = 1;
                return true;
            } 
        }
        dp[i] = ans ==  true ? 1 : 0;
        return ans;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return f(0,s,wordDict,dp);
    }
}