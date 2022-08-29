class Solution {
    public boolean compare(String a, String b){
        if(a.length() != b.length() + 1) return false;
        int first = 0;
        int second = 0;
        while(first < a.length() && second < b.length()){
            if(a.charAt(first) == b.charAt(second)){
                first++;
                second++;
            } else {
                first++;
            }
        }
        if(first == a.length() && second == b.length()) return true;
        if(first+1 == a.length() && second == b.length()) return true;
        return false;
    }                                        
    public int longestStrChain(String[] words) {
        Arrays.sort(words,(a,b) -> a.length() - b.length());
        int n = words.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int maxi = 1;
        // for(String w : words)
        //     System.out.println(w);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(compare(words[i],words[j]) && dp[j] + 1 > dp[i])
                    dp[i] = dp[j]+1;
            }
            maxi = Math.max(maxi,dp[i]);
        }
        // for(int i : dp)
        //     System.out.print(i + " ");
        return maxi;
    }
}