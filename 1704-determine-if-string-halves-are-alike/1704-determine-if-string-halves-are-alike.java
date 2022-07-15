class Solution {
    public int checkVowel(String s){
        String vowel = "aeiouAEIOU";
        int ans = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(vowel.indexOf(c) != -1)
                ans++;
        }
        return ans;
    }
    public boolean halvesAreAlike(String s) {
        int size = s.length();
        String first = s.substring(0,size/2);
        String second = s.substring(size/2,size);
        return checkVowel(first) == checkVowel(second);
    }
}