class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        if(s.length() == 1) return 1;
        int i = 0, j = 1;
        HashMap<Character,Integer> map = new HashMap();
        map.put(s.charAt(0),1);
        int ans = 0;
        while(j < s.length()){
            char ch = s.charAt(j);
            if(!map.containsKey(ch)){
                map.put(ch,1);
            } else {
                int n = map.get(ch);
                map.put(ch,n+1);
            }
            if(map.get(ch) > 1){
               while(s.charAt(i) != ch){
                   int n = map.get(s.charAt(i));
                   map.put(s.charAt(i),n-1);
                   i++;
                }
                int n = map.get(s.charAt(i));
                map.put(s.charAt(i),n-1);
                i++;
            }
            ans = Math.max(j-i+1,ans);
            j++;
        }
        return ans;
    }
}