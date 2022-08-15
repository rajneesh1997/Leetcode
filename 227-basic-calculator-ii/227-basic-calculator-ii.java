class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        int len = s.length();
        int currentNumber = 0, last = 0, ans = 0;
        char operation = '+';
        for(int i = 0; i < len; i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                currentNumber = (currentNumber * 10) + (c - '0');
            }
            if(!Character.isWhitespace(c) && !Character.isDigit(c) || i == len - 1){
                if(operation == '-' || operation == '+'){
                    ans += last;
                    last = (operation == '+') ? currentNumber : -currentNumber;
                }
                else if(operation == '*')
                    last *= currentNumber;
                else if(operation == '/')
                    last /= currentNumber;
                operation = c;
                currentNumber = 0;
            }
        }
        ans += last;
        return ans;
    }
}