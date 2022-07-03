class Solution {
    public boolean isPalin(String word){
        int i = 0, j = word.length()-1;
        while(i <= j){
            if(word.charAt(i) != word.charAt(j))
                return false;
            i++; j--;
        }
        return true;
    }
    public String firstPalindrome(String[] words) {
        for(String word : words){
            if(isPalin(word))
                return word;
        }
        return "";
    }
}