class Solution {
    public int minSteps(String s, String t) {
        int[] chArr = new int[26];
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            chArr[ch-'a']++;
        }
        for(int i = 0; i < t.length(); i++){
            char ch = t.charAt(i);
            chArr[ch-'a']--;
        }
        int ans = 0;
        for(int i : chArr){
            if(i < 0)
                ans += i;
        }
            // System.out.println(i);
        return 0-ans;
    }
}