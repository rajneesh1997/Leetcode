class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        if(s.length() == 1) return 1;
        if(s.length() == 2){
            if(s.charAt(0) == s.charAt(1))
                return 1;
            else
                return 2;
        }
        int[] chr = new int[26];
        int i = 0, j = 1;
        HashSet<Character> set = new HashSet<>();
        set.add(s.charAt(i));
        int size = s.length();
        int ans = 0;
        while(j < size){
            if(set.contains(s.charAt(j))){
                while(i <= j && set.contains(s.charAt(j))){
                    set.remove(s.charAt(i++));
                }
            } else {
                set.add(s.charAt(j++));
            }
            ans = Math.max(ans, set.size());
        }
        return ans;
    }
}