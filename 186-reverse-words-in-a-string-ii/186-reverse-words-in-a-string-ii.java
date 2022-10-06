class Solution {
    public void reverseWords(char[] s) {
        int j = 0;
        for(int i = 0; i < s.length; i++){
            if(s[i] == ' '){
                reverse(j,i-1,s);
                j = i+1;
            }
        }
        reverse(j,s.length-1,s);
        reverse(0,s.length-1,s);
    }
    public void reverse(int start, int end, char[] s){
        while(start < end){
            char b = s[start];
            s[start] = s[end];
            s[end] = b;
            start++; end--;
        }
    }
}