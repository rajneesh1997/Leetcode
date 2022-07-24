class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] arr = new int[26];
        int ans = 0;
        int start = 0;
        int count = 0;
        for(int end = 0; end < s.length(); end++){
            arr[s.charAt(end)-'A']++;
            count = Math.max(count, arr[s.charAt(end)-'A']);
            while(end - start - count + 1 > k){
                arr[s.charAt(start)-'A']--;
                start++;
            }
            ans = Math.max(ans, end-start+1);
                
        }
        return ans;
    }
}