class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int[] after = new int[n];
        int[] before = new int[n];
        
        for(int i = 1; i < n; i++){
            if(s.charAt(i-1) == 'b')
                before[i] = 1 + before[i-1];
            else
                before[i] = before[i-1];
        }
        
        for(int i = n-2; i > -1; i--){
            if(s.charAt(i+1) == 'a')
                after[i] = 1 + after[i+1];
            else
                after[i] = after[i+1];
        }
        
        int ans = Integer.MAX_VALUE;
        
        for(int i = 0; i < n; i++)
            ans = Math.min(ans, after[i]+before[i]);
        
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}