class Solution {
    public String reverseWords(String s) {
        int left = s.length()-1;
        String ans = "", temp = "";
        while(left > -1){
            if(s.charAt(left) == ' '){
                if(temp != "")
                    ans += temp + " ";
                temp = "";
                left--;
            } else {
                temp = s.charAt(left--) + temp;
            }
        }
        if(temp != "")
            ans += temp;
        return ans.trim();
    }
}