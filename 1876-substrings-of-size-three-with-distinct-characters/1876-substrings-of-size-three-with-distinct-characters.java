class Solution {
    public int countGoodSubstrings(String s) {
        int ans = 0;
        for(int i = 0; i < s.length() - 2; i++){
            char a = s.charAt(i);
            char b = s.charAt(i+1);
            char c = s.charAt(i+2);
            if(a != b && b != c && a != c)
                ans++;
        }
        return ans;
    }
}