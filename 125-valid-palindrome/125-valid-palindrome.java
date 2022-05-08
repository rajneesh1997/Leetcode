class Solution {
    public boolean isPalindrome(String s) {
        String str = "";
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            int ascii = (int)c;
            if((ascii >= 65 && ascii <= 90) ||  (ascii >= 97 && ascii <= 122) || (ascii >= 48 && ascii <= 57)){
                if((ascii >= 65 && ascii <= 90)){
                    str = str + (char)(ascii+32);
                } else {
                    str = str + c;
                }
            }
        }
        int i = 0, j = str.length()-1;
        while(i < j){
            if(str.charAt(i++) != str.charAt(j--))
                return false;
        }
        return true;
    }
}